package com.youxu.business.utils.HttpTools;


import com.alibaba.fastjson.JSON;
import com.youxu.business.service.BaseService;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.ognl.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;


/*1.调用api请求通过code获得openid等信息*/
@Component
public class HttpTool {
    private final static Logger logger = LoggerFactory.getLogger(BaseService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    /**
     *
     * @param url 地址
     * @param httpMethod 请求方式
     * @param headers 头
     * @param body 入参
     * @param contentType
     * @return
     */
    public HttpResult doHttp(String url, HttpMethod httpMethod, MultiValueMap<String, String> headers, String body,
                             String contentType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType type = MediaType.APPLICATION_JSON_UTF8;
        try {
            type = MediaType.valueOf(contentType);
        } catch (Exception ex) {
        }

        httpHeaders.setContentType(type);
        if (headers != null && headers.size() > 0) {
            httpHeaders.putAll(headers);
        }
        HttpEntity<String> formEntity = null;
        if (body == null || body.length() < 1) {
            formEntity = new HttpEntity<String>(httpHeaders);
        } else {
            formEntity = new HttpEntity<String>(body, httpHeaders);
        }
        String responseBody = "";
        HttpStatus httpStatus = HttpStatus.OK;

        boolean ifSuccess = false;
        try {
            ResponseEntity<String> result = restTemplate.exchange(url, httpMethod, formEntity, String.class);
            httpStatus = result.getStatusCode();
            responseBody = result.getBody();
            if (result.getStatusCode() == HttpStatus.OK) {
                ifSuccess = true;
            }
        } catch (HttpClientErrorException ex) {
            httpStatus = ex.getStatusCode();
            responseBody = ex.getResponseBodyAsString();
        } catch (HttpServerErrorException ex) {
            httpStatus = ex.getStatusCode();
            responseBody = ex.getResponseBodyAsString();
        } catch (Exception ex) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            responseBody = ex.getMessage();
        }
        long ts = System.currentTimeMillis();
        if (!ifSuccess) {
            HttpResult httpResult = HttpResult.fail(responseBody, httpStatus);
            httpResult.setTs(ts);
            return httpResult;
        } else {
            HttpResult httpResult = HttpResult.success(responseBody);
            httpResult.setTs(ts);
            return httpResult;
        }
    }


    /**liwenxuan：
     * use：公众号获取全局accesstoken
     * HttpsUtil方法https请求结果返回蔚json类型
     * @param Url http请求地址
     * @param Method http请求类型支持POST GET
     * @param Output
     * @return InputStream转换成JSONObject后返回
     * @throws Exception
     */
    public JSONObject HttpsUtil(String Url,String Method,String Output) throws Exception{
        JSONObject jsonObject = null;
        URL conn_url =  new URL(Url);
        HttpURLConnection conn = (HttpsURLConnection)conn_url.openConnection();
        conn.setRequestMethod(Method);
        conn.setReadTimeout(5000);
        conn.setConnectTimeout(5000);
        conn.connect();
        //output获取access_token是不会用到
        if(Output != null){
            OutputStream  outputstream =conn.getOutputStream();
            //字符集，防止出现中文乱码
            outputstream.write(Output.getBytes("UTF-8"));
            outputstream.close();
        }
        //正常返回代码为200
        if(conn.getResponseCode()==200){
            InputStream stream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(stream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            stream.close();
            conn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        }
        System.out.println(conn.getResponseCode());
        return jsonObject;
    }




    /**
     * post请求   httpClient
     * @param url --请求路径
     * @param jsonParam --内容
     * @param noNeedResponse --是否响应
     * @return
     */
    public static JSONObject httpPost(String url,JSONObject jsonParam, boolean noNeedResponse){
        //post请求返回结果
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        JSONObject jsonResult = null;
        HttpPost method = new HttpPost(url);
        try {
            if (null != jsonParam) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(method);
            url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                try {
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity());
                    if (noNeedResponse) {
                        return null;
                    }
                    /**把json字符串转换成json对象**/
                    jsonResult = JSONObject.fromObject(str);
                } catch (Exception e) {
                    logger.error("post请求提交失败:" + url, e);
                }
            }
        } catch (IOException e) {
            logger.error("post请求提交失败:" + url, e);
        }
        return jsonResult;
    }


}
