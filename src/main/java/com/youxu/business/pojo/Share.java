package com.youxu.business.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class Share {
    @ApiModelProperty(name = "id", value = "分享表id")
    private Integer id;

    @ApiModelProperty(name = "shareUserId", value = "分享人用户id")
    private Integer shareUserId;

    @ApiModelProperty(name = "periodOfValidity", value = "有效期")
    private String periodOfValidity;

    @ApiModelProperty(name = "extactionCodeStatus", value = "是否有提取码")
    private Boolean extactionCodeStatus;

    @ApiModelProperty(name = "extactionCode", value = "提取码")
    private String extactionCode;

    @ApiModelProperty(name = "downloadDuplicatedPrintStatus", value = "是否可下载或转存  1.不可下载或转存 2.可下载或转存")
    private Boolean downloadDuplicatedPrintStatus;

    @ApiModelProperty(name = "resourcePrintMoney", value = "资源打印售价")
    private BigDecimal resourcePrintMoney;

    @ApiModelProperty(name = "resourceSaveDownloadMoney", value = "资源转存下载售价")
    private BigDecimal resourceSaveDownloadMoney;

    @ApiModelProperty(name = "qrCode", value = "二维码链接")
    private String qrCode;

    @ApiModelProperty(name = "usreHeadImage", value = "用户头像url")
    private String usreHeadImage;

    @ApiModelProperty(name = "shareContentUrl", value = "分享内容url")
    private String shareContentUrl;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "modifyTime", value = "修改时间")
    private Date modifyTime;

    @ApiModelProperty(name = "status", value = "显示状态")
    private Boolean status;

    @ApiModelProperty(name = "buyUserId", value = "收藏人的用户id")
    private Integer buyUserId;//收藏人的用户id

    @ApiModelProperty(name = "browserShareContentUrl", value = "浏览器分享内容路径")
    private String browserShareContentUrl;

    //新增
    @ApiModelProperty(name = "order", value = "订单对象")
    private Order order;

    @ApiModelProperty(name = "tradeType",value = "支付类别：  JSAPI/NATIVE")
    private String tradeType;


}