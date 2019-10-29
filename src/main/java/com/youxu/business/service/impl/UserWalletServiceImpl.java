package com.youxu.business.service.impl;

import com.youxu.business.dao.UserWalletMapper;
import com.youxu.business.pojo.Order;
import com.youxu.business.pojo.UserWallet;
import com.youxu.business.service.UserWalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserWalletServiceImpl implements UserWalletService {
    private final static Logger logger = LoggerFactory.getLogger(UserWalletServiceImpl.class);
    @Resource
    private UserWalletMapper userWalletMapper;

    @Override
    public void addUserWallet(Order order) {
        logger.info("order订单对象：===================="+order.toString());
        Double orderActualMoney = order.getOrderActualMoney();
        Integer orderActualMoneyInteger = orderActualMoney.intValue();
        UserWallet userWallet = userWalletMapper.selectUserWalletByUserId(order.getUserId());
        logger.info("查看userWallet对象：===================="+userWallet.toString());
        int userIntegralAll = userWallet.getUserIntegral() + orderActualMoneyInteger;
        userWallet.setUserIntegral(userIntegralAll);
        int updateUserWallet = userWalletMapper.updateUserWallet(userWallet);
        logger.info("更新积分成功：===================="+updateUserWallet);
    }
}
