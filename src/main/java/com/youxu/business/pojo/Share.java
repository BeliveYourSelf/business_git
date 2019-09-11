package com.youxu.business.pojo;

import java.util.Date;

public class Share {
    private Integer id;

    private Integer shareUserId;

    private Date periodOfValidity;

    private Boolean extactionCodeStatus;

    private String extactionCode;

    private Boolean downloadDuplicatedPrintStatus;

    private Double downloadDuplicatedPrintMoney;

    private String qrCode;

    private String usreHeadImage;

    private Date createTime;

    private Date modifyTime;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShareUserId() {
        return shareUserId;
    }

    public void setShareUserId(Integer shareUserId) {
        this.shareUserId = shareUserId;
    }

    public Date getPeriodOfValidity() {
        return periodOfValidity;
    }

    public void setPeriodOfValidity(Date periodOfValidity) {
        this.periodOfValidity = periodOfValidity;
    }

    public Boolean getExtactionCodeStatus() {
        return extactionCodeStatus;
    }

    public void setExtactionCodeStatus(Boolean extactionCodeStatus) {
        this.extactionCodeStatus = extactionCodeStatus;
    }

    public String getExtactionCode() {
        return extactionCode;
    }

    public void setExtactionCode(String extactionCode) {
        this.extactionCode = extactionCode == null ? null : extactionCode.trim();
    }

    public Boolean getDownloadDuplicatedPrintStatus() {
        return downloadDuplicatedPrintStatus;
    }

    public void setDownloadDuplicatedPrintStatus(Boolean downloadDuplicatedPrintStatus) {
        this.downloadDuplicatedPrintStatus = downloadDuplicatedPrintStatus;
    }

    public Double getDownloadDuplicatedPrintMoney() {
        return downloadDuplicatedPrintMoney;
    }

    public void setDownloadDuplicatedPrintMoney(Double downloadDuplicatedPrintMoney) {
        this.downloadDuplicatedPrintMoney = downloadDuplicatedPrintMoney;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode == null ? null : qrCode.trim();
    }

    public String getUsreHeadImage() {
        return usreHeadImage;
    }

    public void setUsreHeadImage(String usreHeadImage) {
        this.usreHeadImage = usreHeadImage == null ? null : usreHeadImage.trim();
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