package com.youxu.business.controller;

import com.youxu.business.pojo.DictionaryDocumentSize;
import com.youxu.business.pojo.SuperAdminDocumentSize;
import com.youxu.business.service.DictionaryDocumentSizeService;
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
@Api(description = "文档打印字典表尺寸")
public class DictionaryDocumentSizeController {
    @Resource
    private DictionaryDocumentSizeService dictionaryDocumentSizeService;

    @ApiOperation(value = "查看文档尺寸列表", notes = "入参值：（isBinding）是否装订，0否，1是。")
    @GetMapping("/selectDocumentSize")
    public ResponseMessage<List<SuperAdminDocumentSize>> selectDocumentSize(@RequestParam String storeId, @RequestParam String isBinding) {
        List<SuperAdminDocumentSize> documentSizeList = dictionaryDocumentSizeService.selectDocumentSize(storeId, isBinding);
        if (documentSizeList.size() <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "暂无该尺寸");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",documentSizeList);
    }
}
