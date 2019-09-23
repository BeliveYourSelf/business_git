package com.youxu.business.service.impl;

import com.youxu.business.dao.DictionaryDocumentSizeMapper;
import com.youxu.business.service.DictionaryDocumentSizeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DictionaryDocumentSizeServiceImpl implements DictionaryDocumentSizeService {
    @Resource
    private DictionaryDocumentSizeMapper dictionaryDocumentSizeMapper;

    @Override
    public List<DictionaryDocumentSizeService> selectDocumentSize(String storeId) {
        return dictionaryDocumentSizeMapper.selectDocumentSize(storeId);
    }
}
