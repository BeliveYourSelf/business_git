package com.youxu.business.service.impl;

import com.youxu.business.dao.DictionaryDocumentSizeMapper;
import com.youxu.business.dao.SuperAdminDocumentSizeMapper;
import com.youxu.business.pojo.DictionaryDocumentSize;
import com.youxu.business.pojo.SuperAdminDocumentSize;
import com.youxu.business.service.DictionaryDocumentSizeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DictionaryDocumentSizeServiceImpl implements DictionaryDocumentSizeService {
    @Resource
    private DictionaryDocumentSizeMapper dictionaryDocumentSizeMapper;

    @Resource
    private SuperAdminDocumentSizeMapper superAdminDocumentSizeMapper;

    @Override
    public List<SuperAdminDocumentSize> selectDocumentSize(String storeId,String isBinding) {
        List<SuperAdminDocumentSize> selectDocumentSize = superAdminDocumentSizeMapper.selectDocumentSize(storeId, isBinding);
//        return dictionaryDocumentSizeMapper.selectDocumentSize(storeId);
        return selectDocumentSize;
    }
}
