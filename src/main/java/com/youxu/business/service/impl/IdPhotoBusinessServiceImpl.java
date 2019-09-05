package com.youxu.business.service.impl;
import com.youxu.business.utils.pojotools.*;
import net.sf.json.JSONObject;
import com.youxu.business.pojo.IdPhotoBusiness;
import com.youxu.business.service.BaseService;
import com.youxu.business.service.IdPhotoBusinessService;
import com.youxu.business.utils.HttpTools.HttpResult;
import com.youxu.business.utils.HttpTools.HttpTool;
import com.youxu.business.utils.OtherUtil.FileToBase64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;


@Service
public class IdPhotoBusinessServiceImpl extends BaseService implements IdPhotoBusinessService {
    private final static Logger logger = LoggerFactory.getLogger(IdPhotoBusinessServiceImpl.class);


    @Override
    public IdPhotoBusiness upLoadIdPhoto(IdPhotoBusiness idPhotoBusiness) throws Exception {
        // 证件照上传：环境监测-制作并检测-取出图片
        threeIntegrationOfIdPhotoBusiness(idPhotoBusiness);
        // 添加订单-接口3的图片存入数据库订单库存表

        return null;
    }


    /**
     * 整合证件照三个接口
     */
    private IdPhotoBusiness threeIntegrationOfIdPhotoBusiness(IdPhotoBusiness idPhotoBusiness ) throws Exception {
        IdPhotoBusiness idPhotoBusinessError = new IdPhotoBusiness();

        IdPhotoBusinessServiceImpl idPhotoBusinessService = new IdPhotoBusinessServiceImpl();
        // 接口1：证件照环境监测
        ResultIdPhotoBusinessLicenses resultIdPhotoBusinessLicenses = idPhotoBusinessService.idPhotoBusinessLicenses(idPhotoBusiness.getBase64());
        String codeResultIdPhotoBusinessLicenses = resultIdPhotoBusinessLicenses.getCode();
        if(!"200".equals(codeResultIdPhotoBusinessLicenses)){
            idPhotoBusinessError.setCode(Integer.valueOf(codeResultIdPhotoBusinessLicenses));
            idPhotoBusinessError.setMessage(resultIdPhotoBusinessLicenses.getMsg());
            return idPhotoBusinessError;
        }
        // 接口2：制作并检测证件照
        ResultIdPhotoMarkAndTest resultIdPhotoMarkAndTest = idPhotoBusinessService.idPhotoMarkAndTest(idPhotoBusiness.getBase64(), idPhotoBusiness.getSpecId());
        String codeResultIdPhotoMarkAndTest = resultIdPhotoMarkAndTest.getCode();
        if(!"200".equals(codeResultIdPhotoMarkAndTest)){
            idPhotoBusinessError.setCode(Integer.valueOf(codeResultIdPhotoMarkAndTest));
            idPhotoBusinessError.setMessage("制作并检测证件照失败");
            return idPhotoBusinessError;
        }
        // 接口3:同时获取无水印单张和排版图片
        idPhotoBusinessService.getIdPhotoNoWaterMarkAndTypeSettingUrl("fileName");
        return idPhotoBusinessError;
    }

    /**
     *接口1：证件照环境监测
     */
    private ResultIdPhotoBusinessLicenses  idPhotoBusinessLicenses(String base64Picture){
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
    private ResultIdPhotoMarkAndTest idPhotoMarkAndTest(String base64Picture,String specId){
        IdPhotoMarkAndTest idPhotoMarkAndTest = new IdPhotoMarkAndTest();
        idPhotoMarkAndTest.setFile(base64Picture);
        idPhotoMarkAndTest.setSpec_id(specId);
        JSONObject jsonObjectIdPhotoMarkAndTest = JSONObject.fromObject(idPhotoMarkAndTest);
        JSONObject jsonObject = HttpTool.httpPost(IDPHOTOMAKEANDTESTURL, jsonObjectIdPhotoMarkAndTest, false);
        //JSONObject转换成对象
        Map<String, Class<ResultIdPhotoMarkAndTestObject>> map = new HashMap<String, Class<ResultIdPhotoMarkAndTestObject>>();
        map.put("result", ResultIdPhotoMarkAndTestObject.class); // key为teacher私有变量的属性名
        // 使用JSONObject.toBean(jsonObject, beanClass, classMap)
        ResultIdPhotoMarkAndTest resultIdPhotoMarkAndTestNew = (ResultIdPhotoMarkAndTest) JSONObject.toBean(jsonObject, ResultIdPhotoMarkAndTest.class, map);
        return resultIdPhotoMarkAndTestNew;
    }
    /**
     * 接口3:同时获取无水印单张和排版图片
     */
    private JSONObject getIdPhotoNoWaterMarkAndTypeSettingUrl(String fileName){
        GetIdPhotoNoWaterMarkAndTypeSettingUrl getIdPhotoNoWaterMarkAndTypeSettingUrl = new GetIdPhotoNoWaterMarkAndTypeSettingUrl();
        getIdPhotoNoWaterMarkAndTypeSettingUrl.setFile_name(fileName);
        JSONObject jsonObjectIdPhotoMarkAndTest = JSONObject.fromObject(getIdPhotoNoWaterMarkAndTypeSettingUrl);
        JSONObject jsonObject = HttpTool.httpPost(GETIDPHOTONOWATERMARKANDTYPESETTINGURL, jsonObjectIdPhotoMarkAndTest, false);
        return jsonObject;
    }


}
