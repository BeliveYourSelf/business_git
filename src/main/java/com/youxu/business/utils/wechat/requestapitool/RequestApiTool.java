package com.youxu.business.utils.wechat.requestapitool;

import com.alibaba.fastjson.JSONObject;

import com.youxu.business.service.BaseService;
import com.youxu.business.utils.HttpTools.HttpResult;
import com.youxu.business.utils.HttpTools.HttpTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/*通过code获取openid*/
@Configuration
@Component
public class RequestApiTool extends BaseService {

    @Autowired
    public HttpTool httpTool;
  /*  @Bean
    public RestTemplate httpTool() {
        return new RestTemplate();
    }*/
    public  JSONObject  register(String code){
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        HttpMethod method = HttpMethod.GET;
        HttpResult results = httpTool.doHttp("https://api.weixin.qq.com/sns/jscode2session?appid=wx384e2f0feb85e291&secret=f90beb3dd4a360724bd9178feb2ec6f7&js_code="+code+"&grant_type=authorization_code",
                method, header, null,null);
        //1、使用JSONObject把刺符传对象转换成json对象
        JSONObject jsonObject= JSONObject.parseObject(results.getResult());
        return jsonObject;
    }
//获取accessToken
    public  JSONObject  getAccessToken(){
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        HttpMethod method = HttpMethod.GET;
        HttpResult results = httpTool.doHttp("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx384e2f0feb85e291&secret=f90beb3dd4a360724bd9178feb2ec6f7",
                method, header, null,null);
        //1、使用JSONObject把刺符传对象转换成json对象
        JSONObject jsonObject= JSONObject.parseObject(results.getResult());
        return jsonObject;
    }
}
