package com.youxu.business.service;

import com.youxu.business.pojo.DeliveryClerkInfo;
import com.youxu.business.pojo.Order;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface DeliveryClerkInfoService {
    Integer insertDeliveryClerkInfo(DeliveryClerkInfo deliveryClerkInfo);

    Integer updateDeliveryClerkInfo(DeliveryClerkInfo deliveryClerkInfo);

    DeliveryClerkInfo selectDeliveryClerkInfoByUserId(String userId);

    DeliveryClerkInfo selectDeliveryClerkInfoByPhone(String phone);

    Integer updateDeliveryClerkScore(DeliveryClerkInfo deliveryClerkInfo);
}
