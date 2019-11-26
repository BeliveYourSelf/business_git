package com.youxu.business.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.GsonBuilder;
import com.youxu.business.pojo.idphotonewadd.BackgroundColor;
import com.youxu.business.pojo.idphotonewadd.CutChangeClothes;
import com.youxu.business.pojo.idphotonewadd.CutChangeClothesResult;
import com.youxu.business.pojo.idphotonewadd.GetSpecs;
import com.youxu.business.utils.HttpTools.HttpToolOther;
import com.youxu.business.utils.pojotools.*;
import net.sf.json.JSONObject;
import com.youxu.business.pojo.IdPhotoBusiness;
import com.youxu.business.service.BaseService;
import com.youxu.business.service.IdPhotoBusinessService;
import com.youxu.business.utils.HttpTools.HttpResult;
import com.youxu.business.utils.HttpTools.HttpTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.annotation.Resource;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class IdPhotoBusinessServiceImpl extends BaseService implements IdPhotoBusinessService {
    private final static Logger logger = LoggerFactory.getLogger(IdPhotoBusinessServiceImpl.class);
    @Resource
    private HttpTool httpTool;

    @Override
    public IdPhotoBusiness makeIdPhoto(IdPhotoBusiness idPhotoBusiness) throws Exception {
        IdPhotoBusiness idPhotoBusinessNew = threeIntegrationOfIdPhotoBusiness(idPhotoBusiness);
        return idPhotoBusinessNew;
    }

    @Override
    public GetSpecs getSpecs(String specId) throws Exception {
        String requestPath = GETIDPHOTOSPECBYID + specId;
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        HttpMethod method = HttpMethod.GET;
        HttpResult results = httpTool.doHttp(requestPath, method, header, null, null);
        com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(results.getResult());
        String jsonObjectString = com.alibaba.fastjson.JSONObject.toJSONString(jsonObject);
        GetSpecs getSpecs = com.alibaba.fastjson.JSONObject.parseObject(jsonObjectString, GetSpecs.class);
        String background_color = getSpecs.getBackground_color();
        List<BackgroundColor> backgroundColorList = JSONArray.parseArray(background_color, BackgroundColor.class);
        getSpecs.setBackground_color_List(backgroundColorList);
        return getSpecs;
    }

    /**
     * 更换背景
     * @param idPhotoBusiness
     * @return
     */
    @Override
    public IdPhotoBusiness udpateBackGroundColor(IdPhotoBusiness idPhotoBusiness) throws Exception {
        IdPhotoBusiness idPhotoBusinessNew = updateIdPhotoBusiness(idPhotoBusiness);
        return idPhotoBusinessNew;
    }

    @Override
    public void getIdPhotoWaterMarkByFileName(String fileName, HttpServletResponse response) throws IOException {
        String requestPath = GETIDPHOTOWATERMARKANDTYPESETTINGURL + fileName;
        // 获取输入流
        URL url = new URL(null, requestPath, new sun.net.www.protocol.https.Handler());
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        // 向输出流写入
        InputStream inputStream = connection.getInputStream();
        response.setHeader("content-type","text/html;charset=utf-8");
//        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
//        IOUtils.copy(inputStream, outputStream);
        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        // 所读取的内容使用n来接收
        int n = 0;
        byte[] bytes = new byte[1024];
        while((n = inputStream.read(bytes)) != -1){
            // 将字节数组的数据全部输出到输出流
            outputStream.write(bytes,0,n);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }

    @Override
    public CutChangeClothesResult cutChangeClothes(CutChangeClothes cutChangeClothes) {
        JSONObject jsonObject = JSONObject.fromObject(cutChangeClothes);
        JSONObject jsonObjectNew = HttpTool.httpPost(CUTCHANGECLOTHES, jsonObject, false);
        String jsonString = com.alibaba.fastjson.JSONObject.toJSONString(jsonObjectNew);
        CutChangeClothesResult cutChangeClothesResult = com.alibaba.fastjson.JSONObject.parseObject(jsonString, CutChangeClothesResult.class);
        return cutChangeClothesResult;
    }

    /**
     * 整合证件照三个接口-更换证件照背景
     */
    private IdPhotoBusiness updateIdPhotoBusiness(IdPhotoBusiness idPhotoBusiness) throws Exception {
        IdPhotoBusiness idPhotoBusinessStatus = new IdPhotoBusiness();
        IdPhotoBusinessServiceImpl idPhotoBusinessService = new IdPhotoBusinessServiceImpl();
        // 接口1：证件照环境监测
        ResultIdPhotoBusinessLicenses resultIdPhotoBusinessLicenses = idPhotoBusinessService.idPhotoBusinessLicenses(idPhotoBusiness.getBase64());
        String codeResultIdPhotoBusinessLicenses = resultIdPhotoBusinessLicenses.getCode();
        if (!"200".equals(codeResultIdPhotoBusinessLicenses)) {
            idPhotoBusinessStatus.setCode(Integer.valueOf(codeResultIdPhotoBusinessLicenses));
            idPhotoBusinessStatus.setMessage(resultIdPhotoBusinessLicenses.getMsg());
            return idPhotoBusinessStatus;
        }
        // 接口2：制作并检测证件照
        ResultIdPhotoMarkAndTest resultIdPhotoMarkAndTest = idPhotoBusinessService.idPhotoMarkAndTest(idPhotoBusiness.getBase64(), idPhotoBusiness.getSpecId(), idPhotoBusiness.getBackgroundColorList());
        String codeResultIdPhotoMarkAndTest = resultIdPhotoMarkAndTest.getCode();
        if (!"200".equals(codeResultIdPhotoMarkAndTest)) {
            idPhotoBusinessStatus.setCode(Integer.valueOf(codeResultIdPhotoMarkAndTest));
            idPhotoBusinessStatus.setMessage("制作并检测证件照失败");
            return idPhotoBusinessStatus;
        }
        idPhotoBusinessStatus.setResultIdPhotoMarkAndTest(resultIdPhotoMarkAndTest);
        return idPhotoBusinessStatus;
    }

    /**
     * 整合证件照三个接口-original
     */
    private IdPhotoBusiness threeIntegrationOfIdPhotoBusiness(IdPhotoBusiness idPhotoBusiness) throws Exception {
        IdPhotoBusiness idPhotoBusinessStatus = new IdPhotoBusiness();
        IdPhotoBusinessServiceImpl idPhotoBusinessService = new IdPhotoBusinessServiceImpl();
        // 接口1：证件照环境监测
        ResultIdPhotoBusinessLicenses resultIdPhotoBusinessLicenses = idPhotoBusinessService.idPhotoBusinessLicenses(idPhotoBusiness.getBase64());
        String codeResultIdPhotoBusinessLicenses = resultIdPhotoBusinessLicenses.getCode();
        if (!"200".equals(codeResultIdPhotoBusinessLicenses)) {
            idPhotoBusinessStatus.setCode(Integer.valueOf(codeResultIdPhotoBusinessLicenses));
            idPhotoBusinessStatus.setMessage(resultIdPhotoBusinessLicenses.getMsg());
            return idPhotoBusinessStatus;
        }
        // 接口2：制作并检测证件照
        ResultIdPhotoMarkAndTest resultIdPhotoMarkAndTest = idPhotoBusinessService.idPhotoMarkAndTest(idPhotoBusiness.getBase64(), idPhotoBusiness.getSpecId(), null);
        String codeResultIdPhotoMarkAndTest = resultIdPhotoMarkAndTest.getCode();
        if (!"200".equals(codeResultIdPhotoMarkAndTest)) {
            idPhotoBusinessStatus.setCode(Integer.valueOf(codeResultIdPhotoMarkAndTest));
            idPhotoBusinessStatus.setMessage("制作并检测证件照失败");
            return idPhotoBusinessStatus;
        }
        // 接口3:同时获取无水印单张和排版图片
        String name = resultIdPhotoMarkAndTest.getResult().getCheck_result().getName();
        String[] file_name = resultIdPhotoMarkAndTest.getResult().getFile_name();//无水印图片名字，包括多种可选颜色
        String[] file_name_print = resultIdPhotoMarkAndTest.getResult().getFile_name_print();//无水印排版图片名字，包括多种可选颜色
        ResultGetIdPhotoNoWaterMarkAndTypeSettingUrl idPhotoNoWaterMarkAndTypeSettingUrl = idPhotoBusinessService.getIdPhotoNoWaterMarkAndTypeSettingUrl(file_name[0]);
        String code = idPhotoNoWaterMarkAndTypeSettingUrl.getData().getCode();
        if (!"200".equals(code)) {
            idPhotoBusinessStatus.setCode(Integer.valueOf(codeResultIdPhotoMarkAndTest));
            idPhotoBusinessStatus.setMessage("制作并检测证件照失败");
            return idPhotoBusinessStatus;
        }
        ResultGetIdPhotoNoWaterMarkAndTypeSettingUrlObject data = idPhotoNoWaterMarkAndTypeSettingUrl.getData();
        String file_nameUrl = data.getFile_name();
        String file_name_list = data.getFile_name_list();
        idPhotoBusinessStatus.setCode(200);
        idPhotoBusinessStatus.setMessage("成功");
        idPhotoBusinessStatus.setSpecId(idPhotoBusiness.getSpecId());
        idPhotoBusinessStatus.setPictureUrl(file_nameUrl);
        return idPhotoBusinessStatus;
    }

    /**
     * 接口1：证件照环境监测
     */
    private ResultIdPhotoBusinessLicenses idPhotoBusinessLicenses(String base64Picture) throws Exception {
        IdPhotoBusinessLicenses idPhotoBusinessLicenses = new IdPhotoBusinessLicenses();
        idPhotoBusinessLicenses.setFile(base64Picture);
        JSONObject jsonObjectIdPhotoBusinessLicenses = JSONObject.fromObject(idPhotoBusinessLicenses);
        JSONObject jsonObject = HttpTool.httpPost(IDPHOTOBUSINESSLICENSEURL, jsonObjectIdPhotoBusinessLicenses, false);
        //JSONObject转换成对象
        Map<String, Class<ResultIdPhotoBusinessLicensesObject>> map = new HashMap<String, Class<ResultIdPhotoBusinessLicensesObject>>();
        map.put("resultIdPhotoBusinessLicensesObject", ResultIdPhotoBusinessLicensesObject.class); // key为teacher私有变量的属性名
        // 使用JSONObject.toBean(jsonObject, beanClass, classMap)
        ResultIdPhotoBusinessLicenses resultIdPhotoBusinessLicenses = (ResultIdPhotoBusinessLicenses) JSONObject.toBean(jsonObject, ResultIdPhotoBusinessLicenses.class, map);
        return resultIdPhotoBusinessLicenses;
    }

    /**
     * 接口2：制作并检测证件照
     */
    private ResultIdPhotoMarkAndTest idPhotoMarkAndTest(String base64Picture, String specId, List<BackgroundColor> backgroundColorList) throws Exception {
        IdPhotoMarkAndTest idPhotoMarkAndTest = new IdPhotoMarkAndTest();
        idPhotoMarkAndTest.setFile(base64Picture);
        idPhotoMarkAndTest.setSpec_id(specId);
        idPhotoMarkAndTest.setBackground_color(backgroundColorList);
        //Object转JSON字符串:
        String idPhotoMarkAndTestJsonString = com.alibaba.fastjson.JSONObject.toJSONString(idPhotoMarkAndTest);
        //JSON字符串转JSONObject:
        com.alibaba.fastjson.JSONObject idPhotoMarkAndTestJsonObject = com.alibaba.fastjson.JSONObject.parseObject(idPhotoMarkAndTestJsonString);
        //请求结果
        String jsonStringResultIdPhotoMarkAndTest = HttpToolOther.httpPostReturnJsonString(IDPHOTOMAKEANDTESTURL, idPhotoMarkAndTestJsonObject, false);
        ResultIdPhotoMarkAndTest resultIdPhotoMarkAndTest = new GsonBuilder().create().fromJson(jsonStringResultIdPhotoMarkAndTest, ResultIdPhotoMarkAndTest.class);
        return resultIdPhotoMarkAndTest;
    }

    /**
     * 接口3:同时获取无水印单张和排版图片
     */
    private ResultGetIdPhotoNoWaterMarkAndTypeSettingUrl getIdPhotoNoWaterMarkAndTypeSettingUrl(String fileName) throws Exception {
        GetIdPhotoNoWaterMarkAndTypeSettingUrl getIdPhotoNoWaterMarkAndTypeSettingUrl = new GetIdPhotoNoWaterMarkAndTypeSettingUrl();
        getIdPhotoNoWaterMarkAndTypeSettingUrl.setFile_name(fileName);
        JSONObject jsonObjectIdPhotoMarkAndTest = JSONObject.fromObject(getIdPhotoNoWaterMarkAndTypeSettingUrl);
        JSONObject jsonObject = HttpTool.httpPost(GETIDPHOTONOWATERMARKANDTYPESETTINGURL, jsonObjectIdPhotoMarkAndTest, false);
        String jsonString = com.alibaba.fastjson.JSONObject.toJSONString(jsonObject);
        ResultGetIdPhotoNoWaterMarkAndTypeSettingUrl resultGetIdPhotoNoWaterMarkAndTypeSettingUrl = com.alibaba.fastjson.JSONObject.parseObject(jsonString, ResultGetIdPhotoNoWaterMarkAndTypeSettingUrl.class);
        return resultGetIdPhotoNoWaterMarkAndTypeSettingUrl;
    }


}
