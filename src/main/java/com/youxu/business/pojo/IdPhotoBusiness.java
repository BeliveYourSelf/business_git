package com.youxu.business.pojo;

import com.youxu.business.pojo.idphotonewadd.BackgroundColor;
import com.youxu.business.utils.pojotools.ResultIdPhotoMarkAndTest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.File;
import java.util.List;
import java.util.Map;

@Data
public class IdPhotoBusiness {
    private String specId;

    private String base64;

    private File file;

    private Integer userId;

    private Integer code;//

    private String message;//

    private String pictureUrl;

    @ApiModelProperty(name = "is_fair", value = "是否美颜，默认为美颜")
    private Integer is_fair;

    @ApiModelProperty(name = "fair_level", value = "美颜等级，分为1,2,3,4,5等级")
    private Integer fair_level;

    @ApiModelProperty(name = "backgroundColorList", value = "背景颜色对象")
    private List<BackgroundColor> backgroundColorList;

    @ApiModelProperty(name = "backgroundColorList", value = "制作并检测证件照返回对象")
    private ResultIdPhotoMarkAndTest resultIdPhotoMarkAndTest;

}
