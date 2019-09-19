package com.youxu.business.controller;

import com.youxu.business.pojo.Harvest;
import com.youxu.business.pojo.Share;
import com.youxu.business.service.ShareService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import com.youxu.business.utils.transicatetool.DateTransform;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;

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
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", insertShare);
    }

    @ApiOperation(value = "查看分享通过用户id和分享码", notes = "{\"shareUserId\":\"588\"\n" +
            ",\"extactionCode\":\"VQB9\"} shareUserId:分享人用户id   extactionCode：提取码")
    @PostMapping("/selectShareByUserIdAndExtactionCode")
    public ResponseMessage<Share> selectShareByUserIdAndExtactionCode(@RequestBody Share share) {
        Share selectShareByUserIdAndExtactionCode = shareService.selectShareByUserIdAndExtactionCode(share);
        if (StringUtils.isEmpty(selectShareByUserIdAndExtactionCode)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "已过期");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", selectShareByUserIdAndExtactionCode);
    }

    @ApiOperation(value = "再次分享", notes = "id   分享表的id")
    @GetMapping("/selectShareById")
    public ResponseMessage<Share> selectShareById(@RequestParam String id) {
        Share selectShareById = shareService.selectShareById(id);
        if (StringUtils.isEmpty(selectShareById)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", selectShareById);
    }

    @ApiOperation(value = "下载", notes = "{\"id\":\"2\"\n" +
            ",\"extactionCode\":\"VVka\"}     id: 分享表id   extactionCode: 提取码")
    @PostMapping("/downloadShare")
    public ResponseMessage<Share> downloadShare(@RequestBody Share share) {
        Share downloadShare = shareService.downloadShare(share);
        // 分享已过期
        if (!StringUtils.isEmpty(downloadShare) && StringUtils.isEmpty(expireDate(downloadShare))) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "文件过期");
        }
        // 提取码错误
        if (!StringUtils.isEmpty(downloadShare) && downloadShare.getExtactionCodeStatus() && StringUtils.isEmpty(share.getExtactionCode()) && share.getExtactionCode() != downloadShare.getExtactionCode()) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "提取码错误");
        }
        if (StringUtils.isEmpty(downloadShare)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        // 判断是否为会员
        // 调起支付
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", downloadShare);
    }

    public Share expireDate(Share shareNew) {
// 判断文件过期
        String periodOfValidity = shareNew.getPeriodOfValidity();
        Date periodOfValidityNew = DateTransform.stringFormatTransToDate(periodOfValidity);
        Date date = new Date();
        long nowTime = date.getTime();
        long periodOfValidityTime = periodOfValidityNew.getTime();
        if (nowTime - periodOfValidityTime > 0) {
            return null;  //过期
        }
        return shareNew;
    }

}
