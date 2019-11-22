package com.youxu.business.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order extends PageInfo {
    @ApiModelProperty(name = "id", value = "订单id")
    private Integer id;

    @ApiModelProperty(name = "storeId", value = "商铺id")
    private Integer storeId;

    @ApiModelProperty(name = "userId", value = "用户id（付款方）")
    private Integer userId;

    @ApiModelProperty(name = "orderAddresseeName", value = "收件人姓名")
    private String orderAddresseeName;

    @ApiModelProperty(name = "orderAddresseePhone", value = "收件人手机号")
    private String orderAddresseePhone;

    @ApiModelProperty(name = "orderAddresseeAddress", value = "收件人地址")
    private String orderAddresseeAddress;

    @ApiModelProperty(name = "orderFromStoreGet", value = "1.到店自取2.自助打印3.及时配送4.顺丰配送")
    private String orderFromStoreGet;

    @ApiModelProperty(name = "orderFromStoreGetWhere", value = "到店自取的店铺")
    private String orderFromStoreGetWhere;

    @ApiModelProperty(name = "orderDeliveryPrescriptioTime", value = "配送时效:前台传入是分钟，数据库和后台为时间戳")
    private String orderDeliveryPrescriptioTime;

    @ApiModelProperty(name = "orderPrintMoney", value = "打印钱数")
    private String orderPrintMoney;

    @ApiModelProperty(name = "orderDeliveryMoney", value = "配送钱数")
    private String orderDeliveryMoney;

    @ApiModelProperty(name = "orderActualMoney", value = "实际支付")
    private Double orderActualMoney;

    @ApiModelProperty(name = "orderConsumeMoney", value = "消费金")
    private Double orderConsumeMoney;

    @ApiModelProperty(name = "orderExtraMoney", value = "附加费")
    private Double orderExtraMoney;

    @ApiModelProperty(name = "orderType", value = "订单类别：1.证件照2.照片冲洗3.文档打印4.会员充值5.会员支付")
    private Integer orderType;

    @ApiModelProperty(name = "orderPayDate", value = "订单支付时间")
    private Date orderPayDate;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm:ss")
    @ApiModelProperty(name = "orderCreateTime", value = "创建时间")
    private Date orderCreateTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm:ss")
    @ApiModelProperty(name = "orderModifyTime", value = "修改时间")
    private Date orderModifyTime;

    @ApiModelProperty(name = "orderProcess", value = "订单进行状态:1.待付款2.进行中3.已完成4.已取消")
    private Integer orderProcess;

    @ApiModelProperty(name = "orderStatus", value = "状态")
    private Boolean orderStatus;

    @ApiModelProperty(name = "deliveryId", value = "配送人id")
    private Integer deliveryId;

    @ApiModelProperty(name = "deliveryPickUpFileQRCodeUrl", value = "取件二维码url")
    private String deliveryPickUpFileQRCodeUrl;

    @ApiModelProperty(name = "deliveryHarvestCode", value = "收货码")
    private String deliveryHarvestCode;

    @ApiModelProperty(name = "deliveryStatus", value = "配送状态（0.未发货/1.待取件/2.配送中/3.问题件/4.已完成/5.实时订单/6.顺丰配送）")
    private Integer deliveryStatus;

    @ApiModelProperty(name = "deliveryProblemFileMark", value = "问题件标注     #:(间隔符：间隔追加问题）")
    private String deliveryProblemFileMark;

    @ApiModelProperty(name = "shareUserId", value = "分享人id（收款方，orderType：6和7的时候使用）")
    private Integer shareUserId;

    @ApiModelProperty(name = "orderRemark", value = "备注信息")
    private String orderRemark;

    @ApiModelProperty(name = "shareId", value = "分享id")
    private Integer shareId;
    // 新增对象
    @ApiModelProperty(name = "userPiectureUrl", value = "用户头像")
    private String userPiectureUrl;

    @ApiModelProperty(name = "orderDetails", value = "订单对象")
    private OrderDetails orderDetails;
    // 新增对象集合
    @ApiModelProperty(name = "orderDetailsList", value = "订单对象集合")
    private List<OrderDetails> orderDetailsList;

    @ApiModelProperty(name = "pictureList", value = "图片/文档对象")
    private List<Picture> pictureList;

    @ApiModelProperty(name = "storeIdList", value = "商铺id集合")
    private List<String> storeIdList;

    private String openId;

    @ApiModelProperty(name = "theCategory", value = "配送员类别：1:全职，2：兼职")
    private Integer theCategory;

    @ApiModelProperty(name = "whetherMembers", value = "是否是会员")
    private Boolean whetherMembers;

    @ApiModelProperty(name = "vouchersIdList", value = "优惠券id集合：可能是代金券或者配送券。支付的时候返回给前端让他删除")
    private List<Integer> vouchersIdList;

    @ApiModelProperty(name = "vouchersIds", value = "(前台未使用)优惠券id：可能是代金券或者配送券。支付的时候返回给前端让他删除")
    private String vouchersIds;

    @ApiModelProperty(name = "tradeType", value = "支付类别：  JSAPI/NATIVE")
    private String tradeType;

    @ApiModelProperty(name = "expireTime", value = "到期时间")
    private String expireTime;

    @ApiModelProperty(name = "orderAssignExpress", value = "指派快件（0待指派/1.全部配送员/2特殊指派/3全职配送员/4.兼职配送员/5.顺丰配送）")
    private Integer orderAssignExpress;

    @ApiModelProperty(name = "orderCouponMoneyId", value = "优惠券id（代金券）")
    private Integer orderCouponMoneyId;

    @ApiModelProperty(name = "orderCouponMoney", value = "优惠券面额（代金券）")
    private Double orderCouponMoney;

    @ApiModelProperty(name = "orderCouponDeliveryId", value = "配送券id")
    private Integer orderCouponDeliveryId;

    @ApiModelProperty(name = "orderCouponDeliveryMoney", value = "配送券面额")
    private Integer orderCouponDeliveryMoney;

    @ApiModelProperty(name = "orderTypeOther", value = "1.普通达2.一小时达3.精准达")
    private Integer orderTypeOther;

    @ApiModelProperty(name = "orderAllPage", value = "文档总页数")
    private Integer orderAllPage;

    @ApiModelProperty(name = "orderHarvestTime", value = "收货时间")
    private Date orderHarvestTime;


}