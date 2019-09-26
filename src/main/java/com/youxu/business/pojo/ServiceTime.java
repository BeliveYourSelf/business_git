package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class ServiceTime {
    private Integer id;

    private Date serviceTime;

    private Double price;

    private Integer storeId;

    private Date createTime;

    private Date modifyTime;

    private Boolean status;

    private Integer weight;

    private Byte dayType;

    private Double oneHourServicePrice;

    private Byte serviceType;


}