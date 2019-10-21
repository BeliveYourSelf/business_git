package com.youxu.business.service;

import com.youxu.business.pojo.Document;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface DocumentService {
    Integer insertDocument(Document document,HttpServletRequest request) throws IOException;
}
