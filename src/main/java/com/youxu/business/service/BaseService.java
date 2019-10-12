package com.youxu.business.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Andon on 2017/9/20.
 */
public class BaseService {
    private final static Logger logger = LoggerFactory.getLogger(BaseService.class);
    public String path = "http://youxu-print.oss-cn-beijing.aliyuncs.com";
    public static String ali_endpoint = "oss-cn-beijing.aliyuncs.com";
    // ali的发送短信和oss公用一个key
    public static String ali_accesskey_id = "LTAIdvojFwkg1aq7";
    public static String ali_accesskey_secret = "jsse6hma4a0EITy5wdkElpNSjXm2js";
    // 未使用日志存储
    public static String ali_logstorage = "youxu-print";
    /**
     * 微信支付 APPID
     */
    public String WXPAYAPPID = "wx74808915eae21ef7";
    /**
     * 微信支付 密约
     */
    public String WXPAYSECRET = "493874f18e91e273fbf643cd9bea4de0";
    /**
     * TODO 微信支付 商户号
     */
    public static String WXPAYMCHID = "1536452691";//有需
    /**
     * 微信支付 回掉地址
     */
    public String   DOWNLOADFOLDER = "https://yxapi.lishengjt.com/api/downloadFolder";
    public String   ORDERPAY = "https://yxapi.lishengjt.com/api/orderPayUrl";


    /**
     * TODO 微信支付 商户Key
     */
    public static String WXPAYKEY = "20190920youxuwenyinQAEHGFtYKMdsw";//有需
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
//--------------------------------------------------------------快递100----------------------------------------------------
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
    String app_key = "2abf79c1e6f1aa18583f6a38d05336eae9baf3e3"; // 有需
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
    //同时获取有水印单张
//    @Value("http://apicall.id-photo-verify.com/api/take_pic_wm/")
    public String GETIDPHOTOWATERMARKANDTYPESETTINGURL = "http://apicall.id-photo-verify.com/api/take_pic_wm/";
}
