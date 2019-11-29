package com.youxu.business.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Collection {
    @ApiModelProperty(name = "id", value = "收藏id")
    private Integer id;

    @ApiModelProperty(name = "collectionUserId", value = "收藏人用户id")
    private Integer collectionUserId;

    @ApiModelProperty(name = "shareId", value = "分享人id")
    private Integer shareId;

    @ApiModelProperty(name = "collectionImage", value = "来源头像")
    private String collectionImage;

    @ApiModelProperty(name = "collectionName", value = "来源姓名")
    private String collectionName;

    @ApiModelProperty(name = "effectiveTime", value = "有效时间")
    private String effectiveTime;

    @ApiModelProperty(name = "fileSize", value = "文件大小")
    private Double fileSize;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "modifyTime", value = "修改时间")
    private Date modifyTime;

    @ApiModelProperty(name = "status", value = "显示状态")
    private Boolean status;

    @ApiModelProperty(name = "contentUrl", value = "收藏内容")
    private String contentUrl;

    @ApiModelProperty(name = "sizePage", value = "内容页数")
    private Integer sizePage;

    // 新增
    @ApiModelProperty(name = "pageNo", value = "第几页")
    private Integer pageNo;

    @ApiModelProperty(name = "pageSize", value = "页内条数")
    private Integer pageSize;

    @ApiModelProperty(name = "shareList", value = "分享表集合")
    private List<Share> shareList;
}