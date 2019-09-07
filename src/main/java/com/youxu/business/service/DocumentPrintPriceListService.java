package com.youxu.business.service;

import com.youxu.business.pojo.DocumentPrintPriceList;

import java.io.IOException;

public interface DocumentPrintPriceListService {
    DocumentPrintPriceList selectDocumentPrintPriceList(DocumentPrintPriceList documentPrintPriceList) throws IOException;
}
