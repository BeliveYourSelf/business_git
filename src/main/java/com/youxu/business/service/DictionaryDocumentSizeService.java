package com.youxu.business.service;


import com.youxu.business.pojo.DictionaryDocumentSize;

import java.util.List;

public interface DictionaryDocumentSizeService {

    List<DictionaryDocumentSize> selectDocumentSize(String storeId);
}
