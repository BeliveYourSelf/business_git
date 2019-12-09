package com.youxu.business.controller;

import com.youxu.business.pojo.IdPhotoBusiness;
import com.youxu.business.pojo.idphotonewadd.CutChangeClothes;
import com.youxu.business.pojo.idphotonewadd.CutChangeClothesResult;
import com.youxu.business.pojo.idphotonewadd.FileNameFather;
import com.youxu.business.pojo.idphotonewadd.GetSpecs;
import com.youxu.business.service.BaseService;
import com.youxu.business.service.IdPhotoBusinessService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.HttpTools.HttpTool;
import com.youxu.business.utils.OtherUtil.Base64TransToBinarySystemToFile;
import com.youxu.business.utils.OtherUtil.ImageSizeTool;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import com.youxu.business.utils.pojotools.GetIdPhotoNoWaterMarkAndTypeSettingUrl;
import com.youxu.business.utils.pojotools.ResultGetIdPhotoNoWaterMarkAndTypeSettingUrl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/api")
@RestController
@Api(description = "证件照业务")
public class IdPhotoBusinessController extends BaseService {
    @Resource
    private IdPhotoBusinessService idPhotoBusinessService;


    @ApiOperation(value = "制作证件照", notes = "{\"base64\":\"\"\n" +
            ",\"specId\":\"2\"}")
    @PostMapping("/makeIdPhoto")
    public ResponseMessage<String> makeIdPhoto(@RequestBody IdPhotoBusiness idPhotoBusiness) throws Exception {
        try {
            // 判断不超过两兆
            Integer twoTrillion = 1 * 1024 * 1024 * 2;
            String base64 = idPhotoBusiness.getBase64();
            Integer base64Size = ImageSizeTool.imageSize(base64);
            if (base64Size > twoTrillion) {
                return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "上传图片不能大于2M");
            }
            // 把头部的data:image/png;base64,（注意有逗号）去掉
            String base64subString = ImageSizeTool.imageSubstring(base64);
            idPhotoBusiness.setBase64(base64subString);
            IdPhotoBusiness idPhotoBusinessNew = idPhotoBusinessService.makeIdPhoto(idPhotoBusiness);
            return Result.success(idPhotoBusinessNew.getCode().toString(), idPhotoBusinessNew.getMessage(), idPhotoBusinessNew.getPictureUrl());
        } catch (Exception e) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "检查上传参数");
        }
    }

    /**
     * 一下为证件照二期接口：对应证件照研究院
     * 更新信息：
     * 2019年11月19日
     * 1，“制作并检测证件照”接口新增background_color，ratios参数。
     * 2019年11月13日
     * 1，新增了一些正装模板
     */


    @ApiOperation(value = "证件照获取规格一个", notes = "specId   规格id")
    @GetMapping("/getSpecs")
    public ResponseMessage<GetSpecs> getSpecs(String specId) {
        GetSpecs getSpecs = null;
        try {
            getSpecs = idPhotoBusinessService.getSpecs(specId);
        } catch (Exception e) {
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), e.getMessage());
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), getSpecs);
    }

    @ApiOperation(value = "证件照获取规格多个", notes = "specIds = \"1,2\"  中间用逗号间隔   ")
    @GetMapping("/getSpecsMore")
    public ResponseMessage<List<GetSpecs>> getSpecsMore(String specIds) {
        List<GetSpecs> getSpecsList = new ArrayList<>();
        GetSpecs getSpecs = null;
        String[] split = specIds.split(",");
        List<String> specIdList = Arrays.asList(split);
        try {
            for (String specId : specIdList) {
                getSpecs = idPhotoBusinessService.getSpecs(specId);
                getSpecsList.add(getSpecs);
            }
        } catch (Exception e) {
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), e.getMessage());
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), getSpecsList);
    }

    @ApiOperation(value = "更换背景", notes = "{ \"base64\": \"/9j/4AAQSkZ\", \"specId\": \"391\",\"is_fair\":\"1\",\"fair_level\":\"5\" }      注：is_fair：0美颜无效，1美颜有效。（fair_level）只在is_fair为1时有效 ")
    @PostMapping("/udpateBackGroundColor")
    public ResponseMessage<IdPhotoBusiness> udpateBackGroundColor(@RequestBody IdPhotoBusiness idPhotoBusiness) {
        try {
            idPhotoBusiness = idPhotoBusinessService.udpateBackGroundColor(idPhotoBusiness);
        } catch (Exception e) {
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), e.getMessage());
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), idPhotoBusiness);
    }

    @ApiOperation(value = "查看水印图片通过fileName:返回Base64(或文件路径转base64)-补充：其他文件路径转base64", notes = "{\n" +
            "  \"fileName\": \"https://youxu-print.oss-cn-beijing.aliyuncs.com/log/20191024/1571918985416/高中部.pdf\"\n" +
            "}")
    @PostMapping("/getIdPhotoWaterMarkByFileName")
    public ResponseMessage<String> getIdPhotoWaterMarkByFileName(@RequestBody FileNameFather fileNameFather, HttpServletResponse response) {
        String getIdPhotoWaterMarkByFileName = null;
        try {
            getIdPhotoWaterMarkByFileName = idPhotoBusinessService.getIdPhotoWaterMarkByFileName(fileNameFather.getFileName(), response);
        } catch (Exception e) {
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), e.getMessage());
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", getIdPhotoWaterMarkByFileName);
    }

    @ApiOperation(value = "文件路径转换为oss路径", notes = "{\n" +
            "  \"fileName\": \"高中部.pdf\",\n" +
            "  \"filePath\": \"https://youxu-print.oss-cn-beijing.aliyuncs.com/log/20191024/1571918985416/高中部.pdf\"\n" +
            "}")
    @PostMapping("/getOssPathByFilePath")
    public ResponseMessage<String> getOssPathByFilePath(@RequestBody FileNameFather fileNameFather, HttpServletRequest request, HttpServletResponse response) {
        String getOssPathByFilePath = null;
        try {
            getOssPathByFilePath = idPhotoBusinessService.getOssPathByFilePath(fileNameFather, request, response);
        } catch (Exception e) {
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), e.getMessage());
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", getOssPathByFilePath);
    }

    @ApiOperation(value = "换装", notes = "{\n" +
            "  \"clothes\": \"applet_boy1\",\n" +
            "  \"fair_level\": \"3\"\n" +
            "  ,\"spec_id\": \"391\"\n" +
            "  ,\"file\": \"/9j/4AAQSk***\"\n" +
            "}")
    @PostMapping("/cutChangeClothes")
    public ResponseMessage<CutChangeClothesResult> cutChangeClothes(@RequestBody CutChangeClothes cutChangeClothes) {
        CutChangeClothesResult cutChangeClothesResult = null;
        try {
            cutChangeClothesResult = idPhotoBusinessService.cutChangeClothes(cutChangeClothes);
        } catch (Exception e) {
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), e.getMessage());
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", cutChangeClothesResult);
    }

    /**
     * 换装app_key(69f50c487f42e8e62823b464a4af019bcae8a8ab)
     *
     * @param fileName
     * @return
     */
    @ApiOperation(value = "同时获取无水印单张和排版图片-换装key", notes = "fileName：  622758d6102511ea9aa900163e0070b6clothesblue")
    @GetMapping("/getIdPhotoNoWaterMarkAndTypeSettingUrlOther")
    public ResponseMessage<ResultGetIdPhotoNoWaterMarkAndTypeSettingUrl> getIdPhotoNoWaterMarkAndTypeSettingUrlOther(@RequestParam String fileName) {
        ResultGetIdPhotoNoWaterMarkAndTypeSettingUrl resultGetIdPhotoNoWaterMarkAndTypeSettingUrl = null;
        try {
            String app_key = "69f50c487f42e8e62823b464a4af019bcae8a8ab";
            resultGetIdPhotoNoWaterMarkAndTypeSettingUrl = getIdPhotoNoWaterMarkAndTypeSettingUrlCopy(fileName, app_key);
        } catch (Exception e) {
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), e.getMessage());
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", resultGetIdPhotoNoWaterMarkAndTypeSettingUrl);
    }

    /**
     * 换装app_key(69f50c487f42e8e62823b464a4af019bcae8a8ab)
     *
     * @param fileName
     * @return
     */
    @ApiOperation(value = "同时获取无水印单张和排版图片-证件照检测和制作", notes = "fileName：  62cc859c128811ea9b7b00163e0070b613435blue3")
    @GetMapping("/getIdPhotoNoWaterMarkAndTypeSettingUrl")
    public ResponseMessage<ResultGetIdPhotoNoWaterMarkAndTypeSettingUrl> getIdPhotoNoWaterMarkAndTypeSettingUrl(@RequestParam String fileName) {
        ResultGetIdPhotoNoWaterMarkAndTypeSettingUrl resultGetIdPhotoNoWaterMarkAndTypeSettingUrl = null;
        try {
            String app_key = "2abf79c1e6f1aa18583f6a38d05336eae9baf3e3";
            resultGetIdPhotoNoWaterMarkAndTypeSettingUrl = getIdPhotoNoWaterMarkAndTypeSettingUrlCopy(fileName, app_key);
        } catch (Exception e) {
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), e.getMessage());
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", resultGetIdPhotoNoWaterMarkAndTypeSettingUrl);
    }

    /**
     * 接口3:同时获取无水印单张和排版图片   :
     */
    public ResultGetIdPhotoNoWaterMarkAndTypeSettingUrl getIdPhotoNoWaterMarkAndTypeSettingUrlCopy(String fileName, String app_key) throws Exception {
        GetIdPhotoNoWaterMarkAndTypeSettingUrl getIdPhotoNoWaterMarkAndTypeSettingUrl = new GetIdPhotoNoWaterMarkAndTypeSettingUrl();
        getIdPhotoNoWaterMarkAndTypeSettingUrl.setFile_name(fileName);
        getIdPhotoNoWaterMarkAndTypeSettingUrl.setApp_key(app_key);
        JSONObject jsonObjectIdPhotoMarkAndTest = JSONObject.fromObject(getIdPhotoNoWaterMarkAndTypeSettingUrl);
        JSONObject jsonObject = HttpTool.httpPost(GETIDPHOTONOWATERMARKANDTYPESETTINGURL, jsonObjectIdPhotoMarkAndTest, false);
        String jsonString = com.alibaba.fastjson.JSONObject.toJSONString(jsonObject);
        ResultGetIdPhotoNoWaterMarkAndTypeSettingUrl resultGetIdPhotoNoWaterMarkAndTypeSettingUrl = com.alibaba.fastjson.JSONObject.parseObject(jsonString, ResultGetIdPhotoNoWaterMarkAndTypeSettingUrl.class);
        return resultGetIdPhotoNoWaterMarkAndTypeSettingUrl;
    }


    @ApiOperation(value = "文件路径转化为流", notes = "documentUrl")
    @GetMapping("/documentPathTransToStream")
    public ResponseMessage documentPathTransToStream(HttpServletRequest request, HttpServletResponse response, @RequestParam String documentUrl) {
        try {
            idPhotoBusinessService.downLoadSteamByDocumentUrl(request, response, documentUrl);
        } catch (IOException e) {
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), e.getMessage());

        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }

    @ApiOperation(value = "base64转换为oss路径", notes = "{\n" +
            "  \"file\": \"/9j/4AA****\"\n" +
            "}              file:base64")
    @PostMapping("/changeBase64ToImageAnduploadOss")
    public ResponseMessage<String> changeBase64ToImageAnduploadOss(@RequestBody CutChangeClothes cutChangeClothes) {
        try {
            String changeBase64ToImageAnduploadOss = idPhotoBusinessService.changeBase64ToImageAnduploadOss(cutChangeClothes.getFile());
            if (StringUtils.isEmpty(changeBase64ToImageAnduploadOss)) {
                return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), "base64转换失败");
            }
            return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", changeBase64ToImageAnduploadOss);
        } catch (IOException e) {
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), e.getMessage());
        }
    }

}
