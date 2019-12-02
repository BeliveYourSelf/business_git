package com.youxu.business.utils.pojotools;

import com.youxu.business.pojo.idphotonewadd.BackgroundColor;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class IdPhotoMarkAndTest {
    @ApiModelProperty(name = "file", value = "图片的base64数据")
    private String file;

    @ApiModelProperty(name = "app_key", value = "制作并检测")
    private String app_key = "2abf79c1e6f1aa18583f6a38d05336eae9baf3e3";

    @ApiModelProperty(name = "spec_id", value = "已有的规格ID")
    private String spec_id;

    @ApiModelProperty(name = "is_fair", value = "是否美颜，默认为美颜")
    private Integer is_fair;

    @ApiModelProperty(name = "fair_level", value = "美颜等级，分为1,2,3,4,5等级")
    private Integer fair_level;

    @ApiModelProperty(name = "background_color", value = "")
    private List<BackgroundColor> background_color;
}
