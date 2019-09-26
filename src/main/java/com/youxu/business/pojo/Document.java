package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Document {
    private Integer id;

    private Integer userId;

    private Integer folderId;

    private String documentUrl;

    private Date createTime;

    private Date modifyTime;

    private Boolean status;


}