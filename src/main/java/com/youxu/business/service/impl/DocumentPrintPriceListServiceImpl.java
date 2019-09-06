package com.youxu.business.service.impl;

import com.youxu.business.dao.DocumentPrintPriceListMapper;
import com.youxu.business.pojo.DocumentPrintPriceList;
import com.youxu.business.service.DocumentPrintPriceListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DocumentPrintPriceListServiceImpl implements DocumentPrintPriceListService {

    @Resource
    private DocumentPrintPriceListMapper documentPrintPriceListMapper;

    @Override
    public DocumentPrintPriceList selectDocumentPrintPriceList(DocumentPrintPriceList documentPrintPriceList) {
        //查看价格
        Integer count = documentPrintPriceList.getCount();
        String documentPrintPriceListCode = documentPrintPriceList.getDocumentPrintPriceListCode();
        DocumentPrintPriceList documentPrintPriceListNew = documentPrintPriceListMapper.selectDocumentPrintPriceList(documentPrintPriceListCode);
        //份数*单价
        Double documentPrintPriceListPrice = documentPrintPriceListNew.getDocumentPrintPriceListPrice();
        double totalPrice = count * documentPrintPriceListPrice;
        documentPrintPriceListNew.setDocumentPrintPriceListPrice(totalPrice);
        return documentPrintPriceListNew;
    }
}
