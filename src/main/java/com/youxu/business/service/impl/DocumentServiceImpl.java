package com.youxu.business.service.impl;

import com.youxu.business.dao.DocumentMapper;
import com.youxu.business.pojo.Document;
import com.youxu.business.service.DocumentService;
import com.youxu.business.utils.readdocumentpagesizeutils.Readword;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
            for(int i = 0;documentUrlArr.length > i;i++){
                // 添加文件页数
                Integer xlsxNum = Readword.getFilePageNum(documentUrlArr[i]);
                document.setSizePage(xlsxNum.toString());
                // 添加文件大小
                File file = new File(documentUrlArr[i]);
                if (file.isFile() && file.exists()) {
                    fileSize = String.valueOf(file.length() / 1024 / 1024);
                } else {
                    fileSize = "0";
                }
                document.setFileSize(fileSize);
                documentList.add(document);
            }
        }


        return documentMapper.insertDocument(documentList);
    }
}
