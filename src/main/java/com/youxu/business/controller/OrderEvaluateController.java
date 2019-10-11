package com.youxu.business.controller;

import com.youxu.business.pojo.BillingRule;
import com.youxu.business.pojo.OrderEvaluate;
import com.youxu.business.service.OrderEvaluateService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/api")
@RestController
@Api(description = "订单评价")
public class OrderEvaluateController {
    @Resource
    private OrderEvaluateService orderEvaluateService;

    @ApiOperation(value = "插入订单评价", notes = "{ \"orderComment\": \"快递不好\",\n" +
            "\"orderEvaluateOptionCartIdList\": [ 1,2,3 ], \"orderEvaluateStar\": 1,\n" +
            "\"orderId\": 2\n" +
            ",\"orderEvaluatePictureList\":[ xxxx,xxx,xxxx ] }   orderEvaluateOptionCartIdList:评价选项卡id    orderEvaluatePictureList: 订单评价图片集合")
    @PostMapping("/insertOrderEvaluate")
    public ResponseMessage insertOrderEvaluate(@RequestBody OrderEvaluate orderEvaluate) {
        Integer insertOrderEvaluate =orderEvaluateService.insertOrderEvaluate(orderEvaluate);
        if (insertOrderEvaluate<=0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功");
    }
}
