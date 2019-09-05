package com.youxu.business.pojo;

import java.util.Date;

public class IdPhotoDictionary {
    private Integer id;

    private String idPhotoDictionaryName;

    private Integer idPhotoDictionarySpecId;

    private Date idPhotoDictionaryCreateTime;

    private Date idPhotoDictionaryModifyTime;

    private Boolean idPhotoDictionaryStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdPhotoDictionaryName() {
        return idPhotoDictionaryName;
    }

    public void setIdPhotoDictionaryName(String idPhotoDictionaryName) {
        this.idPhotoDictionaryName = idPhotoDictionaryName == null ? null : idPhotoDictionaryName.trim();
    }

    public Integer getIdPhotoDictionarySpecId() {
        return idPhotoDictionarySpecId;
    }

    public void setIdPhotoDictionarySpecId(Integer idPhotoDictionarySpecId) {
        this.idPhotoDictionarySpecId = idPhotoDictionarySpecId;
    }

    public Date getIdPhotoDictionaryCreateTime() {
        return idPhotoDictionaryCreateTime;
    }

    public void setIdPhotoDictionaryCreateTime(Date idPhotoDictionaryCreateTime) {
        this.idPhotoDictionaryCreateTime = idPhotoDictionaryCreateTime;
    }

    public Date getIdPhotoDictionaryModifyTime() {
        return idPhotoDictionaryModifyTime;
    }

    public void setIdPhotoDictionaryModifyTime(Date idPhotoDictionaryModifyTime) {
        this.idPhotoDictionaryModifyTime = idPhotoDictionaryModifyTime;
    }

    public Boolean getIdPhotoDictionaryStatus() {
        return idPhotoDictionaryStatus;
    }

    public void setIdPhotoDictionaryStatus(Boolean idPhotoDictionaryStatus) {
        this.idPhotoDictionaryStatus = idPhotoDictionaryStatus;
    }
}