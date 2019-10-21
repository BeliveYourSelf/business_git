package com.youxu.business.service;

import com.youxu.business.pojo.Order;
import com.youxu.business.pojo.Share;

import java.util.List;

public interface OrderService {
    Integer insertOrder(Order order) throws Exception;

    Integer reminderOrder(Order order);

    Integer cancelOrder(String id);

    Integer updateOrder(Order order);

    Order insertOrderAgain(String id);

    List<Order> selectOrderList(Order order);

    Integer updateOrderPayDateAndProcess(Integer orderId, Integer orderProcess);

    List<Order> selectDeliveryFileByStoreIdList(Order order);

    Order selectDeliveryFileByOrderId(String orderId);

    Integer updateOrderToPickUp(Order order);

    Integer updateDeliveryInfoToCompelete(Order order);

    Integer updateDeliveryOrderProblem(Order order);

    Integer insertOrderForMemberPrice(Share share);

    Integer lastInsertId();

    Integer updateOrderCompelete(Integer orderId);

    Integer deleteOrder(String id);

    Order selectOrderById(String id);

    Integer updateOrderPayDateAndProcessOverWrite(Integer orderId, Integer orderProcess);

}
