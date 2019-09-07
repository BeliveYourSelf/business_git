package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
    private Integer id;

    private Integer storeId;

    private Integer userId;

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

    private Integer orderProcess;

    // 新增对象
    private OrderDetails orderDetails;
    private List<OrderDetails> orderDetailsList;
}