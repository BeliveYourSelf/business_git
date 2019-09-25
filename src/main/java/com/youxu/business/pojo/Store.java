package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Store {
    private Integer id;

    private String storeName;

    private String storeAddress;

    private String storePhone;

    private String storeTime;

    private Byte storeOpenForOut;

    private String outputSize;

    private String storeOutputColour;

    private String storeQuality;

    private Double storeLatitude;

    private Double storeLongitude;

    private Date createTime;

    private Date modifyTime;

    private Boolean status;


}