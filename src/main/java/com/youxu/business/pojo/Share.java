package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Share {
    private Integer id;

    private Integer shareUserId;

    private Date periodOfValidity;

    private Boolean extactionCodeStatus;

    private String extactionCode;

    private Boolean downloadDuplicatedPrintStatus;

    private Double downloadDuplicatedPrintMoney;

    private String qrCode;

    private String usreHeadImage;

    private String shareContentUrl;

    private Date createTime;

    private Date modifyTime;

    private Boolean status;


}