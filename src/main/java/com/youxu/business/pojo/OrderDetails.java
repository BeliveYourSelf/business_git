package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class OrderDetails {
    private Integer id;

    private Integer orderId;

    private String orderDetailsName;

    private Integer orderDetailsCount;

    private String orderDetailsOnePictureUrl;

    private String orderDetailsTypesettingPictureUrl;

    private Double orderDetailsTotalPrice;

    private Date orderDetailsCreateTime;

    private Date orderDetailsModifyTime;

    private Boolean orderDetailsStatus;
}
