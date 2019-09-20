package com.youxu.business.controller;

import com.youxu.business.pojo.Store;
import com.youxu.business.service.StoreService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(description = "店铺表")
public class StoreController {
    @Resource
    private StoreService storeService;

    @ApiOperation(value = "查看所有店铺表", notes = "")
    @GetMapping("/selectStoreList")
    public ResponseMessage<List<Store>> selectStoreList() {
        List<Store> selectStoreList =storeService.selectStoreList();
        if (selectStoreList.size() <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "暂无店铺");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",selectStoreList);
    }
}
