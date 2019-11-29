package com.youxu.business.service.impl;

import com.youxu.business.dao.OrderEvaluateOptionCartMapperMapper;
import com.youxu.business.pojo.OrderEvaluateOptionCartMapper;
import com.youxu.business.service.OrderEvaluateOptionCartMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderEvaluateOptionCartMapperServiceImpl implements OrderEvaluateOptionCartMapperService {
    @Resource
    private OrderEvaluateOptionCartMapperMapper orderEvaluateOptionCartMapperMapper;
}
