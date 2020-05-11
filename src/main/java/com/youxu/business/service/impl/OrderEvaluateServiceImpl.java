package com.youxu.business.service.impl;

import com.youxu.business.dao.*;
import com.youxu.business.pojo.Order;
import com.youxu.business.pojo.OrderEvaluate;
import com.youxu.business.pojo.OrderEvaluateOptionCartMapper;
import com.youxu.business.pojo.User;
import com.youxu.business.service.OrderEvaluateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderEvaluateServiceImpl implements OrderEvaluateService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private OrderEvaluateMapper orderEvaluateMapper;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderEvaluateOptionCartMapperMapper orderEvaluateOptionCartMapperMapper;
    @Resource
    private PictureMapper pictureMapper;
    @Resource
    private OrderEvaluatePictureMappingMapper orderEvaluatePictureMappingMapper;
    @Override
    public Integer insertOrderEvaluate(OrderEvaluate orderEvaluate) {
        //查看订单对应人的
        Order order = orderMapper.selectOrderById(orderEvaluate.getOrderId().toString());
        User user = userMapper.selectByPrimaryKey(order.getUserId());
        orderEvaluate.setOrderEvaluateName(user.getUserName());
        orderEvaluate.setOrderEvaluatePhone(user.getUserPhone());
        orderEvaluate.setOrderEvaluateAccount(user.getUserName());
        orderEvaluate.setStoreId(order.getStoreId());
        Integer insertOrderEvaluate = orderEvaluateMapper.insertOrderEvaluate(orderEvaluate);
        int orderEvaluateId = orderMapper.lastInsertId();
        // 关联订单评价选项卡
        List<Integer> orderEvaluateOptionCartIdList = orderEvaluate.getOrderEvaluateOptionCartIdList();
        Integer  insertOrderEvaluateOptionCartMapperMapper = orderEvaluateOptionCartMapperMapper.insertOrderEvaluateOptionCartMapperMapper(orderEvaluateId,orderEvaluateOptionCartIdList);
        // 关联订单评价图片集合
        List<String> orderEvaluatePictureList = orderEvaluate.getOrderEvaluatePictureList();
        int insertPictureMapper = pictureMapper.insertPictureMapper(orderEvaluatePictureList);
        int pictureFirstId = orderMapper.lastInsertId();
        // 根据插入第一个图片返回的id，查看所有图片的id
        int size = orderEvaluatePictureList.size();
        List<Integer> pictureIdList = new ArrayList<>();
        for (int j = 1; size >= j; j++) {
            pictureIdList.add(pictureFirstId + j - 1);
        }
        Integer insertEvaluatePicture = orderEvaluatePictureMappingMapper.insertEvaluatePictureList(orderEvaluateId,pictureIdList);
        return insertOrderEvaluate;
    }
}
