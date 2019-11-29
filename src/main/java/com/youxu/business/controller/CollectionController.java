package com.youxu.business.controller;

import com.github.pagehelper.PageInfo;
import com.youxu.business.pojo.Collection;
import com.youxu.business.service.CollectionService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/api")
@RestController
@Api(description = "收藏表")
public class CollectionController {
    private final static Logger logger = LoggerFactory.getLogger(CollectionController.class);

    @Resource
    private CollectionService collectionService;

    @ApiOperation(value = "新增收藏", notes = "[ { \"collectionImage\": \"https://youxu/oss/headImage.jpg\", \"collectionName\": \"李文轩\", \"collectionUserId\": 1, \"effectiveTime\": \"string\", \"fileSize\": 0, \"shareId\": 3, \"status\": false\n" +
            ",\"contentUrl\":\"xxx\",\"sizePage\":\"2\" }, { \"collectionImage\": \"https://youxu/oss/headImage.jpg\", \"collectionName\": \"陈凯\", \"collectionUserId\": 1, \"effectiveTime\": \"string\", \"fileSize\": 0, \"shareId\": 3, \"status\": false\n" +
            ",\"contentUrl\":\"xxx\",\"sizePage\":\"2\" } ]                 contentUrl：文件内容     sizePage：页数大小    collectionUserId：收藏人用户信息  shareId:分享表id   collectionImage 来源人头像  collectionName  来源人名称 fileSize  文件大小（单位兆） ")
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
    /**
     * 定时修改收藏有效期天数（86400000毫秒 = 1天）
     */
    @Scheduled(fixedDelay = 86400000)
    public void updateCollectionPeriodOfValidity(){
        // 更新有效期
        Integer updateCollectionEffectiveTime = collectionService.updateCollectionEffectiveTime();
        logger.info("开始定时修改收藏有效期个数======================================================================");
        logger.info("定时修改收藏有效期个数========================"+updateCollectionEffectiveTime.toString()+"个");
        logger.info("完成定时修改收藏有效期个数======================================================================");

    }


}
