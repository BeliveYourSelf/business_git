package com.youxu.business.dao;

import com.youxu.business.pojo.OrderEvaluatePictureMapping;
import com.youxu.business.pojo.OrderEvaluatePictureMappingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderEvaluatePictureMappingMapper {
    long countByExample(OrderEvaluatePictureMappingExample example);

    int deleteByExample(OrderEvaluatePictureMappingExample example);

    int insert(OrderEvaluatePictureMapping record);

    int insertSelective(OrderEvaluatePictureMapping record);

    List<OrderEvaluatePictureMapping> selectByExample(OrderEvaluatePictureMappingExample example);

    int updateByExampleSelective(@Param("record") OrderEvaluatePictureMapping record, @Param("example") OrderEvaluatePictureMappingExample example);

    int updateByExample(@Param("record") OrderEvaluatePictureMapping record, @Param("example") OrderEvaluatePictureMappingExample example);
    // 关联订单id和图片订单集合
    Integer insertEvaluatePictureList(@Param("orderEvaluateId") int orderEvaluateId,@Param("pictureIdList") List<Integer> pictureIdList);
}