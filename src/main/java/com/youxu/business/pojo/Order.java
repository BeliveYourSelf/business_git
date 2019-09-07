package com.youxu.business.pojo;

import java.util.Date;

public class Order {
    private Integer id;

    private String orderAddresseeName;

    private String orderAddresseePhone;

    private String orderAddresseeAddress;

    private String orderFromStoreGet;

    private String orderFromStoreGetWhere;

    private String orderDeliveryPrescriptioTime;

    private String orderPrintMoney;

    private String orderDeliveryMoney;

    private Double orderCouponMoney;

    private String orderActualMoney;

    private Double orderConsumeMoney;

    private Double orderExtraMoney;

    private Integer orderType;

    private Date orderCreateTime;

    private Date orderModifyTime;

    private Boolean orderStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderAddresseeName() {
        return orderAddresseeName;
    }

    public void setOrderAddresseeName(String orderAddresseeName) {
        this.orderAddresseeName = orderAddresseeName == null ? null : orderAddresseeName.trim();
    }

    public String getOrderAddresseePhone() {
        return orderAddresseePhone;
    }

    public void setOrderAddresseePhone(String orderAddresseePhone) {
        this.orderAddresseePhone = orderAddresseePhone == null ? null : orderAddresseePhone.trim();
    }

    public String getOrderAddresseeAddress() {
        return orderAddresseeAddress;
    }

    public void setOrderAddresseeAddress(String orderAddresseeAddress) {
        this.orderAddresseeAddress = orderAddresseeAddress == null ? null : orderAddresseeAddress.trim();
    }

    public String getOrderFromStoreGet() {
        return orderFromStoreGet;
    }

    public void setOrderFromStoreGet(String orderFromStoreGet) {
        this.orderFromStoreGet = orderFromStoreGet == null ? null : orderFromStoreGet.trim();
    }

    public String getOrderFromStoreGetWhere() {
        return orderFromStoreGetWhere;
    }

    public void setOrderFromStoreGetWhere(String orderFromStoreGetWhere) {
        this.orderFromStoreGetWhere = orderFromStoreGetWhere == null ? null : orderFromStoreGetWhere.trim();
    }

    public String getOrderDeliveryPrescriptioTime() {
        return orderDeliveryPrescriptioTime;
    }

    public void setOrderDeliveryPrescriptioTime(String orderDeliveryPrescriptioTime) {
        this.orderDeliveryPrescriptioTime = orderDeliveryPrescriptioTime == null ? null : orderDeliveryPrescriptioTime.trim();
    }

    public String getOrderPrintMoney() {
        return orderPrintMoney;
    }

    public void setOrderPrintMoney(String orderPrintMoney) {
        this.orderPrintMoney = orderPrintMoney == null ? null : orderPrintMoney.trim();
    }

    public String getOrderDeliveryMoney() {
        return orderDeliveryMoney;
    }

    public void setOrderDeliveryMoney(String orderDeliveryMoney) {
        this.orderDeliveryMoney = orderDeliveryMoney == null ? null : orderDeliveryMoney.trim();
    }

    public Double getOrderCouponMoney() {
        return orderCouponMoney;
    }

    public void setOrderCouponMoney(Double orderCouponMoney) {
        this.orderCouponMoney = orderCouponMoney;
    }

    public String getOrderActualMoney() {
        return orderActualMoney;
    }

    public void setOrderActualMoney(String orderActualMoney) {
        this.orderActualMoney = orderActualMoney == null ? null : orderActualMoney.trim();
    }

    public Double getOrderConsumeMoney() {
        return orderConsumeMoney;
    }

    public void setOrderConsumeMoney(Double orderConsumeMoney) {
        this.orderConsumeMoney = orderConsumeMoney;
    }

    public Double getOrderExtraMoney() {
        return orderExtraMoney;
    }

    public void setOrderExtraMoney(Double orderExtraMoney) {
        this.orderExtraMoney = orderExtraMoney;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getOrderModifyTime() {
        return orderModifyTime;
    }

    public void setOrderModifyTime(Date orderModifyTime) {
        this.orderModifyTime = orderModifyTime;
    }

    public Boolean getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Boolean orderStatus) {
        this.orderStatus = orderStatus;
    }
}