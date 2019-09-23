package com.youxu.business.service.impl;

import com.youxu.business.dao.DeliveryClerkInfoMapper;
import com.youxu.business.pojo.DeliveryClerkInfo;
import com.youxu.business.service.DeliveryClerkInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeliveryClerkInfoServiceImpl implements DeliveryClerkInfoService {
    @Resource
    private DeliveryClerkInfoMapper deliveryClerkInfoMapper;

    @Override
    public Integer insertDeliveryClerkInfo(DeliveryClerkInfo deliveryClerkInfo) {
        return deliveryClerkInfoMapper.insertDeliveryClerkInfo(deliveryClerkInfo);
    }
}
