package com.youxu.business.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class OrderDetailsBookBinding {
    @ApiModelProperty(name = "id",value = "装订订单明细表id")
    private Integer id;

    @ApiModelProperty(name = "orderDetailsId",value = "订单明细表id")
    private Integer orderDetailsId;

    @ApiModelProperty(name = "coverColor",value = "装订订单明细表封面颜色")
    private String coverColor;

    @ApiModelProperty(name = "faceDirection",value = "装订订单明细表版面方向")
    private String faceDirection;

    @ApiModelProperty(name = "coverFileUrl",value = "装订订单明封面文件路径")
    private String coverFileUrl;

    @ApiModelProperty(name = "createTime",value = "装订订单明细表创建时间")
    private Date createTime;

    @ApiModelProperty(name = "modifyTime",value = "装订订单明细表修改时间")
    private Date modifyTime;

    @ApiModelProperty(name = "status",value = "装订订单明细表显示状态")
    private Boolean status;


}