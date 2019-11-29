package com.youxu.business.utils.wechat.requestapitool;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.youxu.business.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发送短信
 */
public class CommonRpc extends BaseService{
private final static Logger logger = LoggerFactory.getLogger(CommonRpc.class);
    public static String getCommonRpc(String mobilePhone,String param,String sendSmsTemplateCodeEnum) {
        DefaultProfile profile = DefaultProfile.getProfile("default", ali_accesskey_id, ali_accesskey_secret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers",mobilePhone);
        request.putQueryParameter("TemplateCode",sendSmsTemplateCodeEnum);
        request.putQueryParameter("SignName","有需文印");
        request.putQueryParameter("TemplateParam", param);

        try {
            CommonResponse response = client.getCommonResponse(request);
            logger.warn("发送验证码响应："+response.getData().toString());
            return response.getData();
        } catch (ServerException e) {
            e.printStackTrace();
            logger.warn("发送验证码错误："+e.getMessage());
        } catch (ClientException e) {
            e.printStackTrace();
            logger.warn("发送验证码错误："+e.getMessage());
        }
        return "false";
    }
}
