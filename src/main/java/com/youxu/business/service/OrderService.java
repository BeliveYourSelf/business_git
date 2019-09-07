package com.youxu.business.service;

import com.youxu.business.pojo.Order;

public interface OrderService {
    Integer insertOrder(Order order);

    Integer reminderOrder(Order order);

    Integer cancelOrder(String id);

    Integer updateOrder(Order order);

    Order insertOrderAgain(String id);
}
