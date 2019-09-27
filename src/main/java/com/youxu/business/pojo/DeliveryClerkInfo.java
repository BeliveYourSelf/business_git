package com.youxu.business.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class DeliveryClerkInfo {
    @ApiModelProperty(name = "id", value = "配送员id")
    private Integer id;

    @ApiModelProperty(name = "userId", value = "配送员用户id")
    private Integer userId;

    @ApiModelProperty(name = "deliveryClerkName", value = "配送员姓名")
    private String deliveryClerkName;

    @ApiModelProperty(name = "deliveryClerkPhone", value = "配送员电话号")
    private String deliveryClerkPhone;

    @ApiModelProperty(name = "emergencyPerson", value = "紧急联系人姓名")
    private String emergencyPerson;

    @ApiModelProperty(name = "emergencyPhone", value = "紧急联系人手机号")
    private String emergencyPhone;

    @ApiModelProperty(name = "idCardNum", value = "身份证号码")
    private String idCardNum;

    @ApiModelProperty(name = "idCardPositive", value = "身份证正面照片")
    private String idCardPositive;

    @ApiModelProperty(name = "idCardOtherSize", value = "身份证反面照片")
    private String idCardOtherSize;

    @ApiModelProperty(name = "cumulativeDeliveryThisMonth", value = "本月累计配送")
    private Integer cumulativeDeliveryThisMonth;

    @ApiModelProperty(name = "cumulativeIncome", value = "累计收益")
    private Double cumulativeIncome;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "modifyTime", value = "修改时间")
    private Date modifyTime;

    @ApiModelProperty(name = "status", value = "显示状态")
    private Boolean status;

    @ApiModelProperty(name = "auditStatus", value = "配送员信息表")
    private Integer auditStatus;

    @ApiModelProperty(name = "score", value = "人脸评分")
    private Integer score;

//  新增
    @ApiModelProperty(name = "storeId", value = "商铺id")
    private Integer storeId;

    @ApiModelProperty(name = "image", value = "base64图片")
    private String image;






}