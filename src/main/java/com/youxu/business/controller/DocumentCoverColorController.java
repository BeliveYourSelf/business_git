package com.youxu.business.controller;

import com.youxu.business.pojo.DocumentCoverColor;
import com.youxu.business.pojo.Order;
import com.youxu.business.service.DocumentCoverColorService;
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
@Api(description = "文档封面颜色表")
public class DocumentCoverColorController {

    @Resource
    private DocumentCoverColorService documentCoverColorService;


    @ApiOperation(value = "查看文档封面颜色", notes = "storeId")
    @GetMapping("/selectDocumentCoverColorByStoreId")
    public ResponseMessage<List<DocumentCoverColor>> selectDocumentCoverColorByStoreId(@RequestParam String storeId) {
        List<DocumentCoverColor> selectDocumentCoverColorByStoreId = documentCoverColorService.selectDocumentCoverColorByStoreId(storeId);
        if (StringUtils.isEmpty(selectDocumentCoverColorByStoreId)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", selectDocumentCoverColorByStoreId);
    }

}
