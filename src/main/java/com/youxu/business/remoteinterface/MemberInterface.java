package com.youxu.business.remoteinterface;

import com.youxu.business.pojo.remotepojo.User;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "useraccount")
public interface MemberInterface {
    @RequestMapping(value = "/userLogin/selectUserInfoByUId", method = RequestMethod.GET)
    public ResponseMessage<User> selectUserInfoByUId(Integer userId);
}
