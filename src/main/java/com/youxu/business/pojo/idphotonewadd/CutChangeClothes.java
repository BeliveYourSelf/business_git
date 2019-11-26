package com.youxu.business.pojo.idphotonewadd;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CutChangeClothes {
    @ApiModelProperty(name = "file", value = "图片的base64数据，同一张照片第一次换装时，需要传入此参数")
    private String file;

    @ApiModelProperty(name = "app_key", value = "已申请的app_key")
    private String app_key = "69f50c487f42e8e62823b464a4af019bcae8a8ab";

    @ApiModelProperty(name = "spec_id", value = "规格id")

    private String spec_id;

    @ApiModelProperty(name = "width_px", value = "自定义像素宽度值")
    private String width_px;

    @ApiModelProperty(name = "height_px", value = "自定义像素高度值")
    private String height_px;

    @ApiModelProperty(name = "clothes", value = "正装模板名称（模板信息见下表）")
    private String clothes;

    @ApiModelProperty(name = "fair_level", value = "美颜级别（默认为0，代表不美颜，级别1-5，美颜程度依次增强）")
    private String fair_level;

    @ApiModelProperty(name = "origin_pic_name", value = "初始图片名称，同一张照片进行不同换装时，请传入此参数")
    private String origin_pic_name;
}
