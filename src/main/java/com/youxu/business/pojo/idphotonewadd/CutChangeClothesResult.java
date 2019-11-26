package com.youxu.business.pojo.idphotonewadd;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CutChangeClothesResult {
    @ApiModelProperty(name = "code", value = "状态码")
    private String code;

    @ApiModelProperty(name = "final_pic_name", value = "无水印图片名称列表（同‘带水印图片url列表’顺序），调获取无水印图片接口，进行获取。")
    private String final_pic_name;

    @ApiModelProperty(name = "origin_pic_name", value = "原始图片名")
    private String origin_pic_name;

    @ApiModelProperty(name = "print_pic_name", value = "无水印排版图片名称列表（同‘带水印图片url列表’顺序），调获取无水印图片接口，进行获取。")
    private String print_pic_name;

    @ApiModelProperty(name = "print_wm_pic_url", value = "带水印排版图片url列表（同‘带水印图片url列表’顺序）")
    private String print_wm_pic_url;

    @ApiModelProperty(name = "wm_pic_url", value = "带水印图片url列表")
    private String wm_pic_url;

    @ApiModelProperty(name = "error", value = "错误信息提示")
    private String error;
}
