package com.youxu.business.pojo;

import java.util.Date;

public class UserWallet {
    private Integer id;

    private Integer userId;

    private Integer userIntegral;

    private Double walletBalance;

    private Double walletCashback;

    private Date walletCreateTime;

    private Date walletModifyTime;

    private Boolean walletStatus;

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

    public Integer getUserIntegral() {
        return userIntegral;
    }

    public void setUserIntegral(Integer userIntegral) {
        this.userIntegral = userIntegral;
    }

    public Double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(Double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public Double getWalletCashback() {
        return walletCashback;
    }

    public void setWalletCashback(Double walletCashback) {
        this.walletCashback = walletCashback;
    }

    public Date getWalletCreateTime() {
        return walletCreateTime;
    }

    public void setWalletCreateTime(Date walletCreateTime) {
        this.walletCreateTime = walletCreateTime;
    }

    public Date getWalletModifyTime() {
        return walletModifyTime;
    }

    public void setWalletModifyTime(Date walletModifyTime) {
        this.walletModifyTime = walletModifyTime;
    }

    public Boolean getWalletStatus() {
        return walletStatus;
    }

    public void setWalletStatus(Boolean walletStatus) {
        this.walletStatus = walletStatus;
    }
}