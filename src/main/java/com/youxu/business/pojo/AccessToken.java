package com.youxu.business.pojo;

import java.util.Date;

public class AccessToken {
    private Integer id;

    private String tbAccessToken;

    private Date createTime;

    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTbAccessToken() {
        return tbAccessToken;
    }

    public void setTbAccessToken(String tbAccessToken) {
        this.tbAccessToken = tbAccessToken == null ? null : tbAccessToken.trim();
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
}