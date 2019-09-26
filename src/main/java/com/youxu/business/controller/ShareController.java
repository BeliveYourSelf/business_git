package com.youxu.business.controller;

import com.github.wxpay.sdk.WXPayUtil;
import com.youxu.business.pojo.Document;
import com.youxu.business.pojo.Harvest;
import com.youxu.business.pojo.Order;
import com.youxu.business.pojo.Share;
import com.youxu.business.pojo.remotepojo.User;
import com.youxu.business.remoteinterface.MemberInterface;
import com.youxu.business.service.*;
import com.youxu.business.utils.Enum.PayStatusEnum;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.OtherUtil.ClientIPUtils;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import com.youxu.business.utils.transicatetool.DateTransform;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api")
@RestController
@Api(description = "分享表")
public class ShareController extends BaseService {
    private final static Logger logger = LoggerFactory.getLogger(ShareController.class);

    @Resource
    private ShareService shareService;

    @Resource
    private MemberInterface memberInterface;

    @Resource
    private PayUtilsService payUtilsService;

    @Resource
    private OrderService orderService;

    @Resource
    private DocumentService documentService;

    private String ip;

    @ApiOperation(value = "新增分享", notes = "{ \n" +
            "\"downloadDuplicatedPrintStatus\": 1\n" +
            ",\"resourcePrintMoney\":\"10\"\n" +
            ",\"resourceSaveDownloadMoney\": 10\n" +
            ", \"extactionCodeStatus\": true\n" +
            ", \"periodOfValidity\": \"2019-09-17T10:44:11.950Z\"\n" +
            ", \"shareUserId\": 1, \"usreHeadImage\": \"/image/4654653498/10231.jpeg\" ,\"shareContentUrl\":\"xxxxxxxxxxxxxxxx\" }    resourcePrintMoney：资源打印价格    resourceSaveDownloadMoney：资源转存下载价格   shareContentUrl:文件内容路径   downloadDuplicatedPrintStatus: 1.资源打印售价  2.资源转存下载售价 3.不可下载或转存    downloadDuplicatedPrintMoney: 资源打印售价/资源转存下载售价(double)  extactionCodeStatus: 是否有提取码(true/false)  ")
    @PostMapping("/insertShare")
    public ResponseMessage<Share> insertShare(@RequestBody Share share) throws ParseException {
        Share insertShare = shareService.insertShare(share);
        if (StringUtils.isEmpty(insertShare)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", insertShare);
    }

    @ApiOperation(value = "查看分享通过用户id和分享码", notes = "{\"shareUserId\":\"588\"\n" +
            ",\"extactionCode\":\"VQB9\"} shareUserId:分享人用户id   extactionCode：提取码")
    @PostMapping("/selectShareByUserIdAndExtactionCode")
    public ResponseMessage<Share> selectShareByUserIdAndExtactionCode(@RequestBody Share share) {
        Share selectShareByUserIdAndExtactionCode = shareService.selectShareByUserIdAndExtactionCode(share);
        if (StringUtils.isEmpty(selectShareByUserIdAndExtactionCode)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "已过期");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", selectShareByUserIdAndExtactionCode);
    }

    @ApiOperation(value = "再次分享", notes = "id   分享表的id")
    @GetMapping("/selectShareById")
    public ResponseMessage<Share> selectShareById(@RequestParam String id) {
        Share selectShareById = shareService.selectShareById(id);
        if (StringUtils.isEmpty(selectShareById)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", selectShareById);
    }

    @ApiOperation(value = "存入资料库/加入打印：支付", notes = "{\"id\":\"1\"\n" +
            ",\"shareUserId\":\"1\"\n" +
            ",\"extactionCodeStatus\":true\n" +
            ",\"extactionCode\":\"VVka\"\n" +
            ",\"userId\":\"1\"\n" +
            ",\"shareContentUrl\":\"xxx\"\n" +
            ",\"order\":{\n" +
            "   \"storeId\":\"1\"\n" +
            ",\"userId\":\"1\"\n" +
            ",\"orderActualMoney\":\"10\"\n" +
            ",\"orderType\":\"6\"\n" +
            ",\"orderProcess\":\"1\"\n" +
            ",\"openId\":\"oM1Ip44WRFWLyHiSS_FujH_4U4ow\"\n" +
            ",\"whetherMembers\":\"true\"\n" +
            "}}                    6.下载/存入资料库（分享支付）7.加入打印（分享支付）")
    @PostMapping("/downloadShare")
    public ResponseMessage<Map> downloadShare(HttpServletRequest request, @RequestBody Share share) {
        Share downloadShare = shareService.downloadShare(share);
        // 分享已过期
        if (!StringUtils.isEmpty(downloadShare) && StringUtils.isEmpty(expireDate(downloadShare))) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "文件过期");
        }
        // 提取码错误
        if (!StringUtils.isEmpty(downloadShare) && downloadShare.getExtactionCodeStatus() && !StringUtils.isEmpty(share.getExtactionCode()) && !(share.getExtactionCode().equals(downloadShare.getExtactionCode()))) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "提取码错误");
        }
        if (StringUtils.isEmpty(downloadShare)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        // 判断是否为会员
        Boolean whetherMembers = share.getOrder().getWhetherMembers();
        if (!whetherMembers) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "您不是会员");
        }
        // 调起支付
        ResponseMessage<Map> mapResponseMessage = wepay_sign(request, share);
        return mapResponseMessage;
    }

    /**
     * 调起支付
     *
     * @param request
     * @param
     * @return
     */

    public ResponseMessage<Map> wepay_sign(HttpServletRequest request, Share share) {
        Map<String, String> map = new HashMap<String, String>();
        // 新增订单
        orderService.insertOrderForMemberPrice(share);
        Integer orderId = orderService.lastInsertId();
        String body = null;
        Integer orderType = share.getOrder().getOrderType();
        String shareContentUrl = share.getShareContentUrl();
        try {
            ip = ClientIPUtils.getIp(request);
            if (orderType == 6) {
                body = "存入资料库";
                map = payUtilsService.wepay_orderSign(request, share.getOrder().getOpenId(), body, orderId.toString(), share.getOrder().getOrderActualMoney(), ip, DOWNLOADFOLDER);
            } else if (orderType == 7) {
                body = "加入打印";
                map = payUtilsService.wepay_orderSign(request, share.getOrder().getOpenId(), body, orderId.toString(), share.getOrder().getOrderActualMoney(), ip, DOWNLOADFOLDER);
            } else {
                return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), "orderType：此状态必须为6或7。6：下载/存入资料库（分享支付）7：加入打印（分享支付）");
            }
            map.put("shareContentUrl", shareContentUrl);
            logger.info("微信签名+5个参数---------------------------------------------------------------------------" + map);
            return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", map);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), e.getMessage());
        }
    }

    //回调函数
    @ApiOperation(value = "回调函数", notes = "content（Map），openid，orderId")
    @RequestMapping(value = "/downloadFolder", method = RequestMethod.POST)
    public void payCallback(HttpServletRequest request, HttpServletResponse response) {
        logger.info("微信回调接口方法 start------------------------------------------------------------------------------");
        logger.info("微信回调接口 操作逻辑 start-------------------------------------------------------------------------");
        String inputLine = "";
        String notityXml = "";
        try {
            while ((inputLine = request.getReader().readLine()) != null) {
                notityXml += inputLine;
            }
            //关闭流
            request.getReader().close();
            logger.info("微信回调内容信息：" + notityXml);
            //解析成Map
            Map<String, String> map = WXPayUtil.xmlToMap(notityXml);
            //判断 支付是否成功
            if ("SUCCESS".equals(map.get("result_code"))) {
                logger.info("微信回调返回是否支付成功：是");
                //获得 返回的商户订单号
                String outTradeNo = map.get("out_trade_no");
                logger.info("微信回调返回orderId：" + outTradeNo);
                Integer orderId = Integer.valueOf(outTradeNo);
                String transactionId = map.get("transaction_id");
                logger.info("微信回调返回文件路径：" + transactionId);
                // 修改订单状态
                Integer updateOrderCompelete = orderService.updateOrderCompelete(orderId);
                // ToDO
                // 修改分享人卡金额:根据userId和增加的金额更新卡金额
                if (updateOrderCompelete >= 0) {
                    logger.info("微信回调  订单号：" + outTradeNo + ",修改状态成功");
                    //封装 返回值
                    StringBuffer buffer = new StringBuffer();
                    buffer.append("<xml>");
                    buffer.append("<return_code>SUCCESS</return_code>");
                    buffer.append("<return_msg>OK</return_msg>");
                    buffer.append("</xml>");
                    //给微信服务器返回 成功标示 否则会一直询问 咱们服务器 是否回调成功
                    PrintWriter writer = response.getWriter();
                    //返回
                    writer.print(buffer.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "支付后转存", notes = "{\"userId\":\"1\"\n" +
            ",\"folderId\":\"1\"\n" +
            ",\"documentUrl\":\"xxx\"}     userId：支付人用户id   folderId：待存入的文件夹id    documentUrl：文件内容路径")
        @PostMapping("/insertPostPaymentStorage")
    public ResponseMessage insertPostPaymentStorage(@RequestBody Document document) {
        Integer insertDocument = documentService.insertDocument(document);
        if (insertDocument <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }


    public Share expireDate(Share shareNew) {
// 判断文件过期
        String periodOfValidity = shareNew.getPeriodOfValidity();
        Date periodOfValidityNew = DateTransform.stringFormatTransToDate(periodOfValidity);
        Date date = new Date();
        long nowTime = date.getTime();
        long periodOfValidityTime = periodOfValidityNew.getTime();
        if (nowTime - periodOfValidityTime > 0) {
            return null;  //过期
        }
        return shareNew;
    }

}
