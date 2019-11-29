package com.youxu.business.controller;

import com.youxu.business.service.OrderDetailsBookBindingService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/api")
@RestController
@Api(description = "装订订单明细表")
public class OrderDetailsBookBindingController {
    @Resource
    private OrderDetailsBookBindingService orderDetailsBookBindingService;
}
