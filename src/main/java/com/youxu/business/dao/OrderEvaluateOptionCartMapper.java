package com.youxu.business.dao;

import com.youxu.business.pojo.OrderEvaluateOptionCart;
import com.youxu.business.pojo.OrderEvaluateOptionCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderEvaluateOptionCartMapper {
    long countByExample(OrderEvaluateOptionCartExample example);

    int deleteByExample(OrderEvaluateOptionCartExample example);

    int insert(OrderEvaluateOptionCart record);

    int insertSelective(OrderEvaluateOptionCart record);

    List<OrderEvaluateOptionCart> selectByExample(OrderEvaluateOptionCartExample example);

    int updateByExampleSelective(@Param("record") OrderEvaluateOptionCart record, @Param("example") OrderEvaluateOptionCartExample example);

    int updateByExample(@Param("record") OrderEvaluateOptionCart record, @Param("example") OrderEvaluateOptionCartExample example);
    // 查看订单评价选项卡
    List<OrderEvaluateOptionCart> selectOrderEvaluateOptionCart();
}