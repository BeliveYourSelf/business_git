package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
@Data
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

}