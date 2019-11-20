package com.youxu.business.controller;

import com.youxu.business.pojo.Banner;
import com.youxu.business.pojo.Notify;
import com.youxu.business.service.NotifyService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(description = "通知对象")
@RequestMapping("/api")
public class NotifyController {
    @Resource
    private NotifyService notifyService;

    @ApiOperation(value = "查看通知", notes = "")
    @GetMapping("/selectNotify")
    public ResponseMessage<Notify> selectNotify() {
        Notify notify= notifyService.selectNofity();
        if (StringUtils.isEmpty(notify)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "暂无通知");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",notify);
    }
}
