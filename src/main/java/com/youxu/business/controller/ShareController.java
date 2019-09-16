package com.youxu.business.controller;

import com.youxu.business.pojo.Share;
import com.youxu.business.service.ShareService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/api")
@RestController
@Api(description = "分享表")
public class ShareController {
    @Resource
    private ShareService shareService;


    @ApiOperation(value = "新增分享", notes = "")
    @PostMapping("/insertShare")
    public ResponseMessage<Integer> insertShare(@RequestBody Share share) {
        Integer insertShare = shareService.insertShare(share);
        if (insertShare <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }
}
