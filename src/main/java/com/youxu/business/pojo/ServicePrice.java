package com.youxu.business.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ServicePrice {//配送价格

    private int id;

    @ApiModelProperty(name = "storeId",value = "店铺id")
    private int storeId; //店铺id

    @ApiModelProperty(name = "startTime",value = "送达时间开始时间例：08:00")
    private String startTime; //开始时间

    @ApiModelProperty(name = "endTime",value = "送达时间结束时间例：18:00")
    private String endTime; //结束时间

    @ApiModelProperty(name = "price",value = "配送价格")
    private double price;//配送价格

    @ApiModelProperty(name = "createTime",value = "创建时间")
    private String createTime;//创建时间

    @ApiModelProperty(name = "serviceType",value = "1.今天，2.明天，3.后天，4.一小时达，5.精准达")
    private int serviceType;//1.今天，2.明天，3.后天，4.一小时达，5.精准达

}
