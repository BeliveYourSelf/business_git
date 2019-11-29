package com.youxu.business.service.impl;

import com.youxu.business.dao.DocumentCoverColorMapper;
import com.youxu.business.pojo.DocumentCoverColor;
import com.youxu.business.service.DocumentCoverColorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DocumentCoverColorServiceImpl implements DocumentCoverColorService {
    @Resource
    private DocumentCoverColorMapper documentCoverColorMapper;

    @Override
    public List<DocumentCoverColor> selectDocumentCoverColorByStoreId(String storeId) {
        return documentCoverColorMapper.selectDocumentCoverColorByStoreId(storeId);
    }
}
