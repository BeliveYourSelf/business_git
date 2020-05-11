package com.youxu.business.service;

import com.youxu.business.pojo.Document;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface DocumentService {
    Integer insertDocument(Document document,HttpServletRequest request) throws IOException;

    List<Document> selectRecentFileByUserId(String userId);

    Integer updateDocumentNameByDocumentId(String documentId, String documentName);
}
