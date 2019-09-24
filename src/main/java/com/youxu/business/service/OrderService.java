package com.youxu.business.service;

import com.youxu.business.pojo.Order;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface OrderService {
    Integer insertOrder(Order order) throws Exception;

    Integer reminderOrder(Order order);

    Integer cancelOrder(String id);

    Integer updateOrder(Order order);

    Order insertOrderAgain(String id);

    List<Order> selectOrderList(Order order);

    Integer updateOrderPayDateAndProcess(Integer valueCode, Integer orderId, String orderPayDate);

    List<Order> selectDeliveryFileByStoreIdList(String[] storeIds);

    Order selectDeliveryFileByOrderId(String orderId);
}
