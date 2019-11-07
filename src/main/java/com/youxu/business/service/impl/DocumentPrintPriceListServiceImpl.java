package com.youxu.business.service.impl;

import com.youxu.business.dao.DocumentPrintPriceListMapper;
import com.youxu.business.pojo.DocumentPrintPriceList;
import com.youxu.business.service.DocumentPrintPriceListService;
import com.youxu.business.utils.OtherUtil.FileToBase64;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

@Service
public class DocumentPrintPriceListServiceImpl implements DocumentPrintPriceListService {

    @Resource
    private DocumentPrintPriceListMapper documentPrintPriceListMapper;

    @Override
    public DocumentPrintPriceList selectDocumentPrintPriceList(DocumentPrintPriceList documentPrintPriceList) throws Exception {
        // 查看页数
        int pdfPageNumber = documentPrintPriceList.getPageNumber();
        // 查看价格
        Integer count = documentPrintPriceList.getCount();// 黑白
        Integer countColour = documentPrintPriceList.getCountColour();// 彩色
        documentPrintPriceList.setDocumentPrintPriceListCode(documentPrintPriceList.getDocumentPrintPriceListCodeBlackAndWhite());
        DocumentPrintPriceList documentPrintPriceListBlackAndWhite = documentPrintPriceListMapper.selectDocumentPrintPriceList(documentPrintPriceList);
        documentPrintPriceList.setDocumentPrintPriceListCode(documentPrintPriceList.getDocumentPrintPriceListCodeColour());
        DocumentPrintPriceList documentPrintPriceListCodeColour = documentPrintPriceListMapper.selectDocumentPrintPriceList(documentPrintPriceList);
        if(StringUtils.isEmpty(documentPrintPriceListBlackAndWhite)){
            return null;
        }
        // 份数*单页价*页数
        Double documentPrintPriceListPriceBlackAndWhite = documentPrintPriceListBlackAndWhite.getDocumentPrintPriceListPrice();
        Double documentPrintPriceListPriceColour = documentPrintPriceListCodeColour.getDocumentPrintPriceListPrice();
        double blackAndWhitePrice = count * documentPrintPriceListPriceBlackAndWhite * pdfPageNumber;
        double colorPrice = countColour * documentPrintPriceListPriceColour * pdfPageNumber;
        double totalPriceDouble = blackAndWhitePrice + colorPrice;
        DecimalFormat decimalFormat = new DecimalFormat("######.00");
        String totalPriceString = decimalFormat.format(totalPriceDouble);
        Double totalPrice = Double.valueOf(totalPriceString);
        documentPrintPriceListBlackAndWhite.setTotalPrice(totalPrice);
        documentPrintPriceListBlackAndWhite.setCountColour(countColour);
        documentPrintPriceListBlackAndWhite.setDocumentPrintPriceListPrice(0.0);
        documentPrintPriceListBlackAndWhite.setDocumentPrintPriceListPriceBlackAndWhite(documentPrintPriceListPriceBlackAndWhite);// 黑白单价
        documentPrintPriceListBlackAndWhite.setDocumentPrintPriceListPriceCodeColour(documentPrintPriceListPriceColour);// 彩色单价
        documentPrintPriceListBlackAndWhite.setDocumentPrintPriceListCodeBlackAndWhite(documentPrintPriceList.getDocumentPrintPriceListCodeBlackAndWhite());
        documentPrintPriceListBlackAndWhite.setDocumentPrintPriceListCodeColour(documentPrintPriceList.getDocumentPrintPriceListCodeColour());
        documentPrintPriceListBlackAndWhite.setCount(count);
        documentPrintPriceListBlackAndWhite.setPageNumber(pdfPageNumber);
        return documentPrintPriceListBlackAndWhite;
    }
}
