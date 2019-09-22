package com.youxu.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.youxu.business.dao.OrderDetailsBookBindingMapper;
import com.youxu.business.dao.OrderDetailsMapper;
import com.youxu.business.dao.OrderMapper;
import com.youxu.business.pojo.Order;
import com.youxu.business.pojo.OrderDetails;
import com.youxu.business.pojo.OrderDetailsBookBinding;
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
    @Resource
    private OrderDetailsBookBindingMapper orderDetailsBookBindingMapper;

    @Override
    public Integer insertOrder(Order order) {
        Integer insertOrder = orderMapper.insertOrder(order);
        if (!StringUtils.isEmpty(order)) {
            int orderId = orderMapper.lastInsertId();
            List<OrderDetails> orderDetailsList = order.getOrderDetailsList();
            for (OrderDetails orderDetails : orderDetailsList) {
                orderDetails.setOrderId(orderId);
            }
            if (orderDetailsList.size() > 0) {
                Integer insertOrderDetails = orderDetailsMapper.insertOrderDetails(orderDetailsList);
                int orderDetailsId = orderMapper.lastInsertId();
                for (int i = 1; orderDetailsList.size() >= i; i++) {
                    OrderDetailsBookBinding orderDetailsBookBinding = orderDetailsList.get(i-1).getOrderDetailsBookBinding();
                    if (!StringUtils.isEmpty(orderDetailsBookBinding)) {
                        orderDetailsBookBinding.setOrderDetailsId(orderDetailsId+i-1);//绑定订单明细和装订一对一关系
                        orderDetailsBookBindingMapper.insertOrderDetailsBookBinding(orderDetailsBookBinding);

                    }
                }
            }

        }
        return insertOrder;
    }

    @Override
    public Integer reminderOrder(Order order) {
        Integer id = order.getId();
        Integer orderType = order.getOrderType();
        Integer reminderOrder = orderMapper.reminderOrder(id, orderType);
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

    @Override
    public Order insertOrderAgain(String id) {
        Order order = orderMapper.selectOrderById(id);
        return order;
    }

    @Override
    public List<Order> selectOrderList(Order order) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(order.getPageNo(), order.getPageSize());
        return orderMapper.selectOrderList(order);
    }

    @Override
    public Integer updateOrderPayDateAndProcess(Integer valueCode, Integer orderId, String orderPayDate) {
        return orderMapper.updateOrderPayDateAndProcess(valueCode, orderId, orderPayDate);
    }
}
