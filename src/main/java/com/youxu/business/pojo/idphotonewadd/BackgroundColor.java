package com.youxu.business.pojo.idphotonewadd;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BackgroundColor {
    @ApiModelProperty(name = "enc_color", value = "结束色值（对应的RGB），十进制")
    private String enc_color;

    @ApiModelProperty(name = "color_name", value = "颜色名称")
    private String color_name;

    @ApiModelProperty(name = "start_color", value = "起始色值（对应的RGB），十进制")
    private String start_color;
}
