package com.youxu.business.pojo;

import java.util.Date;

public class User {
    private Integer id;

    private String userOpenId;

    private String userName;

    private String userPhone;

    private String userPassword;

    private String userPiectureUrl;

    private String othersResourceqrCode;

    private Date userCreateTime;

    private Date userModifyTime;

    private Boolean userStatus;

    private Boolean userIsMembers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserOpenId() {
        return userOpenId;
    }

    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId == null ? null : userOpenId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserPiectureUrl() {
        return userPiectureUrl;
    }

    public void setUserPiectureUrl(String userPiectureUrl) {
        this.userPiectureUrl = userPiectureUrl == null ? null : userPiectureUrl.trim();
    }

    public String getOthersResourceqrCode() {
        return othersResourceqrCode;
    }

    public void setOthersResourceqrCode(String othersResourceqrCode) {
        this.othersResourceqrCode = othersResourceqrCode == null ? null : othersResourceqrCode.trim();
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public Date getUserModifyTime() {
        return userModifyTime;
    }

    public void setUserModifyTime(Date userModifyTime) {
        this.userModifyTime = userModifyTime;
    }

    public Boolean getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Boolean userStatus) {
        this.userStatus = userStatus;
    }

    public Boolean getUserIsMembers() {
        return userIsMembers;
    }

    public void setUserIsMembers(Boolean userIsMembers) {
        this.userIsMembers = userIsMembers;
    }
}