package com.youxu.business.controller;

import com.youxu.business.pojo.Order;
import com.youxu.business.service.OrderService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(description = "订单表")
@RequestMapping("/api")
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @ApiOperation(value = "新增订单", notes = "{\n" +
            "  \"id\": 0,\n" +
            "  \"orderActualMoney\": \"100\",\n" +
            "  \"orderAddresseeAddress\": \"天津市立晟科技\",\n" +
            "  \"orderAddresseeName\": \"李文轩\",\n" +
            "  \"orderAddresseePhone\": \"13652157270\",\n" +
            "  \"orderConsumeMoney\": 10,\n" +
            "  \"orderCouponMoney\": 10,\n" +
            "  \"orderDeliveryMoney\": \"10\",\n" +
            "  \"orderDeliveryPrescriptioTime\": \"60\",\n" +
            "  \"orderDetailsList\": [\n" +
            "    {\n" +
            "      \"orderDetailsCount\": 10,\n" +
            "\n" +
            "      \"orderDetailsName\": \"一寸白底\",\n" +
            "      \"orderDetailsOnePictureUrl\": \"/dishesPicture/20190611/app小程序制作.png\",\n" +
            "      \"orderDetailsTotalPrice\": 10,\n" +
            "      \"orderDetailsTypesettingPictureUrl\": \"/dishesPicture/20190611/app小程序制作.png\",\n" +
            "      \"orderId\": 1\n" +
            "    }\n" +
            "  ],\n" +
            "  \"orderExtraMoney\": 10,\n" +
            "  \"orderFromStoreGet\": \"3\",\n" +
            "  \"orderFromStoreGetWhere\": \"天津工业大学1号宿舍楼\",\n" +
            "  \"orderPrintMoney\": \"10\",\n" +
            "  \"orderProcess\": 1,\n" +
            "  \"orderType\": 1,\n" +
            "  \"storeId\": 1,\n" +
            "  \"userId\": 1\n" +
            "}")
    @PostMapping("/insertOrder")
    public ResponseMessage<Integer> insertOrder(@RequestBody Order order) {
        Integer insertOrder = orderService.insertOrder(order);
        if (insertOrder.equals(0)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "新增失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功");
    }

    /**
     * 催单/确认收件
     */
    @ApiOperation(value = "催单/确认收件",notes = "{\"id\":\"1\"\n" +
            ",\"orderType\":\"2\"}")
    @PostMapping("/reminderOrder")
    public ResponseMessage<Integer> reminderOrder(@RequestBody Order order) {
        Integer reminderOrder = orderService.reminderOrder(order);
        if (reminderOrder <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功");
    }
}
