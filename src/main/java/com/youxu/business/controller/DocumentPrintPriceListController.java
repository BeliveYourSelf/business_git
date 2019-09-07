package com.youxu.business.controller;

import com.youxu.business.pojo.DocumentPrintPriceList;
import com.youxu.business.service.DocumentPrintPriceListService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.OtherUtil.OSSUploadUtil;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RequestMapping("/api")
@RestController
@Api(description = "文档打印价格表")
public class DocumentPrintPriceListController {
    @Resource
    private DocumentPrintPriceListService documentPrintPriceListService;

    /**
     * @param documentPrintPriceList
     * @return
     */
    @ApiOperation(value = "获取文档打印价格", notes = "{\"count\":\"2\"\n" +
            ",\"documentPrintPriceListCode\":\"1，2，3，4\"\n" +
            ",\"pageNumber\":\"30\"}    count:份数，documentPrintPriceListCode:文档打印价格表排列组合, pageNumber:文件总页数")
    @PostMapping("/selectDocumentPrintPriceList")
    public ResponseMessage<DocumentPrintPriceList> selectDocumentPrintPriceList(@RequestBody DocumentPrintPriceList documentPrintPriceList) throws IOException {
        DocumentPrintPriceList documentPrintPriceListNew = documentPrintPriceListService.selectDocumentPrintPriceList(documentPrintPriceList);
        if (StringUtils.isEmpty(documentPrintPriceListNew)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", documentPrintPriceListNew);
    }

    /**
     * 获取文档页数
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "获取文档页数", notes = "份数，文档打印价格表排列组合")
    @PostMapping("/selectDocumentPageNumber")
    public ResponseMessage<Integer> selectDocumentPageNumber(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), "文件不能为空");
        }
        InputStream inputStream = file.getInputStream();
        PDDocument load = PDDocument.load(inputStream);
        int numberOfPages = load.getNumberOfPages();
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", numberOfPages);
    }


    @ApiOperation(value = "上传图片", notes = "需要上传图片")
    @PostMapping("/uploadFile")
    public ResponseMessage<String> uploadBlog(@RequestParam("file") MultipartFile file) {
        String uploadSuccess = OSSUploadUtil.uploadBlog(file);
        if (StringUtils.isEmpty(uploadSuccess)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "上传失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", uploadSuccess);
    }
}
