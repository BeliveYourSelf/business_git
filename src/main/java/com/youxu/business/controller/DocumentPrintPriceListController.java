package com.youxu.business.controller;

import com.youxu.business.pojo.DocumentPrintPriceList;
import com.youxu.business.service.DocumentPrintPriceListService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.HttpTools.HttpTool;
import com.youxu.business.utils.OtherUtil.DeleteFileUtil;
import com.youxu.business.utils.OtherUtil.DownLoadFileFromOss;
import com.youxu.business.utils.OtherUtil.OSSUploadUtil;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import com.youxu.business.utils.pojotools.UpLoadFile;
import com.youxu.business.utils.readdocumentpagesizeutils.Readword;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@RequestMapping("/api")
@RestController
@Api(description = "文档打印价格表")
public class DocumentPrintPriceListController {
    private final static Logger logger = LoggerFactory.getLogger(DocumentPrintPriceListController.class);
    @Resource
    private DocumentPrintPriceListService documentPrintPriceListService;

    /**
     * @param documentPrintPriceList
     * @return
     */
    @ApiOperation(value = "获取文档打印价格", notes = "{\"count\":\"2\" ,\"documentPrintPriceListCodeBlackAndWhite\": [\"77,1,0\"]\n" +
            ",\"documentPrintPriceListCodeColour\":[\"77,1,1\"]\n" +
            " ,\"pageNumber\":\"1\" ,\"storeId\":\"1\" ,\"countColour\":\"1\"}    " +
            "   count:黑白份数，countColour:彩色份数（如果只打印一种，另一种份数传0）   " +
            " documentPrintPriceListCode:文档打印价格表排列组合（ps：（1,1,1））（尺寸/单双面/黑白） 单双面：1.单面  2.双面/    黑白:0黑 1白" +
            ", pageNumber:文件总页数      返回值：totalPrice  为总价")
    @PostMapping("/selectDocumentPrintPriceList")
    public ResponseMessage<DocumentPrintPriceList> selectDocumentPrintPriceList(@RequestBody DocumentPrintPriceList documentPrintPriceList)  {
        DocumentPrintPriceList documentPrintPriceListNew = null;
        try {
            documentPrintPriceListNew = documentPrintPriceListService.selectDocumentPrintPriceList(documentPrintPriceList);
        } catch (Exception e) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "商家没有此规格");
        }
        if (StringUtils.isEmpty(documentPrintPriceListNew)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "商家没有此规格");
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
    public ResponseMessage<Integer> selectDocumentPageNumberByUrl(@RequestParam("fileUrl") String fileUrl, HttpServletRequest request) throws IOException {
        if (fileUrl.isEmpty()) {
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), "路径不能为空");
        }
        int nameLocal = fileUrl.lastIndexOf("/") + 1;
        String fileName = fileUrl.substring(nameLocal);
        String localPath = request.getServletContext().getRealPath("/") + fileName;
        DownLoadFileFromOss downLoadFileFromOss = new DownLoadFileFromOss();
        downLoadFileFromOss.downloadFile(fileUrl, localPath);
        //获取pdf页数
        int xlsxNum = Readword.getFilePageNum(localPath);
        DeleteFileUtil.delete(localPath);
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

    @ApiOperation(value = "上传图片(带文件名称)", notes = "multipartFileName:文件名必须带格式    例如：文档.docx")
    @PostMapping("/uploadFileOverWrite")
    public ResponseMessage<String> uploadFileOverWrite(@RequestParam("file") MultipartFile file, String multipartFileName) {
        String uploadSuccess = OSSUploadUtil.uploadBlogOverWrite(file, multipartFileName);
        //获取文件页数
        if (StringUtils.isEmpty(uploadSuccess)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "上传失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", uploadSuccess);
    }
    @ApiOperation(value = "上传图片(带文件名称)PDF", notes = "multipartFileName:文件名必须带格式    例如：文档.docx")
    @PostMapping("/uploadBlogOverWritePDF")
    public ResponseMessage<Map<String, String>> uploadBlogOverWritePDF(@RequestParam("file") MultipartFile file, String multipartFileName) {
        Map<String, String> stringStringMap = OSSUploadUtil.uploadBlogOverWritePDF(file, multipartFileName);
        //获取文件页数
        if (StringUtils.isEmpty(stringStringMap)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "上传失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", stringStringMap);
    }
}
