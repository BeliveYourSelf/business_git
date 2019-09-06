package com.youxu.business.pojo;

import java.util.Date;

public class BillingRule {
    private Integer id;

    private Date billingRuleCreateTime;

    private Date billingRuleModifyTime;

    private Boolean billingRuleStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBillingRuleCreateTime() {
        return billingRuleCreateTime;
    }

    public void setBillingRuleCreateTime(Date billingRuleCreateTime) {
        this.billingRuleCreateTime = billingRuleCreateTime;
    }

    public Date getBillingRuleModifyTime() {
        return billingRuleModifyTime;
    }

    public void setBillingRuleModifyTime(Date billingRuleModifyTime) {
        this.billingRuleModifyTime = billingRuleModifyTime;
    }

    public Boolean getBillingRuleStatus() {
        return billingRuleStatus;
    }

    public void setBillingRuleStatus(Boolean billingRuleStatus) {
        this.billingRuleStatus = billingRuleStatus;
    }
}