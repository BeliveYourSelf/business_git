package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class BillingRule {
    private Integer id;

    private Integer storeId;

    private Date billingRuleCreateTime;

    private Date billingRuleModifyTime;

    private Boolean billingRuleStatus;


}