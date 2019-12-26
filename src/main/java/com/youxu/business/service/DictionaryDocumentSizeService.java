package com.youxu.business.service;


import com.youxu.business.pojo.SuperAdminDocumentSize;

import java.util.List;

public interface DictionaryDocumentSizeService {

    List<SuperAdminDocumentSize> selectDocumentSize(String storeId, String isBinding);
}
