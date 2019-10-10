package com.youxu.business.controller;

import com.youxu.business.pojo.DocumentPrintPriceList;
import com.youxu.business.service.DocumentPrintPriceListService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.OtherUtil.OSSUploadUtil;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import com.youxu.business.utils.readdocumentpagesizeutils.Readword;
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
    @ApiOperation(value = "获取文档打印价格", notes = "{\"count\":\"2\" ,\"documentPrintPriceListCode\":\"1,0,3,0\" ,\"pageNumber\":\"1\" ,\"storeId\":\"1\" ,\"countColour\":\"1\"}     count:黑白份数，countColour:彩色份数（如果只打印一种，另一种份数传0）    documentPrintPriceListCode:文档打印价格表排列组合, pageNumber:文件总页数      返回值：totalPrice  为总价")
    @PostMapping("/selectDocumentPrintPriceList")
    public ResponseMessage<DocumentPrintPriceList> selectDocumentPrintPriceList(@RequestBody DocumentPrintPriceList documentPrintPriceList) throws IOException {
        DocumentPrintPriceList documentPrintPriceListNew = documentPrintPriceListService.selectDocumentPrintPriceList(documentPrintPriceList);
        if (StringUtils.isEmpty(documentPrintPriceListNew)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", documentPrintPriceListNew);
    }

    /**
     * 通过file获取文档页数
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "获取pdf文档页数", notes = "份数，文档打印价格表排列组合")
    @PostMapping("/selectDocumentPageNumber")
    public ResponseMessage<Integer> selectDocumentPageNumber(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), "文件不能为空");
        }
        InputStream inputStream = file.getInputStream();

        //获取pdf页数
        PDDocument load = PDDocument.load(inputStream);
        int numberOfPages = load.getNumberOfPages();
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", numberOfPages);
    }

    /**
     * 通过地址路径获取文档页数
     *
     * @param fileUrl
     * @return
     */
    @ApiOperation(value = "通过地址路径获取文档页数（pdf/word/excel/ppt）", notes = "https://youxu-print.oss-cn-beijing.aliyuncs.com/log/20190929/1569741897178/woshipdf.pdf")
    @GetMapping("/selectDocumentPageNumberByUrl")
    public ResponseMessage<Integer> selectDocumentPageNumberByUrl(@RequestParam("fileUrl") String fileUrl) throws IOException {
        if (fileUrl.isEmpty()) {
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), "路径不能为空");
        }
        //获取pdf页数
        int xlsxNum = Readword.getFilePageNum(fileUrl);
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", xlsxNum);
    }


    @ApiOperation(value = "上传图片", notes = "需要上传图片")
    @PostMapping("/uploadFile")
    public ResponseMessage<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String uploadSuccess = OSSUploadUtil.uploadBlog(file);
        //获取文件页数
        if (StringUtils.isEmpty(uploadSuccess)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "上传失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", uploadSuccess);
    }
}
