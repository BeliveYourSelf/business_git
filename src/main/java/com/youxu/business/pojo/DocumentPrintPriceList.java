package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class DocumentPrintPriceList {
    private Integer id;

    private String storeId;

    private String documentPrintPriceListCode;

    private Double documentPrintPriceListPrice;

    private Date documentPrintPriceListCreateTime;

    private Date documentPrintPriceListModifyTime;

    private Boolean documentPrintPriceListStatus;


    // 新增
    private Integer count;// 文档打印份数

    private Integer pageNumber;// 文档页数

    private Double totalPrice;// 总价格

}