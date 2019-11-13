package com.youxu.business.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderEvaluate {
    @ApiModelProperty(name = "id", value = "订单评价id")
    private Integer id;

    @ApiModelProperty(name = "orderEvaluateStar", value = "订单评价星级(1.一星2.二星3.三星4.四星5.五星)")
    private Integer orderEvaluateStar;

    @ApiModelProperty(name = "orderId", value = "订单id")
    private Integer orderId;

    @ApiModelProperty(name = "storeId", value = "店铺id")
    private Integer storeId;

    @ApiModelProperty(name = "orderComment", value = "订单评价内容")
    private String orderComment;

    @ApiModelProperty(name = "orderEvaluateCreateTime", value = "创建时间")
    private Date orderEvaluateCreateTime;

    @ApiModelProperty(name = "orderEvaluateModifyTime", value = "修改时间")
    private Date orderEvaluateModifyTime;

    @ApiModelProperty(name = "orderEvaluateStatus", value = "状态")
    private Boolean orderEvaluateStatus;

    @ApiModelProperty(name = "orderEvaluateAccount", value = "订单评价账户")
    private String orderEvaluateAccount;

    @ApiModelProperty(name = "orderEvaluatePhone", value = "订单评价手机号")
    private String orderEvaluatePhone;

    @ApiModelProperty(name = "orderEvaluateName", value = "订单评价人姓名")
    private String orderEvaluateName;

    // 新增
    @ApiModelProperty(name = "orderEvaluateOptionCartIdList", value = "订单评价选项卡集合")

    private List<Integer> orderEvaluateOptionCartIdList;

    @ApiModelProperty(name = "orderEvaluatePictureList", value = "订单评价图片集合")

    private List<String> orderEvaluatePictureList;
}