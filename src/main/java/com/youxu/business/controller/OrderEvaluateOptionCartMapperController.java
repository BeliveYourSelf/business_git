package com.youxu.business.controller;

import com.youxu.business.pojo.BillingRule;
import com.youxu.business.pojo.OrderEvaluateOptionCartMapper;
import com.youxu.business.service.OrderEvaluateOptionCartMapperService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/api")
@RestController
@Api(description = "订单评价选项卡映射表")
public class OrderEvaluateOptionCartMapperController {
    @Resource
    private OrderEvaluateOptionCartMapperService orderEvaluateOptionCartMapperService;


}
