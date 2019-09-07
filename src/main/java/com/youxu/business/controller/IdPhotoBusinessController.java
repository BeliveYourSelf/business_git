package com.youxu.business.controller;

import com.youxu.business.pojo.IdPhotoBusiness;
import com.youxu.business.service.IdPhotoBusinessService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.OtherUtil.ImageSizeTool;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

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
        // 判断不超过两兆
        Integer twoTrillion = 1*1024*1024*2;
        String base64 = idPhotoBusiness.getBase64();
        Integer base64Size = ImageSizeTool.imageSize(base64);
        if(base64Size>twoTrillion){
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(),"上传图片不能大于2M");
        }
        // 把头部的data:image/png;base64,（注意有逗号）去掉
        String base64subString = ImageSizeTool.imageSubstring(base64);
        idPhotoBusiness.setBase64(base64subString);
        IdPhotoBusiness idPhotoBusinessNew = idPhotoBusinessService.makeIdPhoto(idPhotoBusiness);
        return Result.success(idPhotoBusinessNew.getCode().toString(),idPhotoBusinessNew.getMessage(),idPhotoBusinessNew.getPictureUrl());
    }

    


}
