package com.youxu.business.pojo;

import java.util.Date;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderDetailsName() {
        return orderDetailsName;
    }

    public void setOrderDetailsName(String orderDetailsName) {
        this.orderDetailsName = orderDetailsName == null ? null : orderDetailsName.trim();
    }

    public Integer getOrderDetailsCount() {
        return orderDetailsCount;
    }

    public void setOrderDetailsCount(Integer orderDetailsCount) {
        this.orderDetailsCount = orderDetailsCount;
    }

    public String getOrderDetailsOnePictureUrl() {
        return orderDetailsOnePictureUrl;
    }

    public void setOrderDetailsOnePictureUrl(String orderDetailsOnePictureUrl) {
        this.orderDetailsOnePictureUrl = orderDetailsOnePictureUrl == null ? null : orderDetailsOnePictureUrl.trim();
    }

    public String getOrderDetailsTypesettingPictureUrl() {
        return orderDetailsTypesettingPictureUrl;
    }

    public void setOrderDetailsTypesettingPictureUrl(String orderDetailsTypesettingPictureUrl) {
        this.orderDetailsTypesettingPictureUrl = orderDetailsTypesettingPictureUrl == null ? null : orderDetailsTypesettingPictureUrl.trim();
    }

    public Double getOrderDetailsTotalPrice() {
        return orderDetailsTotalPrice;
    }

    public void setOrderDetailsTotalPrice(Double orderDetailsTotalPrice) {
        this.orderDetailsTotalPrice = orderDetailsTotalPrice;
    }

    public Date getOrderDetailsCreateTime() {
        return orderDetailsCreateTime;
    }

    public void setOrderDetailsCreateTime(Date orderDetailsCreateTime) {
        this.orderDetailsCreateTime = orderDetailsCreateTime;
    }

    public Date getOrderDetailsModifyTime() {
        return orderDetailsModifyTime;
    }

    public void setOrderDetailsModifyTime(Date orderDetailsModifyTime) {
        this.orderDetailsModifyTime = orderDetailsModifyTime;
    }

    public Boolean getOrderDetailsStatus() {
        return orderDetailsStatus;
    }

    public void setOrderDetailsStatus(Boolean orderDetailsStatus) {
        this.orderDetailsStatus = orderDetailsStatus;
    }
}