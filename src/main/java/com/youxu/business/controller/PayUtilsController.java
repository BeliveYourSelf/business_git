package com.youxu.business.controller;

import com.github.wxpay.sdk.WXPayUtil;
import com.youxu.business.pojo.Order;
import com.youxu.business.pojo.remotepojo.User;
import com.youxu.business.remoteinterface.MemberInterface;
import com.youxu.business.service.BaseService;
import com.youxu.business.service.OrderService;
import com.youxu.business.service.PayUtilsService;
import com.youxu.business.utils.Enum.PayStatusEnum;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.OtherUtil.ClientIPUtils;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
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
    private String ip;



    /**
     * 订单支付
     *
     * @param request
     * @param order
     * @return
     */
    //微信签名+5个参数
    @ApiOperation(value = "微信签名+5个参数：支付", notes = "id   openId  orderAddresseeName orderActualMoney")
    @RequestMapping(value = "/wepay_sign", method = RequestMethod.POST)
    public ResponseMessage<Map> wepay_sign(HttpServletRequest request, @RequestBody Order order) {
        // 判断是否为会员  isMembers:0非会员  1会员
        ResponseMessage<User> userResponseMessage = memberInterface.selectUserInfoByUId(order.getUserId());
        int isMembers = userResponseMessage.getData().getIsMembers();
        if(isMembers == 1){
        // 更新会员价格
        }
        // 会员卡钱不充足，走微信支付
            try {
                ip = ClientIPUtils.getIp(request);
                Map map = payUtilsService.wepay_orderSign(request, order.getOpenId(), order.getOrderAddresseeName(), order.getId().toString(), order.getOrderActualMoney(), ip, ORDERPAY);
                logger.info("微信签名+5个参数---------------------------------------------------------------------------" + map);
                return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", map);
            } catch (Exception e) {
                e.printStackTrace();
                return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), e.getMessage());
            }
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
                if (orderService.updateOrderPayDateAndProcess(PayStatusEnum.PAYING.getValueCode(), orderId, "支付时间") == 1) {
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

}