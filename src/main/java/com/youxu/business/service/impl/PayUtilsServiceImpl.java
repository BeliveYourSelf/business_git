package com.youxu.business.service.impl;


import com.github.wxpay.sdk.WXPayUtil;
import com.youxu.business.service.BaseService;
import com.youxu.business.service.PayUtilsService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PayUtilsServiceImpl extends BaseService implements PayUtilsService {
private final static org.slf4j.Logger logger = LoggerFactory.getLogger(PayUtilsServiceImpl.class);
//返回prepay_id     第一次签名
    private Map goWePay(String body, String wx_trade_no, Double total_fee, String ip, String openId, String callbackPath,String tradeType) {
        Map<String, String> map = new HashMap<>();
        HttpURLConnection httpURLConnection = null;
        try {
            //设置请求参数（必须）
            String nonce_str = UUID.randomUUID().toString().trim().replaceAll("-", "");
            map.put("appid", WXPAYAPPID);
            map.put("mch_id", WXPAYMCHID);
            map.put("nonce_str", nonce_str);
            map.put("body", body);
            map.put("out_trade_no", wx_trade_no);
            Double total_fee_double = total_fee * 100;//入参单位为分
            Integer total_fee_int = total_fee_double.intValue();
            map.put("total_fee", total_fee_int.toString());
            map.put("spbill_create_ip", ip);
            map.put("notify_url", callbackPath);
            map.put("trade_type", tradeType);
            map.put("openid", openId);
            String sign = WXPayUtil.generateSignature(map, WXPAYKEY);
            map.put("sign", sign);
            String reqBody = null;
            reqBody = WXPayUtil.mapToXml(map);
            URL httpUrl = null;
            httpUrl = new URL("https://api.mch.weixin.qq.com/pay/unifiedorder");
            httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(10 * 1000);
            httpURLConnection.setReadTimeout(10 * 1000);
            httpURLConnection.connect();
            OutputStream outputStream = null;
            outputStream = httpURLConnection.getOutputStream();
            outputStream.write(reqBody.getBytes("UTF-8"));
            httpURLConnection.getOutputStream().flush();
            httpURLConnection.getOutputStream().close();
            //获取内容
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            final StringBuffer stringBuffer = new StringBuffer();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            map = WXPayUtil.xmlToMap(stringBuffer.toString());
            logger.warn("请求支付返回map===================================================================");
            logger.warn("map"+map.toString());
            logger.warn("请求支付返回map===================================================================");
            if (stringBuffer != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.info("bufferedReader.close();"+e.getMessage());
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.info("inputStream.close();"+e.getMessage());
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.info("outputStream.close();"+e.getMessage());
                }
            }
        } catch (Exception e) {
            map = null;
            logger.info("map = null;"+e.getMessage());
        }
        finally {
            if(httpURLConnection!=null) httpURLConnection.disconnect();
        }
        return map;
    }




    @Override
    public String RSASign(Map<String, String> input) {
        return null;
    }
//生成签名

    public String wepay_sign(Map<String, String> input) throws Exception {
        String signType = (String) input.get("signType");
        Map<String, String> map = new HashMap<>();
        map.put("appId", WXPAYAPPID);
        map.put("timeStamp", input.get("timeStamp"));
        map.put("nonceStr", input.get("nonceStr"));
        map.put("package", input.get("package"));
        map.put("signType", "MD5");
        String sign = "";
        if (signType.equalsIgnoreCase("MD5")) {
            sign = WXPayUtil.generateSignature(map, WXPAYKEY);
        }
        return sign;
    }



    //回调函数
    public String wepay_codeUrl(Map input, HttpServletRequest request, String openid, String body, String wx_trade_no, Double total_fee, String ip, String openId, String callbackPath,String tradeType) throws Exception {
//        returnResult1 = go_pay(input, request);//      修改支付成功--修改已完成
        PayUtilsServiceImpl payUtilsService = new PayUtilsServiceImpl();
        Map goWePay = payUtilsService.goWePay(body, wx_trade_no, total_fee, ip, openId, callbackPath,tradeType);
        String prepay_id = (String) goWePay.get("prepay_id");
        Map<String, String> map = new HashMap<>();
        map.put("appId", WXPAYAPPID);
        map.put("timeStamp", Long.toString(new Date().getTime()));
        map.put("nonceStr", UUID.randomUUID().toString().trim().replaceAll("-", ""));
        map.put("package", "prepay_id=" + prepay_id);
        map.put("signType", "MD5");
        map.put("paySign", wepay_sign(map));
//        returnResult.setResultMessage(ResultCode.SUCCESS.value());
        String redirect = URLEncoder.encode("totalDouble=" + input.get("totalDouble") + "&orderId=" + Integer.parseInt(input.get("orderId").toString()) + "&payMethod=" + input.get("payMethod"));
        String wxpayredirecturl = input.get("httpMethod").toString().equals("https:") ? WXPAYREDIRECTURL : WXPAYREDIRECTURL.replace("https", "http");
        String codeUrl = WXPAYCODEAPI + "appid=" + WXPAYAPPID + "&redirect_uri=" + wxpayredirecturl + redirect + "&response_type=code&scope=" + WXPAYSCOPE + "&state=" + UUID.randomUUID().toString() + "#wechat_redirect";
        return codeUrl;
    }

    //再次签名：    //微信签名+5个参数
    public Map wepay_orderSign(HttpServletRequest request, String openid, String body, String orderId, Double total_fee, String ip, String callbackPath,String tradeType) throws Exception {
        Map goWePay = goWePay(body, orderId, total_fee, ip, openid, callbackPath, tradeType);
        String prepay_id = (String) goWePay.get("prepay_id");
        String code_url = (String) goWePay.get("code_url");
        Map<String, String> map = new HashMap<>();
        map.put("appId", WXPAYAPPID);
        map.put("timeStamp", String.valueOf(new Date().getTime() / 1000));
        map.put("nonceStr", UUID.randomUUID().toString().trim().replaceAll("-", ""));
        map.put("package", "prepay_id=" + prepay_id);
        map.put("signType", "MD5");
        map.put("paySign", wepay_sign(map));
        map.put("code_url",code_url);
        return map;
    }

    @Override
    public String sign(String content) {
        return null;
    }


}
