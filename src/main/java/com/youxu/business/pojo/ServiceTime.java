package com.youxu.business.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class ServiceTime {
    @ApiModelProperty(name = "id", value = "配送时间价格表id")
    private Integer id;

    @JsonFormat(timezone = "GMT", pattern = "HH:mm")
    @ApiModelProperty(name = "serviceTime", value = "送达时间")
    private Date serviceTime;

    @ApiModelProperty(name = "price", value = "价格")
    private Double price;

    @ApiModelProperty(name = "storeId", value = "商铺id")
    private Integer storeId;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "modifyTime", value = "修改时间")
    private Date modifyTime;

    @ApiModelProperty(name = "status", value = "显示状态")
    private Boolean status;

    @ApiModelProperty(name = "weight", value = "权重")
    private Integer weight;

    @ApiModelProperty(name = "dayType", value = "1.今天2.明天3.后天")
    private Byte dayType;

    @ApiModelProperty(name = "serviceType", value = "类别:1.普通类别2.一小时达")
    private Byte serviceType;


}