package com.youxu.business.controller;

import com.youxu.business.pojo.ProblemFileMarkDictionary;
import com.youxu.business.service.ProblemFileMarkDictionaryService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "问题单标注字典表")
@RequestMapping("/api")
@RestController
public class ProblemFileMarkDictionaryController {
    @Resource
    private ProblemFileMarkDictionaryService problemFileMarkDictionaryService;

    @ApiOperation(value = "查看问题单标注集合", notes = "storeId")
    @GetMapping("/selectProblemFileMarkDictionary")
    public ResponseMessage<List<ProblemFileMarkDictionary>> selectProblemFileMarkDictionary(@RequestParam String storeId) {
        List<ProblemFileMarkDictionary> selectProblemFileMarkDictionaryList =problemFileMarkDictionaryService.selectProblemFileMarkDictionary(storeId);
        if (selectProblemFileMarkDictionaryList.size() <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "暂无计费规则");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",selectProblemFileMarkDictionaryList);
    }
}
