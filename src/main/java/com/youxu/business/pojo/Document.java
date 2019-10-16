package com.youxu.business.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class Document {
    @ApiModelProperty(name = "id", value = "文件id")
    private Integer id;

    @ApiModelProperty(name = "userId", value = "用户id")
    private Integer userId;

    @ApiModelProperty(name = "folderId", value = "文件夹id")
    private Integer folderId;

    @ApiModelProperty(name = "documentUrl", value = "文件url")
    private String documentUrl;

    @ApiModelProperty(name = "sizePage", value = "文件页数")
    private String sizePage;

    @ApiModelProperty(name = "fileSize", value = "文件页数")
    private String fileSize;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "modifyTime", value = "修改时间")
    private Date modifyTime;

    @ApiModelProperty(name = "status", value = "显示状态")
    private Boolean status;
    // 新增

    @ApiModelProperty(name = "documentUrlList", value = "文件url集合")
    private String documentUrlList;


}