package com.youxu.business.pojo.idphotonewadd;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@Data
public class GetSpecs {
    @ApiModelProperty(name = "background_color", value = "生成图片的颜色集合-字符串")
    private String background_color;


    @ApiModelProperty(name = "background_color_List", value = "生成图片的颜色集合-对象")
    private List<BackgroundColor> background_color_List;

    @ApiModelProperty(name = "code", value = "状态码（200为正常请求，401为传入的规格id不存在）")
    private String code;

    @ApiModelProperty(name = "file_size_max", value = "规格文件大小最大值（单位：b），为null则表示没有限制")
    private String file_size_max;

    @ApiModelProperty(name = "file_size_min", value = "规格文件大小最小值（单位：b），为null则表示没有限制")
    private String file_size_min;

    @ApiModelProperty(name = "height_mm", value = "规格对应的高度毫米尺寸")
    private String height_mm;

    @ApiModelProperty(name = "height_px", value = "规格高度像素")
    private String height_px;

    @ApiModelProperty(name = "is_print", value = "是否有排版照（1，表示有；0，表示没有）")
    private String is_print;

    @ApiModelProperty(name = "ppi", value = "规格分辨率")
    private String ppi;

    @ApiModelProperty(name = "spec_id", value = "规格id")
    private String spec_id;

    @ApiModelProperty(name = "spec_name", value = "规格名称")
    private String spec_name;

    @ApiModelProperty(name = "width_mm", value = "规格对应的宽度毫米尺寸")
    private String width_mm;

    @ApiModelProperty(name = "width_px", value = "规格宽度像素")
    private String width_px;
}
