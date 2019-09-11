package com.youxu.business.pojo;

import java.util.Date;

public class Collection {
    private Integer id;

    private Integer collectionUserId;

    private Integer shareId;

    private Date createTime;

    private Date modifyTime;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCollectionUserId() {
        return collectionUserId;
    }

    public void setCollectionUserId(Integer collectionUserId) {
        this.collectionUserId = collectionUserId;
    }

    public Integer getShareId() {
        return shareId;
    }

    public void setShareId(Integer shareId) {
        this.shareId = shareId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}