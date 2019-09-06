package com.youxu.business.controller;

import com.youxu.business.pojo.Harvest;
import com.youxu.business.pojo.IdPhotoDictionary;
import com.youxu.business.service.HarvestService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(description = "收货地址")
@RequestMapping("/api")
public class HarvestController {
    @Resource
    private HarvestService harvestService;

    @ApiOperation(value = "新增收获地址", notes = "{\"userId\":\"1\",\n" +
            "\"harvestAddressName\":\"李文轩\",\n" +
            "\"harvestAddressMobilePhone\":\"13652157270\"\n" +
            ",\"harvestAddressReceivingAddress\":\"天津市宁河区宁河镇\",\n" +
            "\"distributionCategory\":\"1\"}   distributionCategory:配送类别：1.及时配送  2.快递配送")
    @PostMapping("/insertHarvestAddress")
    public ResponseMessage insertHarvestAddress(@RequestBody Harvest harvest) {
        Integer insertHarvestAddress= harvestService.insertHarvestAddress(harvest);
        if (insertHarvestAddress<=0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "新增失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功");
    }

}
