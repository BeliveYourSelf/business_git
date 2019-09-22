package com.youxu.business.dao;

import com.youxu.business.pojo.OrderDetailsBookBinding;
import com.youxu.business.pojo.OrderDetailsBookBindingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDetailsBookBindingMapper {
    long countByExample(OrderDetailsBookBindingExample example);

    int deleteByExample(OrderDetailsBookBindingExample example);

    int insert(OrderDetailsBookBinding record);

    int insertSelective(OrderDetailsBookBinding record);

    List<OrderDetailsBookBinding> selectByExample(OrderDetailsBookBindingExample example);

    int updateByExampleSelective(@Param("record") OrderDetailsBookBinding record, @Param("example") OrderDetailsBookBindingExample example);

    int updateByExample(@Param("record") OrderDetailsBookBinding record, @Param("example") OrderDetailsBookBindingExample example);
    // 新增装订文档
    int insertOrderDetailsBookBinding(OrderDetailsBookBinding orderDetailsBookBinding);
}