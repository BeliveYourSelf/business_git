package com.youxu.business.service;


import com.youxu.business.pojo.Order;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface PayUtilsService {
    String RSASign(Map<String, String> input);

//    ReturnResult go_pay(Map input, HttpServletRequest request) throws Exception;

//    ReturnResult query_pay(Map input, HttpServletRequest request) throws Exception;

    String wepay_sign(Map<String, String> input) throws Exception;

    String wepay_codeUrl(Map input, HttpServletRequest request, String openid, String body, String wx_trade_no, Double total_fee, String ip, String openId, String callbackPath,String tradeType) throws Exception;

    Map wepay_orderSign(HttpServletRequest request, String openid, String body, String orderId, Double total_fee, String ip, String callbackPath,String tradeType) throws Exception;

    // 获取拉起微信授权链接--
//    ReturnResult getWeixinCodeUrl(Map input, HttpServletRequest request) throws Exception;

    String sign(String content);



}
