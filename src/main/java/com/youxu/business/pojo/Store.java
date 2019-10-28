package com.youxu.business.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class Store {
    @ApiModelProperty(name = "id",value = "店铺id")
    private Integer id;

    @ApiModelProperty(name = "storeName",value = "店铺名称")
    private String storeName;

    @ApiModelProperty(name = "storeAddress",value = "店铺地址")
    private String storeAddress;

    @ApiModelProperty(name = "storePhone",value = "店铺手机号")
    private String storePhone;

    @ApiModelProperty(name = "storeTime",value = "营业时间")
    private String storeTime;

    @ApiModelProperty(name = "storeOpenForOut",value = "是否对外开放  0 不对外开放   1对外开放")
    private Byte storeOpenForOut;

    @ApiModelProperty(name = "outputSize",value = "输出尺寸")
    private String outputSize;

    @ApiModelProperty(name = "storeOutputColour",value = "输出色彩")
    private String storeOutputColour;

    @ApiModelProperty(name = "storeQuality",value = "输出质量   1一般 2高质量  3全都有")
    private String storeQuality;

    @ApiModelProperty(name = "storeLatitude",value = "纬度")
    private Double storeLatitude;

    @ApiModelProperty(name = "storeLongitude",value = "经度")
    private Double storeLongitude;

    @ApiModelProperty(name = "createTime",value = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "modifyTime",value = "修改时间")
    private Date modifyTime;

    @ApiModelProperty(name = "status",value = "配送员每单的价格")
    private Boolean status;

    @ApiModelProperty(name = "deliveryclerkPricePerOne",value = "配送员每单的价格")
    private Double deliveryclerkPricePerOne;

    @ApiModelProperty(name = "licencePrice",value = "证件照价格")
    private Double licencePrice;


}