package com.youxu.business.pojo.remotepojo;

import lombok.Data;

@Data
public class UserWallet {
    private int id;//钱包id
    private int userId;//用户id
    private int userIntegral;//用户积分
    private double walletBalance;//钱包可体现余额
    private double walletCashback;//消费金
}
