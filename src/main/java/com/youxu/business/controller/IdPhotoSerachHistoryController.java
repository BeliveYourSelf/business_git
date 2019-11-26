package com.youxu.business.controller;

import com.youxu.business.pojo.IdPhotoSerachHistory;
import com.youxu.business.service.IdPhotoSerachHistoryService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/api")
@RestController
@Api(description = "证件照历史搜索表")
public class IdPhotoSerachHistoryController {
    @Resource
    private IdPhotoSerachHistoryService idPhotoSerachHistoryService;

    @GetMapping("/getIdPhotoSerachHistoryByUserId")
    @ApiOperation(value = "历史搜索", notes = "")
    public ResponseMessage<List<IdPhotoSerachHistory>> getIdPhotoSerachHistoryByUserId(@RequestParam String userId ){
        List<IdPhotoSerachHistory> idPhotoSerachHistoryList = idPhotoSerachHistoryService.getIdPhotoSerachHistoryByUserId(userId);
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功", idPhotoSerachHistoryList);

    }
}
