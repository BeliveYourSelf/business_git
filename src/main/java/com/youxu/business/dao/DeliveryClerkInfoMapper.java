package com.youxu.business.dao;

import com.youxu.business.pojo.DeliveryClerkInfo;
import com.youxu.business.pojo.DeliveryClerkInfoExample;
import java.util.List;

import com.youxu.business.pojo.Order;
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
    // 更新配送员信息
    Integer updateDeliveryClerkInfo(@Param("record")DeliveryClerkInfo record);
    // 查看快递员信息
    DeliveryClerkInfo selectDeliveryClerkInfoByUserId(String userId);
    // 查看配送员通过手机号
    DeliveryClerkInfo selectDeliveryClerkInfoByPhone(String phone);
}