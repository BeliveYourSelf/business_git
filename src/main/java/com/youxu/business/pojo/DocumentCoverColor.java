package com.youxu.business.pojo;

import java.util.Date;

public class DocumentCoverColor {
    private Integer id;

    private Integer storeId;

    private String documentCoverName;

    private String documentCoverCode;

    private Date createTime;

    private Date modifyTime;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getDocumentCoverName() {
        return documentCoverName;
    }

    public void setDocumentCoverName(String documentCoverName) {
        this.documentCoverName = documentCoverName == null ? null : documentCoverName.trim();
    }

    public String getDocumentCoverCode() {
        return documentCoverCode;
    }

    public void setDocumentCoverCode(String documentCoverCode) {
        this.documentCoverCode = documentCoverCode == null ? null : documentCoverCode.trim();
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