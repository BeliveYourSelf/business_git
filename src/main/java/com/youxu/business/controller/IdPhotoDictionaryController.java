package com.youxu.business.controller;

import com.youxu.business.pojo.IdPhotoDictionary;
import com.youxu.business.service.IdPhotoDictionaryService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@Api(description = "证件照规格字典表")
@RestController
@RequestMapping("/api")
public class IdPhotoDictionaryController {

    @Resource
    private IdPhotoDictionaryService idPhotoDictionaryService;

    @ApiOperation(value = "模糊查看证件照规格", notes = "")
    @GetMapping("/selectIdPhotoDictionaryListByName")
    public ResponseMessage<List<IdPhotoDictionary>> selectIdPhotoDictionaryListByName(@RequestParam String idPhotoDictionaryName, @RequestParam String storeId) {
        List<IdPhotoDictionary> IdPhotoDictionaryList =idPhotoDictionaryService.selectIdPhotoDictionaryListByName(idPhotoDictionaryName, storeId);
        if (IdPhotoDictionaryList.size()<=0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "无此规格证件照");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",IdPhotoDictionaryList);
    }
}
