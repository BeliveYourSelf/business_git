package com.youxu.business.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class DictionaryDocumentSize {
    private Integer id;

    private Integer storeId;
    @ApiModelProperty(name = "documentSizeName", value = "文档尺寸大小")
    private String documentSizeName;

@ApiModelProperty(name = "isBinding", value = "是否装订： 0是 1否")
    private Integer isBinding;

    private Date createTime;

    private Date modifyTime;

    private Boolean status;
}