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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
