package com.youxu.business.pojo;

public class RecentFile {
    private Integer recentFileId;

    private Integer userId;

    private String recentFileName;

    private String recentFileSize;

    private String recentFilePath;

    private String createTime;

    private Boolean status;

    public Integer getRecentFileId() {
        return recentFileId;
    }

    public void setRecentFileId(Integer recentFileId) {
        this.recentFileId = recentFileId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRecentFileName() {
        return recentFileName;
    }

    public void setRecentFileName(String recentFileName) {
        this.recentFileName = recentFileName == null ? null : recentFileName.trim();
    }

    public String getRecentFileSize() {
        return recentFileSize;
    }

    public void setRecentFileSize(String recentFileSize) {
        this.recentFileSize = recentFileSize == null ? null : recentFileSize.trim();
    }

    public String getRecentFilePath() {
        return recentFilePath;
    }

    public void setRecentFilePath(String recentFilePath) {
        this.recentFilePath = recentFilePath == null ? null : recentFilePath.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}