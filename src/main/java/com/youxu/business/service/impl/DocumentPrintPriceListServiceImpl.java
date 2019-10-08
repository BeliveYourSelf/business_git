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

@Service
public class DocumentPrintPriceListServiceImpl implements DocumentPrintPriceListService {

    @Resource
    private DocumentPrintPriceListMapper documentPrintPriceListMapper;

    @Override
    public DocumentPrintPriceList selectDocumentPrintPriceList(DocumentPrintPriceList documentPrintPriceList) throws IOException {
        // 查看页数
        int pdfPageNumber = documentPrintPriceList.getPageNumber();
        //查看价格
        Integer count = documentPrintPriceList.getCount();// 黑白
        Integer countColour = documentPrintPriceList.getCountColour();// 彩色
        DocumentPrintPriceList documentPrintPriceListNew = documentPrintPriceListMapper.selectDocumentPrintPriceList(documentPrintPriceList);
        if(StringUtils.isEmpty(documentPrintPriceListNew)){
            return null;
        }
        //份数*单页价*页数
        Double documentPrintPriceListPrice = documentPrintPriceListNew.getDocumentPrintPriceListPrice();
        Double documentPrintPriceCover = documentPrintPriceListNew.getDocumentPrintPriceCover();
        double blackAndWhitePrice = count * documentPrintPriceListPrice * pdfPageNumber;
        double colorPrice = countColour * documentPrintPriceCover * pdfPageNumber;
        double totalPrice = blackAndWhitePrice + colorPrice;
        documentPrintPriceListNew.setTotalPrice(totalPrice);
        documentPrintPriceListNew.setCountColour(countColour);
        documentPrintPriceListNew.setDocumentPrintPriceListPrice(documentPrintPriceListPrice);
        documentPrintPriceListNew.setCount(count);
        documentPrintPriceListNew.setPageNumber(pdfPageNumber);
        return documentPrintPriceListNew;
    }
}
