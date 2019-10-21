package com.youxu.business.service.impl;

import com.youxu.business.dao.DocumentMapper;
import com.youxu.business.pojo.Document;
import com.youxu.business.service.DocumentService;
import com.youxu.business.utils.OtherUtil.DeleteFileUtil;
import com.youxu.business.utils.OtherUtil.DownLoadFileFromOss;
import com.youxu.business.utils.readdocumentpagesizeutils.Readword;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Resource
    private DocumentMapper documentMapper;

    @Override
    public Integer insertDocument(Document document) throws IOException {
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
//                String localPath = "C:" + File.separator + "Users" + File.separator + "Dell" + File.separator + "Desktop" + File.separator + fileName;
                String localPath = "file"+"/"+new Date().getTime()+"/"+fileName;
                DownLoadFileFromOss downLoadFileFromOss = new DownLoadFileFromOss();
                downLoadFileFromOss.downloadFile(documentUrlArr[i], localPath);
                // 添加文件页数
                Integer xlsxNum = Readword.getFilePageNum(localPath);
                DeleteFileUtil.delete(localPath);
                document.setSizePage(xlsxNum.toString());
                // 添加文件大小
                fileSize = getFileSize(documentUrlArr[i]);
                document.setDocumentUrl(documentUrlArr[i]);
                document.setFileSize(fileSize);
                documentList.add(document);
            }
        }
        return documentMapper.insertDocument(documentList);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(read / (1024 * 1024)); // 转换为兆
    }
}
