package com.youxu.business.service.impl;

import com.youxu.business.dao.DocumentMapper;
import com.youxu.business.pojo.Document;
import com.youxu.business.service.DocumentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Resource
    private DocumentMapper documentMapper;
    @Override
    public Integer insertDocument(Document document) {
        return documentMapper.insertDocument(document);
    }
}
