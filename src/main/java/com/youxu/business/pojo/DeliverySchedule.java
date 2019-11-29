package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class DeliverySchedule {
    private Integer id;

    private Integer storeId;

    private String deliveryTime;

    private Date createTime;

    private Date updateTime;

    private Boolean status;


}