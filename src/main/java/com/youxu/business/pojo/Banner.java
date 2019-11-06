package com.youxu.business.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Banner {
    @ApiModelProperty(name = "id", value = "bannerId")
    private Integer id;

    @ApiModelProperty(name = "bannerName", value = "banner名称")
    private String bannerName;

    @ApiModelProperty(name = "bannerPictureUrl", value = "banner图片路径")
    private String bannerPictureUrl;

    @ApiModelProperty(name = "bannerJumpType", value = "banner跳转类型   弃用")
    private Byte bannerJumpType;

    @ApiModelProperty(name = "bannerWeight", value = "权重")
    private Integer bannerWeight;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "modifyTime", value = "修改时间")
    private Date modifyTime;

    @ApiModelProperty(name = "status", value = "显示状态   0显示  1删除")
    private Boolean status;

    @ApiModelProperty(name = "bannerContent", value = "弃用")
    private String bannerContent;

    @ApiModelProperty(name = "banner_content_id", value = "富文本内容素材库id，小程序用")
    private Integer banner_content_id;

    @ApiModelProperty(name = "bannerComtentIdForPc", value = "富文本内容素材库id，pc端用")
    private Integer bannerComtentIdForPc;


    // 新增
    @ApiModelProperty(name = "bannerMaterial", value = "banner内容")
    private BannerMaterial bannerMaterial;


}