package com.youxu.business.controller;

import com.youxu.business.pojo.DeliverySchedule;
import com.youxu.business.pojo.ServicePrice;
import com.youxu.business.pojo.ServiceTime;
import com.youxu.business.pojo.TimeAndPrice;
import com.youxu.business.service.ServiceTimeService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Api(description = "配送时间表")
@RequestMapping("/api")
@RestController
public class ServiceTimeController {
    private final static Logger logger = LoggerFactory.getLogger(ServiceTimeController.class);

    @Resource
    private ServiceTimeService serviceTimeService;


    @ApiOperation(value = "查看配送时间价格列表：弃用", notes = "{\"storeId\":\"1\"\n" +
            ",\"dayType\":\"1\"\n" +
            "}       storeId  商铺id   dayType 1.今天2.明天3.后天 ")
    @PostMapping("/selectServiceTime")
    public ResponseMessage<List<ServiceTime>> selectServiceTime(@RequestBody ServiceTime serviceTime) {
        List<ServiceTime> selectServiceTime = serviceTimeService.selectServiceTime(serviceTime);
        if (StringUtils.isEmpty(selectServiceTime)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "暂无计费规则");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", selectServiceTime);
    }

    @ApiOperation(value = "查看今日，明天，后天预览信息", notes = "serviceType:1.今天2.明天3.后天4.一小时达5.精准达。  注：serviceType=5 ，需要传timeStamp(格式: 10:30)")
    @GetMapping("/selPreviewMessage")
    public ResponseMessage selPreviewMessage(@RequestParam("storeId") Integer storeId,
                                             @RequestParam("serviceType") Integer serviceType, @RequestParam(value = "timeStamp", required = false) String timeStamp) {
        try {
            // 精准达
            ArrayList<TimeAndPrice> timeAndPriceArrayList = new ArrayList<>();
            DateFormat df = new SimpleDateFormat("HH:mm");
            if ("5".equals(serviceType.toString())) {
                List<ServicePrice> servicePriceList = serviceTimeService.selServicePrice(storeId, serviceType);
                for (ServicePrice s : servicePriceList) {
                    Long startTime = df.parse(s.getStartTime()).getTime();
                    Long endTime = df.parse(s.getEndTime()).getTime();
                    Long deliveryTime = df.parse(timeStamp).getTime();
                    if (deliveryTime >= startTime && deliveryTime <= endTime) {
                        TimeAndPrice timeAndPrice = new TimeAndPrice();
                        timeAndPrice.setTheTime(timeStamp);
                        timeAndPrice.setPrice(s.getPrice());
                        timeAndPriceArrayList.add(timeAndPrice);
                    }
                }
                return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "查询成功", timeAndPriceArrayList);
            } else {
                // 一小时达
                if (Integer.valueOf(1).equals(serviceType)) {
                    TimeAndPrice timeAndPrice = new TimeAndPrice();
                    List<ServicePrice> servicePriceList = serviceTimeService.selServicePrice(storeId, 4);
                    if (servicePriceList.size() > 0 && !StringUtils.isEmpty(servicePriceList.get(0).getPrice())) {
                        double price = servicePriceList.get(0).getPrice();
                        timeAndPrice.setPrice(price);
                        timeAndPrice.setTheTime("1小时达");
                        timeAndPriceArrayList.add(timeAndPrice);
                    }
                }
                // 普通配送
                List<ServicePrice> servicePriceList = serviceTimeService.selServicePrice(storeId, serviceType);
                List<DeliverySchedule> selAutomaticGenerationList = serviceTimeService.selAutomaticGeneration(storeId);
                for (ServicePrice s : servicePriceList) {
                    for (DeliverySchedule d : selAutomaticGenerationList) {
                        Long startTime = df.parse(s.getStartTime()).getTime();
                        Long endTime = df.parse(s.getEndTime()).getTime();
                        Long deliveryTime = df.parse(d.getDeliveryTime()).getTime();
                        if (deliveryTime >= startTime && deliveryTime <= endTime) {
                            TimeAndPrice timeAndPrice = new TimeAndPrice();
                            timeAndPrice.setTheTime(d.getDeliveryTime());
                            timeAndPrice.setPrice(s.getPrice());
                            timeAndPriceArrayList.add(timeAndPrice);
                        }
                    }
                }
                return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "查询成功", timeAndPriceArrayList);
            }
        } catch (Exception e) {
            logger.info("查看今日，明天，后天预览信息:" + e.getMessage());
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), "失败", e.getMessage());
        }
    }
}
