package com.youxu.business.controller;

import com.youxu.business.pojo.Share;
import com.youxu.business.service.ShareService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;

@RequestMapping("/api")
@RestController
@Api(description = "分享表")
public class ShareController {
    @Resource
    private ShareService shareService;


    @ApiOperation(value = "新增分享", notes = "{\n" +
            "  \"downloadDuplicatedPrintMoney\": 10,\n" +
            "  \"downloadDuplicatedPrintStatus\": 1,\n" +
            "  \"extactionCodeStatus\": true,\n" +
            "  \"periodOfValidity\": \"2019-09-17T10:44:11.950Z\",\n" +
            "  \"shareUserId\": 1,\n" +
            "  \"usreHeadImage\": \"/image/4654653498/10231.jpeg\"\n" +
            "}      downloadDuplicatedPrintStatus: 1.资源打印售价  2.资源转存下载售价 3.不可下载或转存    downloadDuplicatedPrintMoney: 资源打印售价/资源转存下载售价(double)  extactionCodeStatus: 是否有提取码(true/false)  ")
    @PostMapping("/insertShare")
    public ResponseMessage<Share> insertShare(@RequestBody Share share) throws ParseException {
        Share insertShare = shareService.insertShare(share);
        if (StringUtils.isEmpty(insertShare)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功",insertShare);
    }
}
