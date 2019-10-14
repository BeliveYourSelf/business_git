package com.youxu.business.service.impl;

import com.youxu.business.dao.DeliveryClerkInfoMapper;
import com.youxu.business.dao.OrderMapper;
import com.youxu.business.dao.SotreDeliveryMappingMapper;
import com.youxu.business.pojo.DeliveryClerkInfo;
import com.youxu.business.pojo.Order;
import com.youxu.business.pojo.SotreDeliveryMapping;
import com.youxu.business.service.DeliveryClerkInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

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
        // 查看该用户是否已申请为配送员
        Integer userId = deliveryClerkInfo.getUserId();
        DeliveryClerkInfo deliveryClerkInfoNew = deliveryClerkInfoMapper.selectDeliveryClerkInfoByUserId(userId.toString());
        if(!org.springframework.util.StringUtils.isEmpty(deliveryClerkInfoNew)){
            return -1;
        }
        deliveryClerkInfo.setAuditStatus(0);//待审核
        deliveryClerkInfo.setCumulativeIncome(0.0);// 初始化收入
        deliveryClerkInfo.setCumulativeDeliveryThisMonth(0);// 初始化本月单数
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

    @Override
    public DeliveryClerkInfo selectDeliveryClerkInfoByPhone(String phone) {
        return deliveryClerkInfoMapper.selectDeliveryClerkInfoByPhone(phone);
    }

    @Override
    public Integer updateDeliveryClerkScore(DeliveryClerkInfo deliveryClerkInfo) {
        return deliveryClerkInfoMapper.updateDeliveryClerkScore(deliveryClerkInfo);
    }


}
