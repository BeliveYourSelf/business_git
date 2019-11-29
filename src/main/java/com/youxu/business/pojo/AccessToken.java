package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class AccessToken {
    private Integer id;

    private String accessToken;

    private Date createTime;

    private Date modifyTime;

    //   新增字段
    private String modifyTimeString;
}