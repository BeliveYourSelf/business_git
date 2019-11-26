package com.youxu.business.pojo;

import java.util.Date;

public class IdPhotoSerachHistory {
    private Integer id;

    private Integer userId;

    private String serachName;

    private Date modifyTime;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSerachName() {
        return serachName;
    }

    public void setSerachName(String serachName) {
        this.serachName = serachName == null ? null : serachName.trim();
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