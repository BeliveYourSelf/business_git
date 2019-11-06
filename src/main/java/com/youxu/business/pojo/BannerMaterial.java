package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class BannerMaterial {
    private Integer id;

    private String contentName;

    private Date creationTime;

    private Date updateTime;

    private Boolean contentStatus;

    private Integer contentType;

    private String content;

}