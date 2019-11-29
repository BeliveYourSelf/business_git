package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Notify {
    private Integer id;

    private String notifyInfo;

    private Date createTime;

    private Date modifyTime;

    private Boolean notifyStatus;
}