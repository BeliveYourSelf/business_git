package com.youxu.business.service.impl;

import com.youxu.business.dao.OrderEvaluateMapper;
import com.youxu.business.dao.OrderEvaluateOptionCartMapperMapper;
import com.youxu.business.dao.OrderMapper;
import com.youxu.business.pojo.OrderEvaluate;
import com.youxu.business.pojo.OrderEvaluateOptionCartMapper;
import com.youxu.business.service.OrderEvaluateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderEvaluateServiceImpl implements OrderEvaluateService {
    @Resource
    private OrderEvaluateMapper orderEvaluateMapper;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderEvaluateOptionCartMapperMapper orderEvaluateOptionCartMapperMapper;
    @Override
    public Integer insertOrderEvaluate(OrderEvaluate orderEvaluate) {
        Integer insertOrderEvaluate = orderEvaluateMapper.insertOrderEvaluate(orderEvaluate);
        int orderEvaluateId = orderMapper.lastInsertId();
        List<Integer> orderEvaluateOptionCartIdList = orderEvaluate.getOrderEvaluateOptionCartIdList();
        Integer  insertOrderEvaluateOptionCartMapperMapper = orderEvaluateOptionCartMapperMapper.insertOrderEvaluateOptionCartMapperMapper(orderEvaluateId,orderEvaluateOptionCartIdList);
        return insertOrderEvaluate;
    }
}
