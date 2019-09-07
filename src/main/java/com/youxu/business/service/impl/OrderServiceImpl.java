package com.youxu.business.service.impl;

import com.youxu.business.dao.OrderDetailsMapper;
import com.youxu.business.dao.OrderMapper;
import com.youxu.business.pojo.Order;
import com.youxu.business.pojo.OrderDetails;
import com.youxu.business.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderDetailsMapper orderDetailsMapper;

    @Override
    public Integer insertOrder(Order order) {
        Integer insertOrder = orderMapper.insertOrder(order);
        int orderId = orderMapper.lastInsertId();
        if(!StringUtils.isEmpty(order)){
            List<OrderDetails> orderDetailsList = order.getOrderDetailsList();
            for(OrderDetails orderDetails:orderDetailsList){
                orderDetails.setOrderId(orderId);
            }
            Integer insertOrderDetails = orderDetailsMapper.insertOrderDetails(orderDetailsList);
        }
        return insertOrder;
    }

    @Override
    public Integer reminderOrder(Order order) {
        Integer id = order.getId();
        Integer orderType = order.getOrderType();
        Integer reminderOrder = orderMapper.reminderOrder(id,orderType);
        return reminderOrder;
    }

    @Override
    public Integer cancelOrder(String id) {
        return orderMapper.cancelOrder(id);
    }

    @Override
    public Integer updateOrder(Order order) {
        // 更新订单表
        Integer updateOrder = orderMapper.updateOrder(order);
        Integer id = order.getId();
        // 删除订单明细表
        Integer deleteOrderDetailsList = orderDetailsMapper.deleteOrderDetailsList(id);
        // 新增订单明细表
        List<OrderDetails> orderDetailsList = order.getOrderDetailsList();
        Integer insertOrderDetails = orderDetailsMapper.insertOrderDetails(orderDetailsList);
        return updateOrder;
    }
}
