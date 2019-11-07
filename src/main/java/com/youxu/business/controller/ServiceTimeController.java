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
    @ApiOperation(value = "查看今日，明天，后天预览信息", notes = "serviceType:1.今天2.明天3.后天4.一小时达5.精准达 ")
    @GetMapping("/selPreviewMessage")
    public ResponseMessage selPreviewMessage(@RequestParam("storeId") Integer storeId,
                                             @RequestParam("serviceType") Integer serviceType){
        ArrayList<TimeAndPrice> timeAndPriceArrayList=new ArrayList<>();
        if(Integer.valueOf(1).equals(serviceType)){
            TimeAndPrice timeAndPrice = new TimeAndPrice();
            List<ServicePrice> servicePriceList=serviceTimeService.selServicePrice(storeId,4);
            if(servicePriceList.size()>0 && !StringUtils.isEmpty(servicePriceList.get(0).getPrice())){
            double price = servicePriceList.get(0).getPrice();
            timeAndPrice.setPrice(price);
            timeAndPrice.setTheTime("1小时达");
            timeAndPriceArrayList.add(timeAndPrice);
            }
        }
        List<ServicePrice> servicePriceList=serviceTimeService.selServicePrice(storeId,serviceType);
        List<DeliverySchedule> selAutomaticGenerationList = serviceTimeService.selAutomaticGeneration(storeId);
        DateFormat df = new SimpleDateFormat("HH:mm");
        for (ServicePrice s:servicePriceList){
            for(DeliverySchedule d:selAutomaticGenerationList){
                try {
                    Long startTime = df.parse(s.getStartTime()).getTime();
                    Long endTime = df.parse(s.getEndTime()).getTime();
                    Long deliveryTime=df.parse(d.getDeliveryTime()).getTime();
                    if(deliveryTime>=startTime && deliveryTime<=endTime){
                        TimeAndPrice timeAndPrice = new TimeAndPrice();
                        timeAndPrice.setTheTime(d.getDeliveryTime());
                        timeAndPrice.setPrice(s.getPrice());
                        timeAndPriceArrayList.add(timeAndPrice);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"查询成功",timeAndPriceArrayList);
    }

}
