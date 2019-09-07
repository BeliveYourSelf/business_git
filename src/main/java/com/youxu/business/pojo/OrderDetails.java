package com.youxu.business.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
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

    @ApiModelProperty(name = "orderDetailsCreateTime",value = "订单明细创建时间")
    private Date orderDetailsCreateTime;

    @ApiModelProperty(name = "orderDetailsModifyTime",value = "订单明细修改时间")
    private Date orderDetailsModifyTime;

    @ApiModelProperty(name = "orderDetailsStatus",value = "订单明细状态")
    private Boolean orderDetailsStatus;
}
