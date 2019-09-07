package com.youxu.business.dao;

import com.youxu.business.pojo.OrderEvaluate;
import com.youxu.business.pojo.OrderEvaluateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderEvaluateMapper {
    long countByExample(OrderEvaluateExample example);

    int deleteByExample(OrderEvaluateExample example);

    int insert(OrderEvaluate record);

    int insertSelective(OrderEvaluate record);

    List<OrderEvaluate> selectByExample(OrderEvaluateExample example);

    int updateByExampleSelective(@Param("record") OrderEvaluate record, @Param("example") OrderEvaluateExample example);

    int updateByExample(@Param("record") OrderEvaluate record, @Param("example") OrderEvaluateExample example);
    // 新增订单评价
    Integer insertOrderEvaluate(OrderEvaluate orderEvaluate);
}