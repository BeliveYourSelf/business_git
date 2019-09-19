package com.youxu.business.controller;

import com.youxu.business.pojo.Harvest;
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


    @ApiOperation(value = "新增分享", notes = "{ \n" +
            "\"downloadDuplicatedPrintStatus\": 1\n" +
            ",\"resourcePrintMoney\":\"10\"\n" +
            ",\"resourceSaveDownloadMoney\": 10\n" +
            ", \"extactionCodeStatus\": true\n" +
            ", \"periodOfValidity\": \"2019-09-17T10:44:11.950Z\"\n" +
            ", \"shareUserId\": 1, \"usreHeadImage\": \"/image/4654653498/10231.jpeg\" ,\"shareContentUrl\":\"xxxxxxxxxxxxxxxx\" }    resourcePrintMoney：资源打印价格    resourceSaveDownloadMoney：资源转存下载价格   shareContentUrl:文件内容路径   downloadDuplicatedPrintStatus: 1.资源打印售价  2.资源转存下载售价 3.不可下载或转存    downloadDuplicatedPrintMoney: 资源打印售价/资源转存下载售价(double)  extactionCodeStatus: 是否有提取码(true/false)  ")
    @PostMapping("/insertShare")
    public ResponseMessage<Share> insertShare(@RequestBody Share share) throws ParseException {
        Share insertShare = shareService.insertShare(share);
        if (StringUtils.isEmpty(insertShare)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功",insertShare);
    }

    @ApiOperation(value = "查看分享通过用户id和分享码", notes = "{\"shareUserId\":\"588\"\n" +
            ",\"extactionCode\":\"VQB9\"} shareUserId:分享人用户id   extactionCode：提取码")
    @PostMapping("/selectShareByUserIdAndExtactionCode")
    public ResponseMessage<Share> selectShareByUserIdAndExtactionCode(@RequestBody Share share) {
        Share selectShareByUserIdAndExtactionCode= shareService.selectShareByUserIdAndExtactionCode(share);
        if (StringUtils.isEmpty(selectShareByUserIdAndExtactionCode)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "暂无收获地址");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",selectShareByUserIdAndExtactionCode);
    }

}
