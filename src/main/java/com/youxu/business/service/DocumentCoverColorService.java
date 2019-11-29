package com.youxu.business.service;

import com.youxu.business.pojo.DocumentCoverColor;

import java.util.List;

public interface DocumentCoverColorService {
    List<DocumentCoverColor> selectDocumentCoverColorByStoreId(String storeId);
}
