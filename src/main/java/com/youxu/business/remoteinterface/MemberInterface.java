package com.youxu.business.remoteinterface;

import com.youxu.business.pojo.remotepojo.User;
import com.youxu.business.pojo.remotepojo.UserWallet;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "useraccount")
public interface MemberInterface {
    // 查看用户信息
    @RequestMapping(value = "/userLogin/selectUserInfoByUId", method = RequestMethod.GET)
    public ResponseMessage<User> selectUserInfoByUId(Integer userId);
    // 查看用户会员信息
    @RequestMapping(value = "/userLogin/userWallet", method = RequestMethod.GET)
    public ResponseMessage<UserWallet> selectUserMemberByUserId(Integer userId);
    // 更新用户消费金和钱包余额
    @RequestMapping(value = "/userLogin/updateUserWallet", method = RequestMethod.GET)
    public ResponseMessage<Integer> updateUserWallet(@RequestParam("userId") Integer userId,@RequestParam("amount") Double amount,@RequestParam("cashback") Double cashback);

    @RequestMapping(value = "/userLogin/updateUserWallet1", method = RequestMethod.GET)
    public ResponseMessage<Integer> updateUserWallet(@RequestParam("userId") Integer userId,@RequestParam("amount") Double amount);


}
