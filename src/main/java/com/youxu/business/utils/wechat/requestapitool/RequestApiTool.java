package com.youxu.business.utils.wechat.requestapitool;

import com.alibaba.fastjson.JSONObject;

import com.youxu.business.pojo.AccessToken;
import com.youxu.business.service.BaseService;
import com.youxu.business.utils.HttpTools.HttpResult;
import com.youxu.business.utils.HttpTools.HttpTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.annotation.Resource;
import java.util.Map;

/*通过code获取openid*/
@Configuration
@Component
public class RequestApiTool extends BaseService {

    @Autowired
    public HttpTool httpTool;

    @Resource
    private RequestApiTool requestApiTool;
  /*  @Bean
    public RestTemplate httpTool() {
        return new RestTemplate();
    }*/
    public  JSONObject  register(String code){
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        HttpMethod method = HttpMethod.GET;
        HttpResult results = httpTool.doHttp("https://api.weixin.qq.com/sns/jscode2session?appid=wx74808915eae21ef7&secret=493874f18e91e273fbf643cd9bea4de0&js_code="+code+"&grant_type=authorization_code",
                method, header, null,null);
        //1、使用JSONObject把刺符传对象转换成json对象
        JSONObject jsonObject= JSONObject.parseObject(results.getResult());
        return jsonObject;
    }
//获取accessToken
    public  JSONObject  getAccessToken(){
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        HttpMethod method = HttpMethod.GET;
        HttpResult results = httpTool.doHttp("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx74808915eae21ef7&secret=493874f18e91e273fbf643cd9bea4de0",
                method, header, null,null);
        //1、使用JSONObject把刺符传对象转换成json对象
        JSONObject jsonObject= JSONObject.parseObject(results.getResult());
        return jsonObject;
    }

    //微信平台获得accesstoken和更新状况
    public AccessToken getAccessTokenMethod() {
        String accessToken = null;
        JSONObject accessToken1 = requestApiTool.getAccessToken();//获取accessToken
        Map<String, Object> map = accessToken1;//获取JSONObject对象里面的accessToken
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey().equals("access_token")) {
                accessToken = String.valueOf(entry.getValue());
            }
        }
        AccessToken accessTokenNew = new AccessToken();
        accessTokenNew.setAccessToken(accessToken);
        return accessTokenNew;
    }
}
