package com.youxu.business.dao;

import com.youxu.business.pojo.DeliveryClerkInfo;
import com.youxu.business.pojo.DeliveryClerkInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeliveryClerkInfoMapper {
    long countByExample(DeliveryClerkInfoExample example);

    int deleteByExample(DeliveryClerkInfoExample example);

    int insert(DeliveryClerkInfo record);

    int insertSelective(DeliveryClerkInfo record);

    List<DeliveryClerkInfo> selectByExample(DeliveryClerkInfoExample example);

    int updateByExampleSelective(@Param("record") DeliveryClerkInfo record, @Param("example") DeliveryClerkInfoExample example);

    int updateByExample(@Param("record") DeliveryClerkInfo record, @Param("example") DeliveryClerkInfoExample example);
    // 新增配送员信息
    Integer insertDeliveryClerkInfo(DeliveryClerkInfo deliveryClerkInfo);
}