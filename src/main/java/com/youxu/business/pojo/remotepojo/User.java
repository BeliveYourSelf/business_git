package com.youxu.business.pojo.remotepojo;

import lombok.Data;

@Data
public class User {
    private int id; //user主键

    private String userName;//用户名

    private String userPhone;//手机号

    private String userOpenId;//用户openid

    private String userPassword;//用户密码

    private String userPiectureUrl;//头像图片地址

    private String userCreateTime;//用户注册时间

    private String userModifyTime;//用户信息最后更改时间

    private int isMembers;//会员标识，0：普通用户，1：会员

    private String othersResourceQRCode;//用推荐码注册时用的码
    //====================以上为数据库对应字段=====以下为接口中使用的字段=====================
    private String code;//注册时使用




}
