package com.youxu.business.pojo.idphotonewadd;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FileNameFather {
    @ApiModelProperty(name = "fileName", value = "证件照文件名称")
    private String fileName;

    @ApiModelProperty(name = "filePath", value = "证件照完整路径")
    private String filePath;
}
