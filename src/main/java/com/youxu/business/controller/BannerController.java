package com.youxu.business.controller;

import com.youxu.business.pojo.Banner;
import com.youxu.business.service.BannerService;
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
@RequestMapping("/api")
@Api(description = "banner表")
public class BannerController {
    @Resource
    private BannerService bannerService;

    @ApiOperation(value = "查看所有banner", notes = "")
    @GetMapping("/selectBannerList")
    public ResponseMessage<List<Banner>> selectBannerList() {
        List<Banner> selectBannerList =bannerService.selectBannerList();
        if (selectBannerList.size() <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",selectBannerList);
    }

    @ApiOperation(value = "查看其中一个banner", notes = "banner的id")
    @GetMapping("/selectBannerById")
    public ResponseMessage<Banner> selectOneBannerById(@RequestParam String id) {
        Banner selectBannerById =bannerService.selectBannerById(id);
        if (StringUtils.isEmpty(selectBannerById)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",selectBannerById);
    }
}
