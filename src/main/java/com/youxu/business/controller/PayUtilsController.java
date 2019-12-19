package com.youxu.business.controller;

import com.github.wxpay.sdk.WXPayUtil;
import com.youxu.business.pojo.Order;
import com.youxu.business.pojo.remotepojo.User;
import com.youxu.business.pojo.remotepojo.UserWallet;
import com.youxu.business.remoteinterface.MemberInterface;
import com.youxu.business.service.BaseService;
import com.youxu.business.service.OrderService;
import com.youxu.business.service.PayUtilsService;
import com.youxu.business.service.UserWalletService;
import com.youxu.business.utils.Enum.PayStatusEnum;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.Enum.SendSmsTemplateCodeEnum;
import com.youxu.business.utils.OtherUtil.ClientIPUtils;
import com.youxu.business.utils.OtherUtil.OSSUploadUtil;
import com.youxu.business.utils.OtherUtil.UploadUtils;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import com.youxu.business.utils.normalQRcode.QRCodeUtil;
import com.youxu.business.utils.pojotools.ResultGetIdPhotoNoWaterMarkAndTypeSettingUrl;
import com.youxu.business.utils.wechat.requestapitool.CommonRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.youxu.business.service.impl.OrderServiceImpl.fileTransToMultipartFile;

/**
 * Created with IntelliJ IDEA.
 * User: 解晨祥
 * Date: 2018/4/2
 * Time: 9:22
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Api(description = "支付")
@RestController
@RequestMapping("/api")
public class PayUtilsController extends BaseService {
    private final static Logger logger = LoggerFactory.getLogger(PayUtilsController.class);
    @Autowired
    private PayUtilsService payUtilsService;

    @Resource
    private MemberInterface memberInterface;

    @Resource
    private OrderService orderService;
    @Resource
    private UserWalletService userWalletService;

    @Resource
    private IdPhotoBusinessController idPhotoBusinessController;
    private String ip;


    /**
     * 订单支付
     *
     * @param request
     * @param order
     * @return
     */
    //微信签名+5个参数
    @ApiOperation(value = "微信签名+5个参数：支付", notes = "{\"id\":\"1465\" ,\"openId\":\"oM1Ip44WRFWLyHiSS_FujH_4U4ow\" ,\"orderAddresseeName\":\"李文轩\" ,\"orderActualMoney\":\"10\" ,\"userId\":\"1\" ,\"whetherMembers\":\"false\" ,\"orderConsumeMoney\":\"3\" ,\"vouchersIdList\":[ \"1\",\"2\" ]\n" +
            ",\"tradeType\":\"JSAPI\" }   tradeType支付类别：  JSAPI（小程序传）或NATIVE（b/s传）   ")
    @RequestMapping(value = "/wepay_sign", method = RequestMethod.POST)
    public ResponseMessage<Map> wepay_sign(HttpServletRequest request, @RequestBody Order order) {
        logger.info("Order---------------------------------------------------------------------------" + order.toString());
        // 会员支付
        if (order.getWhetherMembers()) {
            return memberPay(order);
        }
        /*ResponseMessage<UserWallet> userWalletResponseMessage = memberInterface.selectUserMemberByUserId(order.getUserId());
        UserWallet userWallet = userWalletResponseMessage.getData();
        // 会员卡钱不充足，走微信支付
        if (userWallet.getWalletBalance() > order.getOrderActualMoney()) {*/
        try {
            ip = ClientIPUtils.getIp(request);
            Map map = payUtilsService.wepay_orderSign(request, order.getOpenId(), order.getOrderAddresseeName(), order.getId().toString(), order.getOrderActualMoney(), ip, ORDERPAY, order.getTradeType());
            logger.info("微信签名+5个参数---------------------------------------------------------------------------" + map);
            List<Integer> vouchersIdList = order.getVouchersIdList();
            logger.info("vouchersIdList" + vouchersIdList);
            Double orderConsumeMoney = order.getOrderConsumeMoney();
            logger.info("orderConsumeMoney" + orderConsumeMoney);
            map.put("vouchersIdList", vouchersIdList);
            logger.info("vouchersIdList" + vouchersIdList);
            map.put("orderConsumeMoney", orderConsumeMoney);
            logger.info("orderConsumeMoney" + orderConsumeMoney);
            return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", map);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("支付异常：" + e.getMessage());
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), e.getMessage());
        }
        /*} else {
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), "消费金不足，请重新生成订单");
        }*/
    }

    //回调函数
    @ApiOperation(value = "回调函数", notes = "content（Map），openid，orderId")
    @RequestMapping(value = "/orderPayUrl", method = RequestMethod.POST)
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
                logger.info("微信回调返回商户订单号：" + transactionId);
                //修改账单状态为已完成
                //修改支付状态
                Order order = orderService.selectDeliveryFileByOrderId(orderId.toString());
                logger.info("订单对象：" + order.toString());
                Integer updateOrderPaySuccess = orderService.updateOrderPayDateAndProcessOverWrite(orderId, PayStatusEnum.PAYING.getValueCode());
                logger.info("更新订单为配送状态成功（1.成功）：" + updateOrderPaySuccess);
                if (updateOrderPaySuccess == 1) {
                    // 发送收获码
                    String commonRpc = CommonRpc.getCommonRpc(order.getOrderAddresseePhone(), "{\"code\":\"" + order.getDeliveryHarvestCode() + "\"}", SendSmsTemplateCodeEnum.HARVESTCODE.getTemplateCodeValue());
                    // 加积分
                    userWalletService.addUserWallet(order);
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
            logger.warn("回调：" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("回调：" + e.getMessage());
        }
    }

    // 会员支付订单
    private ResponseMessage memberPay(Order order) {
        // 判断是否为会员  isMembers:0非会员  1会员
        Integer orderId = order.getId();
        Integer updateOrderPayDateAndProcess = orderService.updateOrderPayDateAndProcess(orderId, PayStatusEnum.PAYING.getValueCode());
        if (updateOrderPayDateAndProcess >= 0) {
            // 发送收货人收获码
            String commonRpc = CommonRpc.getCommonRpc(order.getOrderAddresseePhone(), "{\"code\":\"" + order.getDeliveryHarvestCode() + "\"}", SendSmsTemplateCodeEnum.HARVESTCODE.getTemplateCodeValue());
            // 加积分
            userWalletService.addUserWallet(order);
            return Result.success("200", "钱包支付成功");
        }
        return Result.error("500.1", "支付失败");
    }

    @ApiOperation(value = "生成支付图片", notes = "")
    @RequestMapping(value = "/createPayQRCode", method = RequestMethod.POST)
    public ResponseMessage<String> createPayQRCode(String payUrl) {
        String imgPath = null;
        String uploadBlog = null;
        Date date = new Date();
        // 存放上传图片的文件夹
        File fileDir = UploadUtils.getImgDirFileCeshi(UploadUtils.IMG_PATH_PREFIX_QRcodeCeshi);
        // 生成的二维码的路径及名称
        String destPath = fileDir.getAbsolutePath() + File.separator + date.getTime() + ".png";
        // 生成二维码
        try {
            QRCodeUtil.encode(payUrl, imgPath, destPath, true);
            MultipartFile multipartFileQRCode = fileTransToMultipartFile(destPath);
            uploadBlog = OSSUploadUtil.uploadBlog(multipartFileQRCode, "barcode/");
        } catch (Exception e) {
            Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), "生成支付图片失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", uploadBlog);
    }

    /**
     * 仅保存电子版
     */
    @ApiOperation(value = "仅保存电子版", notes = "{\"userId\":\"52\" ,\"storeId\":\"1\" ,\"orderType\":\"1\" ,\"orderFromStoreGet\":\"1\" ,\"openId\":\"oM1Ip4xpQylMw8Io21SkJwsSytmg\" ,\"tradeType\":\"JSAPI\" ,\"orderActualMoney\":\"1\" ,\"idPhotoFileName\":\"18c8136a125011ea9b5e00163e0070b600054blue3\"}")
    @RequestMapping(value = "/onlySaveElectronic", method = RequestMethod.POST)
    public ResponseMessage<Map> onlySaveElectronic(HttpServletRequest request, @RequestBody Order order) {
        try {
            // 新增订单
            Integer orderId = orderService.insertOrder(order);
            logger.info("Order" + order.toString());
            logger.info("orderId:" + orderId);
            ip = ClientIPUtils.getIp(request);
            Map map = payUtilsService.wepay_orderSign(request, order.getOpenId(), "保存证件照", orderId.toString(), order.getOrderActualMoney(), ip, IDPHOTOSAVE, order.getTradeType());
            logger.info("微信签名+5个参数---------------------------------------------------------------------------" + map);
            // 根据fileName获取证件照无水印
            ResultGetIdPhotoNoWaterMarkAndTypeSettingUrl idPhotoNoWaterMarkAndTypeSettingUrlCopy = idPhotoBusinessController.getIdPhotoNoWaterMarkAndTypeSettingUrlCopy(order.getIdPhotoFileName(),app_key);
            logger.info("idPhotoNoWaterMarkAndTypeSettingUrlCopy：" + idPhotoNoWaterMarkAndTypeSettingUrlCopy);
            String file_name = idPhotoNoWaterMarkAndTypeSettingUrlCopy.getData().getFile_name();
            map.put("idPhotoUrl", file_name);
            logger.info("idPhotoUrl：" + file_name);
            return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", map);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), e.getMessage());
        }
    }

    /**
     * 根据fileName获取证件照无水印
     */
    private String getElectronicByFileName(String fileName) {

        return null;
    }

    @ApiOperation(value = "回调函数", notes = "content（Map），openid，orderId")
    @RequestMapping(value = "/idPhotoSave", method = RequestMethod.POST)
    public void idPhotoSave(HttpServletRequest request, HttpServletResponse response) {
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
                logger.info("微信回调返回商户订单号：" + transactionId);
                //修改账单状态为已完成
                //修改支付状态
                Order order = orderService.selectDeliveryFileByOrderId(orderId.toString());
                logger.info("订单对象：" + order.toString());
                Integer updateOrderPaySuccess = orderService.updateOrderPayDateAndProcessOverWrite(orderId, PayStatusEnum.COMPLETE.getValueCode());
                logger.info("更新订单为配送状态成功（1.成功）：" + updateOrderPaySuccess);
                if (updateOrderPaySuccess == 1) {
                    // 加积分
                    userWalletService.addUserWallet(order);
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
            logger.warn("回调：" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("回调：" + e.getMessage());
        }
    }

}