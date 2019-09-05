package com.youxu.business.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Andon on 2017/9/20.
 */
public class BaseService {
    private final static Logger logger = LoggerFactory.getLogger(BaseService.class);
    public String path = "http://lisheng-aricle.oss-cn-beijing.aliyuncs.com";
    public static String ali_endpoint = "oss-cn-beijing.aliyuncs.com";
    public static String ali_accesskey_id = "LTAIqKkqq1qxxp6V";
    public static String ali_accesskey_secret = "zrtMiZu72pwt1SFA8J1HnshhdXp5O1";
    public static String ali_logstorage = "lisheng-aricle";
    /**
     * 微信支付 APPID
     */
    public String WXPAYAPPID = "wx384e2f0feb85e291";
    /**
     * 微信支付 密约
     */
    public String WXPAYSECRET = "f90beb3dd4a360724bd9178feb2ec6f7";
    /**
     * 微信支付 商户号
     */
    public static String WXPAYMCHID = "1551028611";//番茄
    /**
     * 微信支付 APPID
     */
    public String WXPAYTRADETYPE;
    /**
     * 微信支付 回掉地址
     */
    public String WXPAYNOTIFYURL = "https://fqapi.lishengjt.com/api/wepay_codeUrl";
    public String WXPAYNOTIFYURLMEMBER = "https://fqapi.lishengjt.com/api/wepay_codeUrlMember";
    public String WXPAYNOTIFYURLSHOPPINGMALL = "https://fqapi.lishengjt.com/api/wepay_codeUrl_shopping_mall";
    public String WXPAYNOTIFYURLADMISSIONTICKET = "https://fqapi.lishengjt.com/api/payCallback_admission_ticket";


    /**
     * 微信支付 商户Key
     */
    public static String WXPAYKEY = "8374uieryeujkhk5y478hdnbasdjpqoi";
    /**
     * 微信支付 证书
     */
    public String WXPAYCERT;
    /**
     * 微信支付 证书
     */
    public String WXPAYREDIRECTURL;
    /**
     * 微信支付
     */
    public String WXPAYSCOPE = "snsapi_userinfo";
    /**
     * 微信支付
     */
    public String WXPAYCODEAPI = "https://open.weixin.qq.com/connect/oauth2/authorize?";
    /**
     * 微信支付
     */
    public String WXPAYACCESSTOKENURL;
    /**
     * 微信支付
     */
    public String WXPAYGRANTTYPE;

    /**
     * IOT 公共服务 APPID
     */
    @Value("${iot.sms.app.id}")
    public String IOTSMSAPPID;
    /**
     * IOT 公共服务 SECRET
     */
    @Value("${iot.sms.app.secret}")
    public String IOTSMSSECRATE;
    /**
     * IOT 公共服务 网关
     */
    @Value("${iot.sms.getway}")
    public String IOTSMSGETWAY;

    // ------------------------------------------------------------------证件照-----------------------------------------------
    /**
     * 证件照接口参数
     */
    //证件照环境监测接口参数
    String app_key = "e235edf918da000631b2814cfbaaad036e7f77be";
    String facepose = "50";
    String eyegaze = "50";
    String eyeskew = "50";
    String shoulderskew = "50";
    String darkillum = "50";
    String unbalanceillum = "50";
    String bfsimilarity = "50";


    /**
     * 3个证件照地址
     */
    // 证件照环境监测
//    @Value("http://apicall.id-photo-verify.com/api/env_pic")
    public String IDPHOTOBUSINESSLICENSEURL = "http://apicall.id-photo-verify.com/api/env_pic";
    //制作并检测证件照
//    @Value("http://apicall.id-photo-verify.com/api/cut_check_pic")
    public String IDPHOTOMAKEANDTESTURL = "http://apicall.id-photo-verify.com/api/cut_check_pic";
    //同时获取无水印单张和排版图片
//    @Value("http://apicall.id-photo-verify.com/api/take_cut_pic_v2")
    public String GETIDPHOTONOWATERMARKANDTYPESETTINGURL = "http://apicall.id-photo-verify.com/api/take_cut_pic_v2";
}
