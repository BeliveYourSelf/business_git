package com.youxu.business.service.impl;

import com.youxu.business.dao.OrderDetailsBookBindingMapper;
import com.youxu.business.service.OrderDetailsBookBindingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderDetailsBookBindingServiceImpl implements OrderDetailsBookBindingService{
    @Resource
    private OrderDetailsBookBindingMapper orderDetailsBookBindingMapper;
}
