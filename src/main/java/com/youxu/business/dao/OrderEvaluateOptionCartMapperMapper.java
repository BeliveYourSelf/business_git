package com.youxu.business.dao;

import com.youxu.business.pojo.OrderEvaluateOptionCartMapper;
import com.youxu.business.pojo.OrderEvaluateOptionCartMapperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderEvaluateOptionCartMapperMapper {
    long countByExample(OrderEvaluateOptionCartMapperExample example);

    int deleteByExample(OrderEvaluateOptionCartMapperExample example);

    int insert(OrderEvaluateOptionCartMapper record);

    int insertSelective(OrderEvaluateOptionCartMapper record);

    List<OrderEvaluateOptionCartMapper> selectByExample(OrderEvaluateOptionCartMapperExample example);

    int updateByExampleSelective(@Param("record") OrderEvaluateOptionCartMapper record, @Param("example") OrderEvaluateOptionCartMapperExample example);

    int updateByExample(@Param("record") OrderEvaluateOptionCartMapper record, @Param("example") OrderEvaluateOptionCartMapperExample example);
    // 新增订单评价选项卡关联
    Integer insertOrderEvaluateOptionCartMapperMapper(@Param("orderEvaluateId")int orderEvaluateId,@Param("orderEvaluateOptionCartIdList") List<Integer> orderEvaluateOptionCartIdList);
}