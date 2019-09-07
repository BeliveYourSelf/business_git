package com.youxu.business.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
    @ApiModelProperty(name = "id",value = "订单id")
    private Integer id;

    @ApiModelProperty(name = "storeId",value = "商铺id")
    private Integer storeId;

    @ApiModelProperty(name = "userId",value = "用户id")
    private Integer userId;

    @ApiModelProperty(name = "orderAddresseeName",value = "收件人姓名")
    private String orderAddresseeName;

    @ApiModelProperty(name = "orderAddresseePhone",value = "收件人手机号")
    private String orderAddresseePhone;

    @ApiModelProperty(name = "orderAddresseeAddress",value = "收件人地址")
    private String orderAddresseeAddress;

    @ApiModelProperty(name = "orderFromStoreGet",value = "1.到店自取2.自助打印3.及时配送4.顺丰配送")
    private String orderFromStoreGet;

    @ApiModelProperty(name = "orderFromStoreGetWhere",value = "到店自取的店铺")
    private String orderFromStoreGetWhere;

    @ApiModelProperty(name = "orderDeliveryPrescriptioTime",value = "配送时效")
    private String orderDeliveryPrescriptioTime;

    @ApiModelProperty(name = "orderPrintMoney",value = "打印钱数")
    private String orderPrintMoney;

    @ApiModelProperty(name = "orderDeliveryMoney",value = "配送钱数")
    private String orderDeliveryMoney;

    @ApiModelProperty(name = "orderCouponMoney",value = "优惠券（代金券）")
    private Double orderCouponMoney;

    @ApiModelProperty(name = "orderActualMoney",value = "实际支付")
    private String orderActualMoney;

    @ApiModelProperty(name = "orderConsumeMoney",value = "消费金")
    private Double orderConsumeMoney;

    @ApiModelProperty(name = "orderExtraMoney",value = "附加费")
    private Double orderExtraMoney;

    @ApiModelProperty(name = "orderType",value = "订单类别：1.证件照2.照片冲洗3.文档打印4.会员充值5.会员支付")
    private Integer orderType;

    @ApiModelProperty(name = "orderCreateTime",value = "创建时间")
    private Date orderCreateTime;

    @ApiModelProperty(name = "orderModifyTime",value = "修改时间")
    private Date orderModifyTime;

    @ApiModelProperty(name = "orderStatus",value = "状态")
    private Boolean orderStatus;

    @ApiModelProperty(name = "orderProcess",value = "订单进行状态:1.待付款2.进行中3.已完成4.已取消")
    private Integer orderProcess;

    // 新增对象
    @ApiModelProperty(name = "orderDetails",value = "订单对象")
    private OrderDetails orderDetails;
    // 新增对象集合
    @ApiModelProperty(name = "orderDetailsList",value = "订单对象集合")
    private List<OrderDetails> orderDetailsList;

}