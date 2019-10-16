package com.youxu.business.controller;

import com.github.pagehelper.PageInfo;
import com.youxu.business.pojo.Collection;
import com.youxu.business.service.CollectionService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/api")
@RestController
@Api(description = "收藏表")
public class CollectionController {
    @Resource
    private CollectionService collectionService;

    @ApiOperation(value = "新增收藏", notes = "[\n" +
            "  {\n" +
            "    \"collectionImage\": \"https://youxu/oss/headImage.jpg\",\n" +
            "    \"collectionName\": \"李文轩\",\n" +
            "    \"collectionUserId\": 1,\n" +
            "    \"effectiveTime\": \"string\",\n" +
            "    \"fileSize\": 0,\n" +
            "    \"shareId\": 3,\n" +
            "    \"status\": false\n" +
            "  },\n" +
            "{\n" +
            "    \"collectionImage\": \"https://youxu/oss/headImage.jpg\",\n" +
            "    \"collectionName\": \"陈凯\",\n" +
            "    \"collectionUserId\": 1,\n" +
            "    \"effectiveTime\": \"string\",\n" +
            "    \"fileSize\": 0,\n" +
            "    \"shareId\": 3,\n" +
            "    \"status\": false\n" +
            "  }\n" +
            "]      collectionUserId：收藏人用户信息  shareId:分享表id   collectionImage 来源人头像  collectionName  来源人名称 fileSize  文件大小（单位兆） ")
    @PostMapping("/insertCollection")
    public ResponseMessage insertCollection(@RequestBody List<Collection> collectionList) {
        Integer insertCollection= collectionService.insertCollection(collectionList);
        if (insertCollection<=0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功");
    }

    @ApiOperation(value = "查看收藏列表", notes = "{\"collectionUserId\":\"10\"\n" +
            ",\"pageNo\":\"1\"\n" +
            ",\"pageSize\":\"10\"}   收藏人用户id")
    @PostMapping("/selectCollection")
    public ResponseMessage<PageInfo<Collection>> selectCollection(@RequestBody Collection collection) {
        PageInfo<Collection> selectCollection = collectionService.selectCollection(collection);
        if (StringUtils.isEmpty(selectCollection)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功",selectCollection);
    }

    @ApiOperation(value = "删除收藏列表", notes = "1,2")
    @GetMapping("/deleteCollection")
    public ResponseMessage<Integer> deleteCollection(String[] arrayCollectionId) {
        Integer deleteCollection = collectionService.deleteCollection(arrayCollectionId);
        if (deleteCollection <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功",deleteCollection);
    }
}
