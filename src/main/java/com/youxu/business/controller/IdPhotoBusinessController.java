package com.youxu.business.controller;

import com.youxu.business.pojo.IdPhotoBusiness;
import com.youxu.business.pojo.IdPhotoDictionary;
import com.youxu.business.service.IdPhotoBusinessService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.OtherUtil.FileToBase64;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import com.youxu.business.utils.transicatetool.InRequestGetMultipartFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RequestMapping("/api")
@RestController
@Api(description = "证件照业务")
public class IdPhotoBusinessController {
    @Resource
    private IdPhotoBusinessService idPhotoBusinessService;


    
    @ApiOperation(value = "上传证件照-新增订单", notes = "spec_id file")
    @PostMapping("/upLoadIdPhoto")
    public ResponseMessage<IdPhotoBusiness> upLoadIdPhoto(HttpServletRequest request, @RequestBody IdPhotoBusiness idPhotoBusiness) throws Exception {
        // 从request中请求file
        MultipartFile file = InRequestGetMultipartFile.inRequestGetMultipartFile(request);
        IdPhotoBusiness idPhotoBusinessNew = idPhotoBusinessService.upLoadIdPhoto(file, idPhotoBusiness);
        return Result.success("200","成功",idPhotoBusinessNew);
    }

    


}
