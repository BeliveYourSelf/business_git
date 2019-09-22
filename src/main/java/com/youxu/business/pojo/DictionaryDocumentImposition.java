package com.youxu.business.pojo;

import java.util.Date;

public class DictionaryDocumentImposition {
    private Integer id;

    private String dictionaryDocumentImpositionName;

    private Date createTime;

    private Date modifyTime;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictionaryDocumentImpositionName() {
        return dictionaryDocumentImpositionName;
    }

    public void setDictionaryDocumentImpositionName(String dictionaryDocumentImpositionName) {
        this.dictionaryDocumentImpositionName = dictionaryDocumentImpositionName == null ? null : dictionaryDocumentImpositionName.trim();
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