package com.youxu.business.dao;

import com.youxu.business.pojo.Order;
import com.youxu.business.pojo.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);
    // 新增订单
    Integer insertOrder(Order order);
    // 返回最新插入orderId
    int lastInsertId();
    // 催单/确认收件
    Integer reminderOrder(@Param("id") Integer id,@Param("orderType") Integer orderType);
    // 取消订单
    Integer cancelOrder(String id);
    // 更新订单
    Integer updateOrder(@Param("record") Order record);
    // 查看订单
    Order selectOrderById(String id);
    // 查看订单集合
    List<Order> selectOrderList(@Param("order") Order order);
    // 更新支付状态和时间
    Integer updateOrderPayDateAndProcess(Integer valueCode, Integer orderId, String orderPayDate);
    // 取件列表集合
    List<Order> selectDeliveryFileByStoreIdList(@Param("storeIds") List<String> storeIds);
    // 待取件详情
    Order selectDeliveryFileByOrderId(String orderId);
}