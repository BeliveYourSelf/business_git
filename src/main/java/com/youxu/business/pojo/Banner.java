package com.youxu.business.pojo;

import java.util.Date;

public class Banner {
    private Integer id;

    private String bannerName;

    private String bannerPictureUrl;

    private Byte bannerJumpType;

    private Integer bannerWeight;

    private Date createTime;

    private Date modifyTime;

    private Boolean status;

    private String bannerContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName == null ? null : bannerName.trim();
    }

    public String getBannerPictureUrl() {
        return bannerPictureUrl;
    }

    public void setBannerPictureUrl(String bannerPictureUrl) {
        this.bannerPictureUrl = bannerPictureUrl == null ? null : bannerPictureUrl.trim();
    }

    public Byte getBannerJumpType() {
        return bannerJumpType;
    }

    public void setBannerJumpType(Byte bannerJumpType) {
        this.bannerJumpType = bannerJumpType;
    }

    public Integer getBannerWeight() {
        return bannerWeight;
    }

    public void setBannerWeight(Integer bannerWeight) {
        this.bannerWeight = bannerWeight;
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

    public String getBannerContent() {
        return bannerContent;
    }

    public void setBannerContent(String bannerContent) {
        this.bannerContent = bannerContent == null ? null : bannerContent.trim();
    }
}