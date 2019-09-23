package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class DictionaryDocumentSize {
    private Integer id;

    private Integer storeId;

    private String documentSizeName;

    private Date createTime;

    private Date modifyTime;

    private Boolean status;
}