package com.youxu.business.service.impl;

import com.youxu.business.dao.DocumentPrintPriceListMapper;
import com.youxu.business.pojo.DocumentPrintPriceList;
import com.youxu.business.service.DocumentPrintPriceListService;
import com.youxu.business.utils.OtherUtil.FileToBase64;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class DocumentPrintPriceListServiceImpl implements DocumentPrintPriceListService {

    @Resource
    private DocumentPrintPriceListMapper documentPrintPriceListMapper;

    @Override
    public DocumentPrintPriceList selectDocumentPrintPriceList(DocumentPrintPriceList documentPrintPriceList) throws IOException {
        // 查看页数
        int pdfPageNumber = documentPrintPriceList.getPageNumber();
        //查看价格
        Integer count = documentPrintPriceList.getCount();
        DocumentPrintPriceList documentPrintPriceListNew = documentPrintPriceListMapper.selectDocumentPrintPriceList(documentPrintPriceList);
        //份数*单页价*页数
        Double documentPrintPriceListPrice = documentPrintPriceListNew.getDocumentPrintPriceListPrice();
        double totalPrice = count * documentPrintPriceListPrice * pdfPageNumber;
        documentPrintPriceListNew.setTotalPrice(totalPrice);
        documentPrintPriceListNew.setDocumentPrintPriceListPrice(documentPrintPriceListPrice);
        documentPrintPriceListNew.setCount(count);
        documentPrintPriceListNew.setPageNumber(pdfPageNumber);
        return documentPrintPriceListNew;
    }
}
