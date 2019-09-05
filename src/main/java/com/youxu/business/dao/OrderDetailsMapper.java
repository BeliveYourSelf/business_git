package com.youxu.business.dao;

import com.youxu.business.pojo.OrderDetails;
import com.youxu.business.pojo.OrderDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDetailsMapper {
    long countByExample(OrderDetailsExample example);

    int deleteByExample(OrderDetailsExample example);

    int insert(OrderDetails record);

    int insertSelective(OrderDetails record);

    List<OrderDetails> selectByExample(OrderDetailsExample example);

    int updateByExampleSelective(@Param("record") OrderDetails record, @Param("example") OrderDetailsExample example);

    int updateByExample(@Param("record") OrderDetails record, @Param("example") OrderDetailsExample example);
}