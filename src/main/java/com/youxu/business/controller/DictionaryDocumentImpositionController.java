package com.youxu.business.controller;

import com.youxu.business.pojo.BillingRule;
import com.youxu.business.pojo.DictionaryDocumentImposition;
import com.youxu.business.service.DictionaryDocumentImpositionService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/api")
@RestController
@Api(description = "文档拼版字典表")
public class DictionaryDocumentImpositionController {

    @Resource
    private DictionaryDocumentImpositionService dictionaryDocumentImpositionService;

    @ApiOperation(value = "查看文档拼版列表", notes = "")
    @GetMapping("/selectDocumentImposition")
    public ResponseMessage<List<DictionaryDocumentImposition>> selectDocumentImposition() {
        List<DictionaryDocumentImposition> selectDocumentImposition =dictionaryDocumentImpositionService.selectDocumentImposition();
        if (selectDocumentImposition.size() <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",selectDocumentImposition);
    }
}
