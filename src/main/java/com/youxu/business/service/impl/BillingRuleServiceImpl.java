package com.youxu.business.service.impl;

import com.youxu.business.dao.BillingRuleMapper;
import com.youxu.business.pojo.BillingRule;
import com.youxu.business.service.BillingRuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BillingRuleServiceImpl implements BillingRuleService {
    @Resource
    private BillingRuleMapper billingRuleMapper;
    @Override
    public BillingRule selectBillingRule(String storeId) {
        return billingRuleMapper.selectBillingRule(storeId);
    }
}
