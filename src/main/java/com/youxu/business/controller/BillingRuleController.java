package com.youxu.business.controller;

import com.youxu.business.pojo.BillingRule;
import com.youxu.business.service.BillingRuleService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
@Api(description = "计费规则")
public class BillingRuleController {
    @Resource
    private BillingRuleService billingRuleService;

    @ApiOperation(value = "查看计费规则", notes = "")
    @GetMapping("/selectBillingRuleController")
    public ResponseMessage<BillingRule> selectBillingRuleController() {

        BillingRule billingRule =billingRuleService.selectBillingRule();
        if (StringUtils.isEmpty(billingRule)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "暂无计费规则");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",billingRule);
    }
}
