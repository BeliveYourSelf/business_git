package com.youxu.business.service.impl;

import com.youxu.business.dao.DictionaryDocumentImpositionMapper;
import com.youxu.business.pojo.DictionaryDocumentImposition;
import com.youxu.business.service.DictionaryDocumentImpositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DictionaryDocumentImpositionServiceImpl implements DictionaryDocumentImpositionService {
    @Resource
    private DictionaryDocumentImpositionMapper dictionaryDocumentImpositionMapper;
    @Override
    public List<DictionaryDocumentImposition> selectDocumentImposition(String storeId) {
        return dictionaryDocumentImpositionMapper.selectDocumentImposition(storeId);
    }
}
