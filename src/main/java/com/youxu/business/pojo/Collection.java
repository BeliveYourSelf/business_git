package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Collection {
    private Integer id;

    private Integer collectionUserId;

    private Integer shareId;

    private Date createTime;

    private Date modifyTime;

    private Boolean status;

    // 新增
    private Integer pageNo;

    private Integer pageSize;

    private List<Share> shareList;
}