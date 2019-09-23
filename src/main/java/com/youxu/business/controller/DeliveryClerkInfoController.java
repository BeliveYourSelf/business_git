package com.youxu.business.controller;

import com.youxu.business.pojo.DeliveryClerkInfo;
import com.youxu.business.service.DeliveryClerkInfoService;
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

@RequestMapping("/api")
@Api(description = "配送员信息表")
@RestController
public class DeliveryClerkInfoController {
    @Resource
    private DeliveryClerkInfoService deliveryClerkInfoService;

    @ApiOperation(value = "新增配送员信息", notes = "{\n" +
            "  \"deliveryClerkName\": \"李文轩\",\n" +
            "  \"deliveryClerkPhone\": \"13652157270\",\n" +
            "  \"emergencyPerson\": \"老李\",\n" +
            "  \"emergencyPhone\": \"13652147414\",\n" +
            "  \"idCardNum\": \"120221199512271411\",\n" +
            "  \"idCardOtherSize\": \"xxxx\",\n" +
            "  \"idCardPositive\": \"xxxxx\",\n" +
            "  \"userId\": 1\n" +
            "}     具体字段名含义查看swagger中Model")
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
}
