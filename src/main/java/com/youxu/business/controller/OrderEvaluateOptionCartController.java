package com.youxu.business.controller;

import com.youxu.business.pojo.OrderEvaluateOptionCart;
import com.youxu.business.pojo.OrderEvaluateOptionCartMapper;
import com.youxu.business.service.OrderEvaluateOptionCartService;
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
@Api(description = "订单评价选项卡")
public class OrderEvaluateOptionCartController {
    @Resource
    private OrderEvaluateOptionCartService orderEvaluateOptionCartService;
    @ApiOperation(value = "查看订单评价选项卡集合", notes = "")
    @GetMapping("/selectOrderEvaluateOptionCart")
    public ResponseMessage<List<OrderEvaluateOptionCart>> selectOrderEvaluateOptionCart() {
        List<OrderEvaluateOptionCart> orderEvaluateOptionCartMapper =orderEvaluateOptionCartService.selectOrderEvaluateOptionCart();
        if (orderEvaluateOptionCartMapper.size()<=0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",orderEvaluateOptionCartMapper);
    }
}
