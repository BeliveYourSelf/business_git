package com.youxu.business.service;

import com.youxu.business.pojo.DeliverySchedule;
import com.youxu.business.pojo.ServicePrice;
import com.youxu.business.pojo.ServiceTime;

import java.util.List;

public interface ServiceTimeService {
    List<ServiceTime> selectServiceTime(ServiceTime serviceTime);

    // 查询指定的所有配送价格
    List<ServicePrice> selServicePrice(Integer storeId, Integer serviceType);
    // 所有时间点
    List<DeliverySchedule> selAutomaticGeneration(Integer storeId);
}
