package com.youxu.business.service;

import com.youxu.business.pojo.DictionaryDocumentImposition;

import java.util.List;

public interface DictionaryDocumentImpositionService {
    List<DictionaryDocumentImposition> selectDocumentImposition(String storeId);
}
