package com.youxu.business.service;

import com.youxu.business.pojo.ServiceTime;

import java.util.List;

public interface ServiceTimeService {
    List<ServiceTime> selectServiceTime(ServiceTime serviceTime);
}
