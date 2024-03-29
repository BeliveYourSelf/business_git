package com.youxu.business.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDetails {
    @ApiModelProperty(name = "id",value = "订单明细id")
    private Integer id;

    @ApiModelProperty(name = "orderId",value = "订单id")
    private Integer orderId;

    @ApiModelProperty(name = "orderDetailsName",value = "订单明细名称")
    private String orderDetailsName;

    @ApiModelProperty(name = "orderDetailsCount",value = "订单明细数量")
    private Integer orderDetailsCount;

    @ApiModelProperty(name = "orderDetailsOnePictureUrl",value = "订单明细图片路径")
    private String orderDetailsOnePictureUrl;

    @ApiModelProperty(name = "orderDetailsTypesettingPictureUrl",value = "忽略")
    private String orderDetailsTypesettingPictureUrl;

    @ApiModelProperty(name = "orderDetailsTotalPrice",value = "订单明细总价")
    private Double orderDetailsTotalPrice;

    @ApiModelProperty(name = "orderSpecName",value = "规格名称（文档打印使用）")
    private String orderSpecName;

    @ApiModelProperty(name = "orderDetailsCountColour",value = "商品彩色数量（文档打印使用）")
    private String orderDetailsCountColour;

    @ApiModelProperty(name = "orderDetailsCreateTime",value = "订单明细创建时间")
    private Date orderDetailsCreateTime;

    @ApiModelProperty(name = "orderDetailsModifyTime",value = "订单明细修改时间")
    private Date orderDetailsModifyTime;

    @ApiModelProperty(name = "orderDetailsStatus",value = "订单明细状态")
    private Boolean orderDetailsStatus;

    @ApiModelProperty(name = "orderDetailsType",value = "订单类别：1.证件照2.照片冲洗3.文档打印4.普通打印")
    private Integer orderDetailsType;

    @ApiModelProperty(name = "orderDetailsPage",value = "订单详情页数")
    private Integer orderDetailsPage;

    @ApiModelProperty(name = "orderDetailsOnePictureUrlPdf",value = "订单详情Pdf路径")
    private String orderDetailsOnePictureUrlPdf;

    // 新增
    @ApiModelProperty(name = "orderDetailsBookBinding",value = "装订订单明细表")
    private OrderDetailsBookBinding orderDetailsBookBinding;

    @ApiModelProperty(name = "pictureUrlList",value = "文档链接集合")
    private List<String> pictureUrlList;

    @ApiModelProperty(name = "pictureList",value = "图片对象")
    private List<Picture> pictureList;

    @ApiModelProperty(name = "orderDetailsPictureMapping",value = "图片明细映射表")
    private List<OrderDetailsPictureMapping> orderDetailsPictureMappingList;




}
