package com.youxu.business.utils.baiducloud.facerecognition;


import com.alibaba.fastjson.JSONObject;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.youxu.business.pojo.DeliveryClerkInfo;
import com.youxu.business.utils.baiducloud.facerecognition.baiducloudutil.GsonUtils;
import com.youxu.business.utils.baiducloud.facerecognition.baiducloudutil.HttpUtil;
import com.youxu.business.utils.baiducloud.facerecognition.baiducloudutil.ResultObject;
import com.youxu.business.utils.baiducloud.facerecognition.baiducloudutil.ResultScore;
import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * 身份验证
 */
public class PersonVerify {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public ResultObject personverify(DeliveryClerkInfo deliveryClerkInfo) throws Exception {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/person/verify";
            Map<String, Object> map = new HashMap<>();
            map.put("image", deliveryClerkInfo.getImage());
            map.put("image_type", "BASE64");
            map.put("id_card_number", deliveryClerkInfo.getIdCardNum());
            map.put("liveness_control", "NORMAL");
            map.put("name", deliveryClerkInfo.getDeliveryClerkName());
            map.put("quality_control", "NORMAL");
            String param = GsonUtils.toJson(map);
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();
            String result = HttpUtil.post(url, accessToken, "application/json", param);
            ResultObject resultObject = new GsonBuilder().create().fromJson(result, ResultObject.class);
           /* ResultScore resultNew = resultObject.getResult();
            String score = resultNew.getScore();*/
            return resultObject;
    }
}
