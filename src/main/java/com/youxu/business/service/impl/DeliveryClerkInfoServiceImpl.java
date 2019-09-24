package com.youxu.business.service.impl;

import com.youxu.business.dao.DeliveryClerkInfoMapper;
import com.youxu.business.dao.OrderMapper;
import com.youxu.business.dao.SotreDeliveryMappingMapper;
import com.youxu.business.pojo.DeliveryClerkInfo;
import com.youxu.business.pojo.SotreDeliveryMapping;
import com.youxu.business.service.DeliveryClerkInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeliveryClerkInfoServiceImpl implements DeliveryClerkInfoService {
    @Resource
    private DeliveryClerkInfoMapper deliveryClerkInfoMapper;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private SotreDeliveryMappingMapper sotreDeliveryMappingMapper;

    @Override
    public Integer insertDeliveryClerkInfo(DeliveryClerkInfo deliveryClerkInfo) {
        deliveryClerkInfo.setAuditStatus(0);//待审核
        deliveryClerkInfoMapper.insertDeliveryClerkInfo(deliveryClerkInfo);
        int dliveryId = orderMapper.lastInsertId();
        deliveryClerkInfo.setId(dliveryId);
        return sotreDeliveryMappingMapper.insertSotreDeliveryMappingMapper(deliveryClerkInfo);
    }

    @Override
    public Integer updateDeliveryClerkInfo(DeliveryClerkInfo deliveryClerkInfo) {
        return deliveryClerkInfoMapper.updateDeliveryClerkInfo(deliveryClerkInfo);
    }

    @Override
    public DeliveryClerkInfo selectDeliveryClerkInfoByUserId(String userId) {
        return deliveryClerkInfoMapper.selectDeliveryClerkInfoByUserId(userId);
    }
}
