package com.youxu.business.pojo.idphotonewadd;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class NotCheckResult {
    @ApiModelProperty(name = "check_param", value = "检测的参数")
    private String check_param;

    @ApiModelProperty(name = "param_message", value = "参数信息")
    private String param_message;
}
