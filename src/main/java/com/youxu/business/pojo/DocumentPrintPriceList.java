package com.youxu.business.pojo;

import java.util.Date;

public class DocumentPrintPriceList {
    private Integer id;

    private String documentPrintPriceListCode;

    private Double documentPrintPriceListPrice;

    private Date documentPrintPriceListCreateTime;

    private Date documentPrintPriceListModifyTime;

    private Boolean documentPrintPriceListStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentPrintPriceListCode() {
        return documentPrintPriceListCode;
    }

    public void setDocumentPrintPriceListCode(String documentPrintPriceListCode) {
        this.documentPrintPriceListCode = documentPrintPriceListCode == null ? null : documentPrintPriceListCode.trim();
    }

    public Double getDocumentPrintPriceListPrice() {
        return documentPrintPriceListPrice;
    }

    public void setDocumentPrintPriceListPrice(Double documentPrintPriceListPrice) {
        this.documentPrintPriceListPrice = documentPrintPriceListPrice;
    }

    public Date getDocumentPrintPriceListCreateTime() {
        return documentPrintPriceListCreateTime;
    }

    public void setDocumentPrintPriceListCreateTime(Date documentPrintPriceListCreateTime) {
        this.documentPrintPriceListCreateTime = documentPrintPriceListCreateTime;
    }

    public Date getDocumentPrintPriceListModifyTime() {
        return documentPrintPriceListModifyTime;
    }

    public void setDocumentPrintPriceListModifyTime(Date documentPrintPriceListModifyTime) {
        this.documentPrintPriceListModifyTime = documentPrintPriceListModifyTime;
    }

    public Boolean getDocumentPrintPriceListStatus() {
        return documentPrintPriceListStatus;
    }

    public void setDocumentPrintPriceListStatus(Boolean documentPrintPriceListStatus) {
        this.documentPrintPriceListStatus = documentPrintPriceListStatus;
    }
}