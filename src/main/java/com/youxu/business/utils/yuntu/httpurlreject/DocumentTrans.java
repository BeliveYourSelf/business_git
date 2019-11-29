package com.youxu.business.utils.yuntu.httpurlreject;

import com.youxu.business.utils.yuntu.yuntupojo.ResultYuntu;
import net.sf.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class DocumentTrans {
    /**
     * 文件url转换成pdf对象
     *
     * @param valuePath
     * @return
     * @throws IOException
     */
    public static ResultYuntu getResultYuntuByUrl(String valuePath) throws IOException {
        InputStream connTransToPDFStream = null;
        JSONObject jsonObject = null;
        URL url = new URL(valuePath);
        HttpsURLConnection connTransToPDF = (HttpsURLConnection) url.openConnection();
        // 设置通用的请求属性
        connTransToPDF.setRequestProperty("Authorization", "APPCODE 01b3ca1a1fff41d188c90d2cdc70f8b6");
        connTransToPDF.setReadTimeout(50000);
        connTransToPDF.setConnectTimeout(50000);
        connTransToPDF.setRequestMethod("GET");
        connTransToPDF.connect();
        if (200 == connTransToPDF.getResponseCode()) {
            connTransToPDFStream = connTransToPDF.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(connTransToPDFStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            connTransToPDFStream.close();
            connTransToPDF.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        }
        String jsonString = com.alibaba.fastjson.JSONObject.toJSONString(jsonObject);
        ResultYuntu resultYuntu = com.alibaba.fastjson.JSONObject.parseObject(jsonString, ResultYuntu.class);
        return resultYuntu;
    }

    /**
     * 请求九云图api转换文件为pdf
     */
    public static String documentTransApiToPDF(String docmentUrl) throws IOException {
        int point = docmentUrl.lastIndexOf(".");
        String suffix = docmentUrl.substring(point);// 后缀pdf的文件不需要转换
        if (!".pdf".equals(suffix)) {
            String documentUrl = "https://api.9yuntu.cn/execute/Convert?docURL=" + URLEncoder.encode(docmentUrl) + "&outputType=pdf";// 拼接九云图路径
            // 文件url转换成pdf对象
            ResultYuntu resultYuntu = getResultYuntuByUrl(documentUrl);
            if (0 == resultYuntu.getRetCode()) {
                docmentUrl = resultYuntu.getOutputURLs()[0];
                return docmentUrl;
            }
        }
        return docmentUrl;//原始文件路径
    }
}
