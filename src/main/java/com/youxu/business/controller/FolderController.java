package com.youxu.business.controller;

import com.youxu.business.pojo.Folder;
import com.youxu.business.pojo.Order;
import com.youxu.business.service.FolderService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(description = "文件夹表")
@RestController
@RequestMapping("/api")
public class FolderController {
    @Resource
    private FolderService folderService;

    @ApiOperation(value = "新增文件夹", notes = "{\"userId\":\"1\"\n" +
            ",\"folderParentId\":\"\"\n" +
            ",\"folderName\":\"照片\"}      folderParentId:父级文件夹id，一级文件夹什么都不传")
    @PostMapping("/insertFolder")
    public ResponseMessage<Integer> insertFolder(@RequestBody Folder folder) {
        Integer insertFolder = folderService.insertFolder(folder);
        if (insertFolder <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }
}
