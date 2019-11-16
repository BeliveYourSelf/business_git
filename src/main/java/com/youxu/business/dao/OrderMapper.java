package com.youxu.business.dao;

import com.youxu.business.pojo.Order;
import com.youxu.business.pojo.OrderExample;
import java.util.List;

import com.youxu.business.pojo.OrderProcess;
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
    Integer reminderOrder(@Param("id") Integer id,@Param("orderProcess") Integer orderProcess);
    // 取消订单
    Integer cancelOrder(String id);
    // 更新订单
    Integer updateOrder(@Param("record") Order record);
    // 查看订单
    Order selectOrderById(String id);
    // 查看订单集合
    List<Order> selectOrderList(@Param("order") Order order);
    // 更新支付状态和时间
    Integer updateOrderPayDateAndProcess(@Param("orderId")Integer orderId, @Param("orderProcess") Integer orderProcess);
    // 取件列表集合
    List<Order> selectDeliveryFileByStoreIdList(@Param("order") Order order);
    // 待取件详情
    Order selectDeliveryFileByOrderId(String orderId);
    // 取件
    Integer updateOrderToPickUp(@Param("order")Order order);
    // 配送员确认完成订单
    Integer updateDeliveryInfoToCompelete(@Param("order")Order order);
    // 更新快件为问题快件
    Integer updateDeliveryOrderProblem(@Param("order") Order order);

    // 新增订单：查看别人分享的文件
    Integer insertOrderForShareMemberPrice(Order order);
    // 更新订单完成
    Integer updateOrderCompelete(Integer orderId);
    // 删除订单
    Integer deleteOrder(@Param("id") String id);
    // 查看订单集合重构
    List<Order> selectOrderListOverWrite(@Param("order") Order order);
    // 查看订单重构
    Order selectOrderByIdOverWrite(String id);

    // 更新支付状态和时间 重写
    Integer updateOrderPayDateAndProcessOverWrite(@Param("orderId")Integer orderId,@Param("orderProcess") Integer orderProcess);

    // 取件
    List<Order> selectDeliveryFileByStoreIdListGetFile(@Param("order") Order order);
    // 确认收件
    Integer reminderOrderOverWrite(@Param("id") Integer id, @Param("orderProcess") Integer orderProcess);
    // 查看订单类别个数：待取件
    Integer selectCountOrderProcessWait(String userId);
    // 查看订单类别个数:进行中
    Integer selectCountOrderProcessing(String userId);
    // 查看订单类别个数:已完成
    Integer selectCountOrderProcessCompetety(String userId);
    // 查看订单类别个数:已取消
    Integer selectCountOrderProcessCancle(String userId);
}