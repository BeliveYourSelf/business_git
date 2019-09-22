package com.youxu.business.controller;

import com.youxu.business.pojo.Order;
import com.youxu.business.service.OrderService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "订单表")
@RequestMapping("/api")
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @ApiOperation(value = "新增订单", notes = "{ \"orderActualMoney\": \"100\"\n" +
            " , \"orderAddresseeAddress\": \"天津市立晟科技\" \n" +
            ", \"orderAddresseeName\": \"李文轩\" \n" +
            ", \"orderAddresseePhone\": \"13652157270\" \n" +
            ", \"orderConsumeMoney\": 10 \n" +
            ", \"orderCouponMoney\": 10 \n" +
            ", \"orderDeliveryMoney\": \"10\"\n" +
            ", \"orderDeliveryPrescriptioTime\": \"60\" \n" +
            ", \"orderDetailsList\": [ { \"orderDetailsCount\": 10 \n" +
            ",\"orderDetailsName\":\"文档打印pdf\"\n" +
            ",\"orderDetailsOnePictureUrl\":\"xxxx\" \n" +
            ",\"orderDetailsTotalPrice\":\"200\"\n" +
            ",\"orderSpecName\":\"一寸6合一横板\" \n" +
            ",\"orderDetailsCountColour\":\"10\"\n" +
            " ,\"orderDetailsBookBinding\": {\n" +
            "        \"coverColor\": \"黑色\",\n" +
            "        \"coverFileUrl\": \"xxx\",\n" +
            "        \"faceDirection\": \"横向\"\n" +
            "    \n" +
            "      }\n" +
            " }\n" +
            "] \n" +
            ", \"orderExtraMoney\": 10 \n" +
            ", \"orderFromStoreGet\": \"3\" \n" +
            ", \"orderFromStoreGetWhere\": \"天津工业大学1号宿舍楼\" \n" +
            ", \"orderPrintMoney\": \"10\" \n" +
            ", \"orderProcess\": 1 \n" +
            ", \"orderType\": 1 \n" +
            ", \"storeId\": 1 \n" +
            ", \"userId\": 1 }")
    @PostMapping("/insertOrder")
    public ResponseMessage<Integer> insertOrder(@RequestBody Order order) {
        Integer insertOrder = orderService.insertOrder(order);
        if (insertOrder.equals(0)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "新增失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }

    /**
     * 催单/确认收件
     */
    @ApiOperation(value = "催单/确认收件", notes = "{\"id\":\"1\"\n" +
            ",\"orderType\":\"2\"}")
    @PostMapping("/reminderOrder")
    public ResponseMessage<Integer> reminderOrder(@RequestBody Order order) {
        Integer reminderOrder = orderService.reminderOrder(order);
        if (reminderOrder <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }

    /**
     * 取消订单
     */
    @ApiOperation(value = "取消订单", notes = "{\"id\":\"1\"}")
    @GetMapping("/cancleOrder")
    public ResponseMessage<Integer> cancelOrder(@RequestParam String id) {
        Integer cancelOrder = orderService.cancelOrder(id);
        if (cancelOrder <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }

    /**
     * 更新订单
     */
    @ApiOperation(value = "更新订单", notes = "{\"id\":\"1\", \"orderActualMoney\": \"100\", \"orderAddresseeAddress\": \"天津市立晟科技\", \"orderAddresseeName\": \"李文轩1\", \"orderAddresseePhone\": \"13652157270\", \"orderConsumeMoney\": 10, \"orderCouponMoney\": 10, \"orderDeliveryMoney\": \"10\", \"orderDeliveryPrescriptioTime\": \"60\", \"orderDetailsList\": [ { \"orderDetailsCount\": 10,\n" +
            "\n" +
            "  \"orderDetailsName\": \"一寸白底\",\n" +
            "  \"orderDetailsOnePictureUrl\": \"/dishesPicture/20190611/app小程序制作.png\",\n" +
            "  \"orderDetailsTotalPrice\": 10,\n" +
            "  \"orderDetailsTypesettingPictureUrl\": \"/dishesPicture/20190611/app小程序制作.png\",\n" +
            "  \"orderId\": 1,\n" +
            "  \"orderSpecName\":\"一寸白底-横板-六合一\",\n" +
            "  \"orderDetailsCountColour\":\"10\"\n" +
            "}\n" +
            "], \"orderExtraMoney\": 10, \"orderFromStoreGet\": \"3\", \"orderFromStoreGetWhere\": \"天津工业大学1号宿舍楼\", \"orderPrintMoney\": \"10\", \"orderProcess\": 1, \"orderType\": 1, \"storeId\": 1, \"userId\": 1 }")
    @PostMapping("/updateOrder")
    public ResponseMessage<Integer> updateOrder(@RequestBody Order order) {
        Integer updateOrder = orderService.updateOrder(order);
        if (updateOrder <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }

    @ApiOperation(value = "重新下单/再次下单", notes = "id 订单id")
    @GetMapping("/insertOrderAgain")
    public ResponseMessage<Integer> insertOrderAgain(@RequestParam String id) {
        Order insertOrderAgain = orderService.insertOrderAgain(id);
        Integer insertOrder = orderService.insertOrder(insertOrderAgain);
        if (insertOrder <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }

    @ApiOperation(value = "查看订单打印列表", notes = "{\"pageNo\":\"1\"\n" +
            ",\"pageSize\":\"1\"\n" +
            ",\"orderProcess\":\"1\"}        orderProcess：订单进行状态:1.待付款2.进行中3.已完成4.已取消")
    @PostMapping("/selectOrderList")
    public ResponseMessage<List<Order>> selectOrderList(@RequestBody Order order) {
        List<Order> selectOrderList = orderService.selectOrderList(order);
        if (selectOrderList.size() <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功",selectOrderList);
    }

}
