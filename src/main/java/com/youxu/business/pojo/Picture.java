package com.youxu.business.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Picture {
    @ApiModelProperty(name = "orderCouponDeliveryId",value = "（图片/文档）id")
    private Integer pictureId;

    @ApiModelProperty(name = "pictureUrl",value = "（图片/文档）路径")
    private String pictureUrl;

    /*@ApiModelProperty(name = "picturePage",value = "（图片/文档）大小")
    private Integer picturePage;*/


}