package com.youxu.business.dao;

import com.youxu.business.pojo.DeliveryClerkInfo;
import com.youxu.business.pojo.SotreDeliveryMapping;
import com.youxu.business.pojo.SotreDeliveryMappingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SotreDeliveryMappingMapper {
    long countByExample(SotreDeliveryMappingExample example);

    int deleteByExample(SotreDeliveryMappingExample example);

    int insert(SotreDeliveryMapping record);

    int insertSelective(SotreDeliveryMapping record);

    List<SotreDeliveryMapping> selectByExample(SotreDeliveryMappingExample example);

    int updateByExampleSelective(@Param("record") SotreDeliveryMapping record, @Param("example") SotreDeliveryMappingExample example);

    int updateByExample(@Param("record") SotreDeliveryMapping record, @Param("example") SotreDeliveryMappingExample example);
    // 关联商铺和配送员
    Integer insertSotreDeliveryMappingMapper(DeliveryClerkInfo deliveryClerkInfo);
}