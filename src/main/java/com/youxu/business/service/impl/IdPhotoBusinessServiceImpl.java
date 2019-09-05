package com.youxu.business.service.impl;
import com.youxu.business.utils.pojotools.GetIdPhotoNoWaterMarkAndTypeSettingUrl;
import com.youxu.business.utils.pojotools.IdPhotoMarkAndTest;
import net.sf.json.JSONObject;
import com.youxu.business.pojo.IdPhotoBusiness;
import com.youxu.business.service.BaseService;
import com.youxu.business.service.IdPhotoBusinessService;
import com.youxu.business.utils.HttpTools.HttpResult;
import com.youxu.business.utils.HttpTools.HttpTool;
import com.youxu.business.utils.OtherUtil.FileToBase64;
import com.youxu.business.utils.pojotools.IdPhotoBusinessLicenses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class IdPhotoBusinessServiceImpl extends BaseService implements IdPhotoBusinessService {
    private final static Logger logger = LoggerFactory.getLogger(IdPhotoBusinessServiceImpl.class);


    @Override
    public IdPhotoBusiness upLoadIdPhoto(IdPhotoBusiness idPhotoBusiness) throws Exception {
        // 证件照上传：环境监测-制作并检测-取出图片
        threeIntegrationOfIdPhotoBusiness(idPhotoBusiness.getBase64(),idPhotoBusiness);
        // 添加订单-接口3的图片存入数据库订单库存表

        return null;
    }

    //        证件照环境监测
//        制作并检测证件照
//        同时获取无水印单张和排版图片
    /**
     * 整合证件照三个接口
     */
    private IdPhotoBusiness threeIntegrationOfIdPhotoBusiness(String base64String,IdPhotoBusiness idPhotoBusiness ) throws Exception {
        // 接口1：证件照环境监测
        IdPhotoBusinessServiceImpl idPhotoBusinessService = new IdPhotoBusinessServiceImpl();
        JSONObject jsonObject = idPhotoBusinessService.idPhotoBusinessLicenses(base64String);
        // 接口2：制作并检测证件照
        idPhotoBusinessService.idPhotoMarkAndTest(base64String,idPhotoBusiness.getSpecId());
        // 接口3:同时获取无水印单张和排版图片
        idPhotoBusinessService.getIdPhotoNoWaterMarkAndTypeSettingUrl("fileName");
        logger.info(jsonObject.toString());
        IdPhotoBusiness idPhotoBusiness1 = new IdPhotoBusiness();
        return idPhotoBusiness1;
    }

    /**
     *接口1：证件照环境监测
     */
    private JSONObject  idPhotoBusinessLicenses(String base64Picture){
        IdPhotoBusinessLicenses idPhotoBusinessLicenses = new IdPhotoBusinessLicenses();
        idPhotoBusinessLicenses.setBase64Picture(base64Picture);
        JSONObject jsonObjectIdPhotoBusinessLicenses = JSONObject.fromObject(idPhotoBusinessLicenses);
        JSONObject jsonObject = HttpTool.httpPost(IDPHOTOBUSINESSLICENSEURL, jsonObjectIdPhotoBusinessLicenses, false);
        return jsonObject;
    }
    /**
     * 接口2：制作并检测证件照
     */
    private JSONObject idPhotoMarkAndTest(String base64Picture,String specId){
        IdPhotoMarkAndTest idPhotoMarkAndTest = new IdPhotoMarkAndTest();
        idPhotoMarkAndTest.setBase64Picture(base64Picture);
        idPhotoMarkAndTest.setSpecId(specId);
        JSONObject jsonObjectIdPhotoMarkAndTest = JSONObject.fromObject(idPhotoMarkAndTest);
        JSONObject jsonObject = HttpTool.httpPost(IDPHOTOMAKEANDTESTURL, jsonObjectIdPhotoMarkAndTest, false);
        return jsonObject;
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
