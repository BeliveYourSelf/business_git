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
import java.util.Date;

@Service
public class DocumentPrintPriceListServiceImpl implements DocumentPrintPriceListService {

    @Resource
    private DocumentPrintPriceListMapper documentPrintPriceListMapper;

    @Override
    public DocumentPrintPriceList selectDocumentPrintPriceList(DocumentPrintPriceList documentPrintPriceList) throws Exception {
        double totalPriceDouble =0.0;
        double blackAndWhitePrice = 0.0;
        double colorPrice =0.0;
        int pdfPageNumber = 0;
        Integer count = documentPrintPriceList.getCount();// 黑白
        Integer countColour = documentPrintPriceList.getCountColour();// 彩色
        int size = documentPrintPriceList.getDocumentPrintPriceListCodeBlackAndWhite().size();
        DocumentPrintPriceList documentPrintPriceListBlackAndWhiteReturn = new DocumentPrintPriceList();
        for(int i = 0; size > i; i++){
        // 查看页数
        pdfPageNumber = documentPrintPriceList.getPageNumber();
        // 查看价格
        documentPrintPriceList.setDocumentPrintPriceListCode(documentPrintPriceList.getDocumentPrintPriceListCodeBlackAndWhite().get(i));
        DocumentPrintPriceList documentPrintPriceListBlackAndWhite = documentPrintPriceListMapper.selectDocumentPrintPriceList(documentPrintPriceList);
        documentPrintPriceList.setDocumentPrintPriceListCode(documentPrintPriceList.getDocumentPrintPriceListCodeColour().get(i));
        DocumentPrintPriceList documentPrintPriceListCodeColour = documentPrintPriceListMapper.selectDocumentPrintPriceList(documentPrintPriceList);
        if(StringUtils.isEmpty(documentPrintPriceListBlackAndWhite)){
            return null;
        }
        // 份数*单页价*页数
        Double documentPrintPriceListPriceBlackAndWhite = documentPrintPriceListBlackAndWhite.getDocumentPrintPriceListPrice();
        Double documentPrintPriceListPriceColour = documentPrintPriceListCodeColour.getDocumentPrintPriceListPrice();
        blackAndWhitePrice = count * documentPrintPriceListPriceBlackAndWhite * pdfPageNumber;
        colorPrice = countColour * documentPrintPriceListPriceColour * pdfPageNumber;
        totalPriceDouble += blackAndWhitePrice + colorPrice;
        }
        DecimalFormat decimalFormat = new DecimalFormat("######.00");
        String totalPriceString = decimalFormat.format(totalPriceDouble);
        Double totalPrice = Double.valueOf(totalPriceString);
        documentPrintPriceListBlackAndWhiteReturn.setStoreId(documentPrintPriceList.getStoreId());
        documentPrintPriceListBlackAndWhiteReturn.setDocumentPrintPriceCover(0.0);
        documentPrintPriceListBlackAndWhiteReturn.setDocumentPrintPriceListCreateTime(new Date());
        documentPrintPriceListBlackAndWhiteReturn.setDocumentPrintPriceListModifyTime(new Date());
        documentPrintPriceListBlackAndWhiteReturn.setDocumentPrintPriceListStatus(false);
        documentPrintPriceListBlackAndWhiteReturn.setTotalPrice(totalPrice);
        documentPrintPriceListBlackAndWhiteReturn.setCountColour(countColour);
        documentPrintPriceListBlackAndWhiteReturn.setDocumentPrintPriceListPrice(0.0);
        documentPrintPriceListBlackAndWhiteReturn.setDocumentPrintPriceListPriceBlackAndWhite(blackAndWhitePrice);// 黑白单价
        documentPrintPriceListBlackAndWhiteReturn.setDocumentPrintPriceListPriceCodeColour(colorPrice);// 彩色单价
        documentPrintPriceListBlackAndWhiteReturn.setDocumentPrintPriceListCodeBlackAndWhite(documentPrintPriceList.getDocumentPrintPriceListCodeBlackAndWhite());
        documentPrintPriceListBlackAndWhiteReturn.setDocumentPrintPriceListCodeColour(documentPrintPriceList.getDocumentPrintPriceListCodeColour());
        documentPrintPriceListBlackAndWhiteReturn.setCount(count);
        documentPrintPriceListBlackAndWhiteReturn.setPageNumber(pdfPageNumber);
        return documentPrintPriceListBlackAndWhiteReturn;
    }
}
