package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class OrderEvaluateOptionCart {
    private Integer id;

    private String orderEvaluateOptionCartName;

    private Date orderEvaluateOptionCartCreateTime;

    private Date orderEvaluateOptionCartModifyTime;

    private Integer orderEvaluateOptionCartStatus;

}