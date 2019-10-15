package com.youxu.business.service;

import com.youxu.business.pojo.Document;

import java.io.IOException;

public interface DocumentService {
    Integer insertDocument(Document document) throws IOException;
}
