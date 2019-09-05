package com.youxu.business.pojo;

import java.util.Date;

public class Order {
    private Integer id;

    private Integer orderUserId;

    private String orderAddresseeName;

    private String orderAddresseePhone;

    private String orderAddresseeAddress;

    private String orderFromStoreGet;

    private String orderFromStoreGetWhere;

    private String orderDeliveryPrescriptionTime;

    private String orderPrintMoney;

    private String orderDeliveryMoney;

    private String orderActualMoney;

    private Date orderCreateTime;

    private Date orderModifyTime;

    private Boolean orderStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(Integer orderUserId) {
        this.orderUserId = orderUserId;
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

    public String getOrderDeliveryPrescriptionTime() {
        return orderDeliveryPrescriptionTime;
    }

    public void setOrderDeliveryPrescriptionTime(String orderDeliveryPrescriptionTime) {
        this.orderDeliveryPrescriptionTime = orderDeliveryPrescriptionTime == null ? null : orderDeliveryPrescriptionTime.trim();
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

    public String getOrderActualMoney() {
        return orderActualMoney;
    }

    public void setOrderActualMoney(String orderActualMoney) {
        this.orderActualMoney = orderActualMoney == null ? null : orderActualMoney.trim();
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