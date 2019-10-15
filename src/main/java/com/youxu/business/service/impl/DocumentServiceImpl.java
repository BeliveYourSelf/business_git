package com.youxu.business.service.impl;

import com.youxu.business.dao.DocumentMapper;
import com.youxu.business.pojo.Document;
import com.youxu.business.service.DocumentService;
import com.youxu.business.utils.readdocumentpagesizeutils.Readword;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Resource
    private DocumentMapper documentMapper;

    @Override
    public Integer insertDocument(Document document) throws IOException {
        // 读取文件大小
        String fileSize;
        String documentUrl = document.getDocumentUrl();
        File file = new File(documentUrl);
        if (file.isFile() && file.exists()) {
            fileSize = String.valueOf(file.length()/1024/1024);
        } else {
            fileSize = "0";
        }
        document.setFileSize(fileSize);
        // 获取文件页数
        Integer xlsxNum = Readword.getFilePageNum(documentUrl);
        document.setSizePage(xlsxNum.toString());
        // 新增文件
        return documentMapper.insertDocument(document);
    }
}
