package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderEvaluate {
    private Integer id;

    private Integer orderEvaluateStar;

    private Integer orderId;

    private String orderComment;

    private Date orderEvaluateCreateTime;

    private Date orderEvaluateModifyTime;

    private Boolean orderEvaluateStatus;

    // 新增
    private List<Integer> orderEvaluateOptionCartIdList;

    private List<String> orderEvaluatePictureList;
}