package com.youxu.business.service.impl;

import com.youxu.business.dao.ServiceTimeMapper;
import com.youxu.business.pojo.ServiceTime;
import com.youxu.business.service.ServiceTimeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceTimeServiceImpl implements ServiceTimeService {
    @Resource
    private ServiceTimeMapper serviceTimeMapper;

    @Override
    public List<ServiceTime> selectServiceTime(ServiceTime serviceTime) {
        List<ServiceTime> serviceTimes = new ArrayList<>();
        Byte dayType = serviceTime.getDayType();
        // 查看普通时间价格
        if ("1".equals(dayType.toString())) {
            // 查看一小时达价格
            List<ServiceTime> selectOneTimeService = serviceTimeMapper.selectServiceTimeAllDay(Integer.valueOf(serviceTime.getStoreId()), Integer.valueOf(dayType),Integer.valueOf(2));
            serviceTimes.addAll(selectOneTimeService);
            // 查看普通时间
            serviceTimes = serviceTimeMapper.selectServiceTime(Integer.valueOf(serviceTime.getStoreId()), Integer.valueOf(dayType));
        } else if ("2".equals(dayType.toString()) || "3".equals(dayType.toString())) {
            serviceTimes = serviceTimeMapper.selectServiceTimeAllDay(Integer.valueOf(serviceTime.getStoreId()), Integer.valueOf(dayType),Integer.valueOf(1));
        }

        return serviceTimes;
    }
}
