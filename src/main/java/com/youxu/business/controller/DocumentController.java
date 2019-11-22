package com.youxu.business.controller;

import com.youxu.business.pojo.Document;
import com.youxu.business.pojo.RecentFile;
import com.youxu.business.service.DocumentService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/api")
@RestController
@Api(description = "文件夹列表")
public class DocumentController {
    @Resource
    private DocumentService documentService;

    @ApiOperation(value = "查看近期文件集合（仅显示10条）", notes = "userId")
    @GetMapping("/selectRecentDocumentByUserId")
    public ResponseMessage<List<Document>> selectRecentDocumentByUserId(@RequestParam String userId) {
        List<Document> selectRecentDocumentByUserId = documentService.selectRecentFileByUserId(userId);
        if (StringUtils.isEmpty(selectRecentDocumentByUserId)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",selectRecentDocumentByUserId);
    }

    @ApiOperation(value = "更改文件名称通过文件id", notes = "documentId:文件id， documentName：文件名称")
    @PutMapping("/updateDocumentNameByDocumentId")
    public ResponseMessage updateDocumentNameByDocumentId(@RequestParam String documentId, @RequestParam String documentName) {
        Integer updateDocumentNameByDocumentId = documentService.updateDocumentNameByDocumentId(documentId,documentName);
        if (StringUtils.isEmpty(updateDocumentNameByDocumentId) || updateDocumentNameByDocumentId == 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",updateDocumentNameByDocumentId);
    }
}
