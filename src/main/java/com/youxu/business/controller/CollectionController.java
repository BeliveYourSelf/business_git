package com.youxu.business.controller;

import com.youxu.business.pojo.Collection;
import com.youxu.business.service.CollectionService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/api")
@RestController
@Api(description = "收藏表")
public class CollectionController {
    @Resource
    private CollectionService collectionService;

    @ApiOperation(value = "新增收藏", notes = "{\"collectionUserId\":\"10\"\n" +
            ",\"shareId\":\"3\"}      collectionUserId：收藏人用户信息  shareId:分享表id")
    @PostMapping("/insertCollection")
    public ResponseMessage insertCollection(@RequestBody Collection collection) {
        Integer insertCollection= collectionService.insertCollection(collection);
        if (insertCollection<=0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功");
    }
}
