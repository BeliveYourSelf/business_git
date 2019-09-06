package com.youxu.business.pojo;

import lombok.Data;

@Data
public class BillingRuleWithBLOBs extends BillingRule {
    private String billingRulePrint;

    private String billingRulePhoto;

    private String billingRuleDelivery;

    private String billingRulePayMethod;


}