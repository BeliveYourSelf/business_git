package com.youxu.business.controller;

import com.youxu.business.pojo.DeliveryClerkInfo;
import com.youxu.business.pojo.Order;
import com.youxu.business.service.DeliveryClerkInfoService;
import com.youxu.business.service.OrderService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api")
@Api(description = "配送员信息表")
@RestController
public class DeliveryClerkInfoController {
    @Resource
    private DeliveryClerkInfoService deliveryClerkInfoService;
    @Resource
    private OrderService orderService;

    @ApiOperation(value = "新增配送员信息", notes = "{ \"deliveryClerkName\": \"李文轩\", \"deliveryClerkPhone\": \"13652157270\", \"emergencyPerson\": \"老李\", \"emergencyPhone\": \"13652147414\", \"idCardNum\": \"120221199512271411\", \"idCardOtherSize\": \"xxxx\", \"idCardPositive\": \"xxxxx\", \"userId\": 1 \n" +
            ",\"storeId\":\"1\"}     具体字段名含义查看swagger中Model")
    @PostMapping("/insertDeliveryClerkInfo")
    public ResponseMessage insertDeliveryClerkInfo(@RequestBody DeliveryClerkInfo deliveryClerkInfo) {
        Integer insertDeliveryClerkInfo= deliveryClerkInfoService.insertDeliveryClerkInfo(deliveryClerkInfo);
        if (insertDeliveryClerkInfo<=0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功");
    }
//    发送验证码


    @ApiOperation(value = "更新配送员信息", notes = "{\n" +
            "  \"deliveryClerkName\": \"李文轩\",\n" +
            "  \"deliveryClerkPhone\": \"13652157270\",\n" +
            "  \"emergencyPerson\": \"老李\",\n" +
            "  \"emergencyPhone\": \"13652147414\",\n" +
            "  \"idCardNum\": \"120221199512271411\",\n" +
            "  \"idCardOtherSize\": \"xxxx\",\n" +
            "  \"idCardPositive\": \"xxxxx\",\n" +
            "  \"id\": 1\n" +
            "}")
    @PostMapping("/updateDeliveryClerkInfo")
    public ResponseMessage updateDeliveryClerkInfo(@RequestBody DeliveryClerkInfo deliveryClerkInfo) {
        Integer updateDeliveryClerkInfo= deliveryClerkInfoService.updateDeliveryClerkInfo(deliveryClerkInfo);
        if (updateDeliveryClerkInfo<=0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功");
    }

    @ApiOperation(value = "查看快递员信息", notes = "userId")
    @GetMapping("/selectDeliveryClerkInfoByUserId")
    public ResponseMessage<DeliveryClerkInfo> selectDeliveryClerkInfoByUserId(@RequestParam String userId) {
        DeliveryClerkInfo deliveryClerkInfo =deliveryClerkInfoService.selectDeliveryClerkInfoByUserId(userId);
        if (StringUtils.isEmpty(deliveryClerkInfo)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "暂无计费规则");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",deliveryClerkInfo);
    }


    @ApiOperation(value = "待取件", notes = "storeIds")
    @GetMapping("/selectDeliveryFileByStoreIdList")
    public ResponseMessage<List<Order>> selectDeliveryFileByStoreIdList(@NotNull @RequestParam String[] storeIds) {
        List<Order> selectDeliveryFileByStoreIdList =orderService.selectDeliveryFileByStoreIdList(storeIds);
        if (selectDeliveryFileByStoreIdList.size() <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "暂无快递件");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",selectDeliveryFileByStoreIdList);
    }

    @ApiOperation(value = "待取件详情", notes = "订单id")
    @GetMapping("/selectDeliveryFileByOrderId")
    public ResponseMessage<Order> selectDeliveryFileByOrderId(@RequestParam String orderId) {
        Order selectDeliveryFileByOrderId =orderService.selectDeliveryFileByOrderId(orderId);
        if (StringUtils.isEmpty(selectDeliveryFileByOrderId)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",selectDeliveryFileByOrderId);
    }


}
