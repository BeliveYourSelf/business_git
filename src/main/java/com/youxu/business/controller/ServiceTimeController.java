package com.youxu.business.controller;

import com.youxu.business.pojo.ServiceTime;
import com.youxu.business.service.ServiceTimeService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "配送时间表")
@RequestMapping("/api")
@RestController
public class ServiceTimeController {
    @Resource
    private ServiceTimeService serviceTimeService;

    @ApiOperation(value = "查看配送时间价格列表", notes = "{\"storeId\":\"1\"\n" +
            ",\"dayType\":\"1\"\n" +
            "}       storeId  商铺id   dayType 1.今天2.明天3.后天 ")
    @PostMapping("/selectServiceTime")
    public ResponseMessage<List<ServiceTime>> selectServiceTime(@RequestBody ServiceTime serviceTime) {
        List<ServiceTime> selectServiceTime =serviceTimeService.selectServiceTime(serviceTime);
        if (StringUtils.isEmpty(selectServiceTime)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "暂无计费规则");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",selectServiceTime);
    }
}
