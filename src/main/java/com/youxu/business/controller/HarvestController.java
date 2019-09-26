package com.youxu.business.controller;

import com.youxu.business.pojo.Harvest;
import com.youxu.business.pojo.IdPhotoDictionary;
import com.youxu.business.service.HarvestService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(description = "收货地址")
@RequestMapping("/api")
public class HarvestController {
    @Resource
    private HarvestService harvestService;

    @ApiOperation(value = "新增收获地址", notes = "{\"userId\":\"1\"\n" +
            ", \"harvestAddressName\":\"李文轩\"\n" +
            ", \"harvestAddressMobilePhone\":\"13652157270\"\n" +
            " ,\"harvestAddressReceivingAddress\":\"天津市宁河区宁河镇\"\n" +
            ",\"addtionalName\":\"陈凯\"\n" +
            ",\"additionalMobilePhone\":\"13802132525\"\n" +
            ",\"cityRegion\":\"天津市西青区\"\n" +
            ",\"serviceScope\":\"天津工业大学\"\n" +
            ",\"addtionalInfo\":\"教学楼A楼\"\n" +
            ", \"distributionCategory\":\"1\"}  addtionalName:备用人姓名  additionalMobilePhone：备用人联系电话  cityRegion：城市/区域  serviceScope：服务范围 addtionalInfo：备注信息 distributionCategory:配送类别：1.及时配送  2.快递配送")
    @PostMapping("/insertHarvestAddress")
    public ResponseMessage insertHarvestAddress(@RequestBody Harvest harvest) {
        Integer insertHarvestAddress= harvestService.insertHarvestAddress(harvest);
        if (insertHarvestAddress<=0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "新增失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功");
    }

    @ApiOperation(value = "编辑收获地址", notes = "{\"id\":\"1\",\n" +
            "\"userId\":\"2\",\n" +
            "\"harvestAddressName\":\"陈凯\",\n" +
            "\"harvestAddressMobilePhone\":\"13685214125\"\n" +
            ",\"harvestAddressReceivingAddress\":\"天津市中北镇\",\n" +
            "\"distributionCategory\":\"2\"}}   distributionCategory:配送类别：1.及时配送  2.快递配送")
    @PostMapping("/updateHarvestAddress")
    public ResponseMessage updateHarvestAddress(@RequestBody Harvest harvest) {
        Integer updateHarvestAddress= harvestService.updateHarvestAddress(harvest);
        if (updateHarvestAddress<=0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "编辑失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功");
    }

    @ApiOperation(value = "删除收获地址", notes = "{\"id\":\"1\"\n" +
            ",\"harvestAddressStatus\":\"true\"}")
    @PostMapping("/deleteHarvestAddress")
    public ResponseMessage deleteHarvestAddress(@RequestBody Harvest harvest) {
        Integer deleteHarvestAddress= harvestService.updateHarvestAddress(harvest);
        if (deleteHarvestAddress<=0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "删除失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功");
    }

    @ApiOperation(value = "查看一个收获地址", notes = "")
    @GetMapping("/selectOneHarvestAddress")
    public ResponseMessage<Harvest> selectOneHarvestAddress(@RequestParam String id) {
        Harvest selectOneHarvestAddress= harvestService.selectOneHarvestAddress(id);
        if (StringUtils.isEmpty(selectOneHarvestAddress)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "暂无收获地址");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",selectOneHarvestAddress);
    }

    @ApiOperation(value = "查看收获地址列表", notes = "{\"userId\":\"2\" ,\"distributionCategory\":\"1\"}    distributionCategory:配送类别：1.及时配送  2.快递配送")
    @PostMapping("/selectHarvestAddressList")
    public ResponseMessage<List<Harvest>> selectHarvestAddressList(@RequestBody Harvest harvest) {
        List<Harvest> selectHarvestAddressList= harvestService.selectHarvestAddressList(harvest);
        if (StringUtils.isEmpty(selectHarvestAddressList)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "暂无收获地址");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(),"成功",selectHarvestAddressList);
    }

}
