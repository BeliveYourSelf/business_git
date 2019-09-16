package com.youxu.business.controller;

import com.youxu.business.pojo.Folder;
import com.youxu.business.pojo.Order;
import com.youxu.business.service.FolderService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

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
    public ResponseMessage insertFolder(@RequestBody Folder folder) {
        Integer insertFolder = folderService.insertFolder(folder);
        if (insertFolder <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }

    @ApiOperation(value = "更新文件夹名称", notes = "{\"id\":\"1\"\n" +
            ",\"folderName\":\"视频\"} ")
    @PostMapping("/updateFolder")
    public ResponseMessage updateFolder(@RequestBody Folder folder) {
        Integer updateFolder = folderService.updateFolder(folder);
        if (updateFolder <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }

    @ApiOperation(value = "查看文件夹目录", notes = "{\"id\":\"1\"\n" +
            ",\"userId\":\"1\"}    id：文件夹id  注：仅查看此文件目录下一级  ")
    @PostMapping("/selectFolderCatalog")
    public ResponseMessage<Folder> selectFolderCatalog(@RequestBody Folder folder) {
        Folder selectFolderCatalog = folderService.selectFolderCatalog(folder);
        if (StringUtils.isEmpty(selectFolderCatalog)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功",selectFolderCatalog);
    }

    @ApiOperation(value = "查看树形文件夹和文件", notes = "{\"userId\":\"1\"}")
    @PostMapping("/selectFolderAndDocument")
    public ResponseMessage<List<Folder>> selectFolderAndDocument(@RequestBody Folder folder) {
        List<Folder> selectFolderAndDocument = folderService.selectFolderAndDocument(folder);
        if (StringUtils.isEmpty(selectFolderAndDocument)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功",selectFolderAndDocument);
    }

    @ApiOperation(value = "查看树形某文件下的文件夹和文件", notes = "{\"id\":\"5\"\n" +
            ",\"userId\":\"1\"}")
    @PostMapping("/selectFolderAndDocumentByUserIdAndFolderId")
    public ResponseMessage<Folder> selectFolderAndDocumentByUserIdAndFolderId(@RequestBody Folder folder) {
        Folder selectFolderAndDocumentByUserIdAndFolderId = folderService.selectFolderAndDocumentByUserIdAndFolderId(folder);
        if (StringUtils.isEmpty(selectFolderAndDocumentByUserIdAndFolderId)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功",selectFolderAndDocumentByUserIdAndFolderId);
    }

    @ApiOperation(value = "删除文件和者文件夹", notes = "{\"documentListId\": [\n" +
            "    1,2\n" +
            "  ],\n" +
            "  \"folderListId\": [\n" +
            "    1\n" +
            "  ]\n" +
            "}     folderListId:文件夹Id集合 documentListId：文件Id集合")
    @PostMapping("/deleteFolderAndDocumentByUserIdAndFolderIdListAndDocumentListId")
    public ResponseMessage<Folder> deleteFolderAndDocumentByUserIdAndFolderIdListAndDocumentListId(@RequestBody Folder folder) {
        Integer deleteFolderAndDocumentByUserIdAndFolderIdListAndDocumentListId = folderService.deleteFolderAndDocumentByUserIdAndFolderIdListAndDocumentListId(folder);
        if (deleteFolderAndDocumentByUserIdAndFolderIdListAndDocumentListId <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }


}
