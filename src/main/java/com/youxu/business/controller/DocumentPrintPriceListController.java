package com.youxu.business.controller;

import com.youxu.business.pojo.DocumentPrintPriceList;
import com.youxu.business.service.DocumentPrintPriceListService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/api")
@RestController
@Api(description = "文档打印价格表")
public class DocumentPrintPriceListController {
    @Resource
    private DocumentPrintPriceListService documentPrintPriceListService;

    @ApiOperation(value = "获取文档打印价格", notes = "份数，文档打印价格表排列组合")
    @PostMapping("/selectDocumentPrintPriceList")
    public ResponseMessage<DocumentPrintPriceList> selectDocumentPrintPriceList(@RequestBody DocumentPrintPriceList documentPrintPriceList) {
        DocumentPrintPriceList documentPrintPriceListNew =documentPrintPriceListService.selectDocumentPrintPriceList(documentPrintPriceList);
        if (StringUtils.isEmpty(documentPrintPriceListNew)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",documentPrintPriceListNew);
    }
}
