package com.youxu.business.service.impl;

import com.youxu.business.dao.OrderEvaluateOptionCartMapper;
import com.youxu.business.pojo.OrderEvaluateOptionCart;
import com.youxu.business.service.OrderEvaluateOptionCartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderEvaluateOptionCartServiceImpl implements OrderEvaluateOptionCartService {
    @Resource
    private OrderEvaluateOptionCartMapper orderEvaluateOptionCartMapper;
    @Override
    public List<OrderEvaluateOptionCart> selectOrderEvaluateOptionCart() {
        return orderEvaluateOptionCartMapper.selectOrderEvaluateOptionCart();
    }
}
