package com.youxu.business.controller;

import com.youxu.business.pojo.IdPhotoBusiness;
import com.youxu.business.pojo.idphotonewadd.GetSpecs;
import com.youxu.business.service.IdPhotoBusinessService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.OtherUtil.ImageSizeTool;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/api")
@RestController
@Api(description = "证件照业务")
public class IdPhotoBusinessController {
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
 2019年11月19日
 1，“制作并检测证件照”接口新增background_color，ratios参数。
 2019年11月13日
 1，新增了一些正装模板
 */


    @ApiOperation(value = "证件照获取规格一个", notes = "specId   规格id")
    @GetMapping("/getSpecs")
    public ResponseMessage<GetSpecs> getSpecs(String specId) {
        GetSpecs getSpecs= null;
        try {
            getSpecs = idPhotoBusinessService.getSpecs(specId);
        } catch (Exception e) {
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(),e.getMessage());
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),getSpecs);
    }

    @ApiOperation(value = "证件照获取规格多个", notes = "specIds = \"1,2\"  中间用逗号间隔   ")
    @GetMapping("/getSpecsMore")
    public ResponseMessage<List<GetSpecs>> getSpecsMore(String specIds) {
        List<GetSpecs> getSpecsList = new ArrayList<>();
        GetSpecs getSpecs= null;
        String[] split = specIds.split(",");
        List<String> specIdList = Arrays.asList(split);
        try {
            for (String specId:specIdList){
            getSpecs = idPhotoBusinessService.getSpecs(specId);
                getSpecsList.add(getSpecs);
            }
        } catch (Exception e) {
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(),e.getMessage());
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),getSpecsList);
    }
}
