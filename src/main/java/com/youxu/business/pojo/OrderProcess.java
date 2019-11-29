package com.youxu.business.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderProcess {
    @ApiModelProperty(name = "processWait", value = "待付款")
    private Integer processWait;

    @ApiModelProperty(name = "processing", value = "进行中")
    private Integer processing;

    @ApiModelProperty(name = "processCompetety", value = "已完成")
    private Integer processCompetety;

    @ApiModelProperty(name = "processCancel", value = "已取消")
    private Integer processCancel;
}
