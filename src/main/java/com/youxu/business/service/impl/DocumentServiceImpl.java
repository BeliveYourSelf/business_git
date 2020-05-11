package com.youxu.business.service.impl;

import com.itextpdf.text.pdf.PdfReader;
import com.youxu.business.dao.DocumentMapper;
import com.youxu.business.pojo.Document;
import com.youxu.business.service.DocumentService;
import com.youxu.business.utils.OtherUtil.DeleteFileUtil;
import com.youxu.business.utils.OtherUtil.DownLoadFileFromOss;
import com.youxu.business.utils.OtherUtil.OSSUploadUtil;
import com.youxu.business.utils.readdocumentpagesizeutils.Readword;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    private final static Logger logger = LoggerFactory.getLogger(DocumentServiceImpl.class);
    @Resource
    private DocumentMapper documentMapper;

    @Resource
    private Readword readword;

    @Override
    public Integer insertDocument(Document document, HttpServletRequest request) throws IOException {
        // 读取文件大小
        String fileSize;

        // 新增文件
        List documentList = new ArrayList<Document>();
        String documentUrlNew = document.getDocumentUrl();
        String[] documentUrlArr = documentUrlNew.split(",");
        if (documentUrlArr.length >= 1) {
            for (int i = 0; documentUrlArr.length > i; i++) {
                // oss文件下载到本地获取文件页数
                int nameLocal = documentUrlArr[i].lastIndexOf("/") + 1;
                String fileName = documentUrlArr[i].substring(nameLocal);
                // 获取项目所在服务器的全路径，如：D:\apache-tomcat-7.0.25\webapps\TestSytem\
                String localPath = request.getServletContext().getRealPath("/") + fileName;
                DownLoadFileFromOss downLoadFileFromOss = new DownLoadFileFromOss();
                downLoadFileFromOss.downloadFile(documentUrlArr[i], localPath);
                // 添加文件页数
                logger.info("添加文件页数开始" );
                Integer xlsxNum = 0;
                try{
                 xlsxNum = readword.getFilePageNum(localPath);
                }
                catch (Exception e){
                    // ppt 和pptx  失败 ，转pdf重新获取页数
                    xlsxNum= getPdfPage(documentUrlNew,downLoadFileFromOss,request);
                }
                logger.info("添加文件页数：" + xlsxNum);
                DeleteFileUtil.delete(localPath);
                logger.info("删除文件完成");
                document.setSizePage(xlsxNum.toString());
                // 添加文件大小
                fileSize = getFileSize(documentUrlArr[i]);
                document.setDocumentUrl(documentUrlArr[i]);
                String documentUrl = documentUrlArr[i];
                int i1 = documentUrl.lastIndexOf("/");
                String documentName = documentUrl.substring(i1+1);
                document.setDocumentName(documentName);
                document.setFileSize(fileSize);
                documentList.add(document);
            }
        }
        logger.info("待插入对象：" + documentList.toString());
        return documentMapper.insertDocument(documentList);
    }

    @Override
    public List<Document> selectRecentFileByUserId(String userId) {
        return documentMapper.selectRecentFileByUserId(userId);
    }

    @Override
    public Integer updateDocumentNameByDocumentId(String documentId, String documentName) {
        Integer updateDocumentNameByDocumentId = documentMapper.updateDocumentNameByDocumentId(documentId, documentName);
        return updateDocumentNameByDocumentId;
    }


    // 获取文件大小
    private String getFileSize(String url) {
        Double read = 0.0;
        try {
            // 创建url
            URL filePath = new URL(url);

            URLConnection urlConnection = filePath.openConnection();
            read = Double.valueOf(urlConnection.getContentLength());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            logger.error("获取文件大小失败：" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("获取文件大小失败：" + e.getMessage());
        }
        String  fileSize= String.valueOf(read / (1024 * 1024));
        logger.info("获取文件大小：" + fileSize);
        return fileSize; // 转换为兆
    }
    /**
     * 由于转换为pptx\ppt可能出问题，捕获异常转换为pdf文件，读取页数
     */

    public Integer getPdfPage(String localPath,DownLoadFileFromOss downLoadFileFromOss, HttpServletRequest request) throws IOException {
        // ppt 和pptx  失败 ，转pdf重新获取页数
        String documentUrlTranTOPDF = OSSUploadUtil.documentUrlTranTOPDF(localPath);
        Integer nameLocal = localPath.lastIndexOf("/") + 1;
        String fileName = localPath.substring(nameLocal);
        String[] split = fileName.split("\\.");
        //获取pdf页数
        String localPathNew = request.getServletContext().getRealPath("/") + split[0] + ".pdf";
        downLoadFileFromOss.downloadFile(documentUrlTranTOPDF, localPathNew);
        PdfReader reader = new PdfReader(localPathNew);
        Integer xlsxNum = reader.getNumberOfPages();
        DeleteFileUtil.delete(localPathNew);
        return xlsxNum;
    }
}
