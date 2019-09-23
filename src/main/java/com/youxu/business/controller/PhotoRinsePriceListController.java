package com.youxu.business.controller;

import com.youxu.business.pojo.BillingRule;
import com.youxu.business.pojo.PhotoRinsePriceList;
import com.youxu.business.service.PhotoRinsePriceListService;
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
@Api(description = "照片冲印价格表")
public class PhotoRinsePriceListController {
    @Resource
    private PhotoRinsePriceListService photoRinsePriceListService;

    @ApiOperation(value = "查看照片冲印集合根据商户id", notes = "storeId")
    @GetMapping("/selectPhotoRinsePriceList")
    public ResponseMessage<List<PhotoRinsePriceList>> selectPhotoRinsePriceList(@RequestParam String storeId) {
        List<PhotoRinsePriceList> photoRinsePriceList =photoRinsePriceListService.selectPhotoRinsePriceList(storeId);
        if (photoRinsePriceList.size() <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",photoRinsePriceList);
    }
}
