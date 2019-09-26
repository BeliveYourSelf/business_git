package com.youxu.business.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class Share {
    private Integer id;

    private Integer shareUserId;

    private String periodOfValidity;

    private Boolean extactionCodeStatus;

    private String extactionCode;

    private Boolean downloadDuplicatedPrintStatus;

    private BigDecimal resourcePrintMoney;

    private BigDecimal resourceSaveDownloadMoney;

    private String qrCode;

    private String usreHeadImage;

    private String shareContentUrl;

    private Date createTime;

    private Date modifyTime;

    private Boolean status;

    private Integer buyUserId;//收藏人的用户id


    //新增
    private Order order;


}