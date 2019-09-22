package com.youxu.business.pojo;

import java.util.Date;

public class DictionaryDocumentSize {
    private Integer id;

    private String documentSizeName;

    private Date createTime;

    private Date modifyTime;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentSizeName() {
        return documentSizeName;
    }

    public void setDocumentSizeName(String documentSizeName) {
        this.documentSizeName = documentSizeName == null ? null : documentSizeName.trim();
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