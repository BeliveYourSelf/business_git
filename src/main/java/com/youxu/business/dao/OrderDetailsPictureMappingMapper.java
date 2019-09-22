package com.youxu.business.dao;

import com.youxu.business.pojo.OrderDetailsPictureMapping;
import com.youxu.business.pojo.OrderDetailsPictureMappingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDetailsPictureMappingMapper {
    long countByExample(OrderDetailsPictureMappingExample example);

    int deleteByExample(OrderDetailsPictureMappingExample example);

    int insert(OrderDetailsPictureMapping record);

    int insertSelective(OrderDetailsPictureMapping record);

    List<OrderDetailsPictureMapping> selectByExample(OrderDetailsPictureMappingExample example);

    int updateByExampleSelective(@Param("record") OrderDetailsPictureMapping record, @Param("example") OrderDetailsPictureMappingExample example);

    int updateByExample(@Param("record") OrderDetailsPictureMapping record, @Param("example") OrderDetailsPictureMappingExample example);
    // 新增订单和文档映射
    int insertOrderDetailsPictrueMapping(@Param("orderDetailsBookBindingId")int orderDetailsBookBindingId,@Param("pictureIdList") List<Integer> pictureIdList);
}