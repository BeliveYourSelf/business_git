package com.youxu.business.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @ApiModelProperty(name = "qrCode", value = "小程序二维码链接")
    private String qrCode;

    @ApiModelProperty(name = "browserUrl", value = "浏览器跳转链接")
    private String browserUrl;

    @ApiModelProperty(name = "shareContentUrl", value = "分享内容url：文件文件夹json串")
    private String shareContentUrl;

    @ApiModelProperty(name = "usreHeadImage", value = "用户头像url")
    private String usreHeadImage;

    @ApiModelProperty(name = "folder", value = "文件夹")
    private Folder folder;

    @ApiModelProperty(name = "folderIds", value = "未使用")
    private String folderIds;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm:ss")
    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm:ss")
    @ApiModelProperty(name = "modifyTime", value = "修改时间")
    private Date modifyTime;

    @ApiModelProperty(name = "status", value = "显示状态")
    private Boolean status;

    @ApiModelProperty(name = "buyUserId", value = "收藏人的用户id")
    private Integer buyUserId;//收藏人的用户id

    //新增
    @ApiModelProperty(name = "order", value = "订单对象")
    private Order order;

    @ApiModelProperty(name = "tradeType",value = "支付类别：  JSAPI/NATIVE")
    private String tradeType;


}