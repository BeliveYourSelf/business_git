package com.youxu.business.dao;

import com.youxu.business.pojo.BillingRule;
import com.youxu.business.pojo.BillingRuleExample;
import com.youxu.business.pojo.BillingRuleWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillingRuleMapper {
    long countByExample(BillingRuleExample example);

    int deleteByExample(BillingRuleExample example);

    int insert(BillingRuleWithBLOBs record);

    int insertSelective(BillingRuleWithBLOBs record);

    List<BillingRuleWithBLOBs> selectByExampleWithBLOBs(BillingRuleExample example);

    List<BillingRule> selectByExample(BillingRuleExample example);

    int updateByExampleSelective(@Param("record") BillingRuleWithBLOBs record, @Param("example") BillingRuleExample example);

    int updateByExampleWithBLOBs(@Param("record") BillingRuleWithBLOBs record, @Param("example") BillingRuleExample example);

    int updateByExample(@Param("record") BillingRule record, @Param("example") BillingRuleExample example);
    // 查看规则计费
    BillingRule selectBillingRule(@Param("storeId") String storeId);
}