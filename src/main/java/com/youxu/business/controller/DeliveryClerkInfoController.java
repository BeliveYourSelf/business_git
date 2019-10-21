package com.youxu.business.controller;

import com.youxu.business.pojo.DeliveryClerkInfo;
import com.youxu.business.pojo.IdPhotoBusiness;
import com.youxu.business.pojo.Order;
import com.youxu.business.service.DeliveryClerkInfoService;
import com.youxu.business.service.OrderService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.Enum.SendSmsTemplateCodeEnum;
import com.youxu.business.utils.OtherUtil.ImageSizeTool;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import com.youxu.business.utils.baiducloud.facerecognition.PersonVerify;
import com.youxu.business.utils.baiducloud.facerecognition.baiducloudutil.ResultObject;
import com.youxu.business.utils.wechat.requestapitool.CommonRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Random;

@RequestMapping("/api")
@Api(description = "配送员信息表")
@RestController
public class DeliveryClerkInfoController {
    @Resource
    private DeliveryClerkInfoService deliveryClerkInfoService;
    @Resource
    private OrderService orderService;


    @ApiOperation(value = "新增配送员信息", notes = "{ \"deliveryClerkName\": \"李文轩\", \"deliveryClerkPhone\": \"13652157270\", \"emergencyPerson\": \"老李\", \"emergencyPhone\": \"13652147414\", \"idCardNum\": \"120221199512271411\", \"idCardOtherSize\": \"xxxx\", \"idCardPositive\": \"xxxxx\", \"userId\": 13 ,\"storeIdList\":[1,2]}      具体字段名含义查看swagger中Model")
    @PostMapping("/insertDeliveryClerkInfo")
    public ResponseMessage insertDeliveryClerkInfo(@RequestBody DeliveryClerkInfo deliveryClerkInfo) {
        Integer insertDeliveryClerkInfo = deliveryClerkInfoService.insertDeliveryClerkInfo(deliveryClerkInfo);
        if (insertDeliveryClerkInfo == 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        if (insertDeliveryClerkInfo == -1) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "该用户已申请为配送员，请等待审核");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }

    @ApiOperation(value = "发送验证码", notes = "")
    @GetMapping("/sendCheckCode")
    public ResponseMessage<String> sendCheckCode(@RequestParam String phone) {
        DeliveryClerkInfo deliveryClerkInfo = deliveryClerkInfoService.selectDeliveryClerkInfoByPhone(phone);
        if (!StringUtils.isEmpty(deliveryClerkInfo)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "该手机号已注册配送员");
        }
        String str = new String();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int randomMath = random.nextInt(10);
            str = str + randomMath;
        }
        String commonRpc = CommonRpc.getCommonRpc(phone, "{\"code\":\"" + str + "\"}", SendSmsTemplateCodeEnum.REGISTERDELIVERYCLERK.getTemplateCodeValue());

        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", str);
    }


    @ApiOperation(value = "更新配送员信息", notes = "{\n" +
            "  \"deliveryClerkName\": \"李文轩\",\n" +
            "  \"deliveryClerkPhone\": \"13652157270\",\n" +
            "  \"emergencyPerson\": \"老李\",\n" +
            "  \"emergencyPhone\": \"13652147414\",\n" +
            "  \"idCardNum\": \"120221199512271411\",\n" +
            "  \"idCardOtherSize\": \"xxxx\",\n" +
            "  \"idCardPositive\": \"xxxxx\",\n" +
            "  \"id\": 1\n" +
            "}")
    @PostMapping("/updateDeliveryClerkInfo")
    public ResponseMessage updateDeliveryClerkInfo(@RequestBody DeliveryClerkInfo deliveryClerkInfo) {
        Integer updateDeliveryClerkInfo = deliveryClerkInfoService.updateDeliveryClerkInfo(deliveryClerkInfo);
        if (updateDeliveryClerkInfo <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }

    @ApiOperation(value = "查看快递员信息", notes = "userId   ")
    @GetMapping("/selectDeliveryClerkInfoByUserId")
    public ResponseMessage<DeliveryClerkInfo> selectDeliveryClerkInfoByUserId(@RequestParam String userId) {
        DeliveryClerkInfo deliveryClerkInfo = deliveryClerkInfoService.selectDeliveryClerkInfoByUserId(userId);
        if (StringUtils.isEmpty(deliveryClerkInfo)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "暂无快递员信息");
        }
        Integer auditStatus = deliveryClerkInfo.getAuditStatus();
        if ("0".equals(auditStatus.toString())) {
            return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "待审核");
        } else if ("1".equals(auditStatus.toString())) {
            return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", deliveryClerkInfo);
        }
        return Result.error(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "不通过");
    }


    @ApiOperation(value = "查看待取件/配送中/问题件/已完成", notes = "{\"storeIdList\":[\"1\",\"2\"]\n" +
            ",\"deliveryStatus\":\"1\"\n" +
            ",\"deliveryId\":\"10\"}" +
            "storeIdList:店铺id集合  deliveryStatus： deliveryId：配送人id（注意：查看代取件时此字段什么都不传）deliveryStatus：1.待取件/2.配送中/3.问题件/4.已完成")
    @PostMapping("/selectDeliveryFileByStoreIdList")
    public ResponseMessage<List<Order>> selectDeliveryFileByStoreIdList(@RequestBody Order order) {
        List<Order> selectDeliveryFileByStoreIdList = orderService.selectDeliveryFileByStoreIdList(order);
        if (selectDeliveryFileByStoreIdList.size() <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "暂无快递件");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", selectDeliveryFileByStoreIdList);
    }

    @ApiOperation(value = "待取件详情", notes = "订单id")
    @GetMapping("/selectDeliveryFileByOrderId")
    public ResponseMessage<Order> selectDeliveryFileByOrderId(@RequestParam String orderId) {
        Order selectDeliveryFileByOrderId = orderService.selectDeliveryFileByOrderId(orderId);
        if (StringUtils.isEmpty(selectDeliveryFileByOrderId)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", selectDeliveryFileByOrderId);
    }

    @ApiOperation(value = "取件", notes = "{\"id\":\"1\"\n" +
            ",\"deliveryId\":\"10\"}   id:订单id   deliveryId:配送员id")
    @PostMapping("/updateOrderToPickUp")
    public ResponseMessage updateOrderToPickUp(@RequestBody Order order) {
        Integer updateOrderToPickUp = orderService.updateOrderToPickUp(order);
        if (updateOrderToPickUp <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }

    @ApiOperation(value = "配送员确认完成订单", notes = "{\"id\":\"1\"\n" +
            ",\"deliveryHarvestCode\":\"uGO3\"\n" +
            ",\"deliveryStatus\":\"4\"}   " +
            "   id:订单id   deliveryHarvestCode：收货码             deliveryStatus：配送状态（1.待取件/2.配送中/3.问题件/4.已完成）")
    @PostMapping("/updateDeliveryInfoToCompelete")
    public ResponseMessage updateDeliveryInfoToCompelete(@RequestBody Order order) {
        try {
            Integer updateDeliveryInfoToCompelete = orderService.updateDeliveryInfoToCompelete(order);
            if (updateDeliveryInfoToCompelete == 0) {
                return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
            }
            if (updateDeliveryInfoToCompelete == -1) {
                return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "收获码错误");
            }
            return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
        } catch (Exception e) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "异常错误");
        }
    }

    @ApiOperation(value = "标记问题", notes = "{\"id\":\"1\"\n" +
            ",\"deliveryProblemFileMark\":\"我是评论\"}" +
            "id：订单id  deliveryProblemFileMark：问题件标注 ")
    @PostMapping("/updateDeliveryOrderProblem")
    public ResponseMessage updateDeliveryOrderProblem(@RequestBody Order order) {
        Integer updateDeliveryOrderProblem = orderService.updateDeliveryOrderProblem(order);
        if (updateDeliveryOrderProblem == 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }


    @ApiOperation(value = "百度云人脸识别", notes = "userId image")
    @PostMapping("/baiduCloudFaceRecognition")
    public ResponseMessage baiduCloudFaceRecognition(@RequestBody DeliveryClerkInfo deliveryClerkInfoParam) {
        ResultObject personverify = new ResultObject();
        // 判断不超过两兆
        String image = deliveryClerkInfoParam.getImage();
        Integer twoTrillion = 1 * 1024 * 1024 * 2;
        Integer base64Size = ImageSizeTool.imageSize(image);
        if (base64Size > twoTrillion) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "上传图片不能大于2M");
        }
        DeliveryClerkInfo deliveryClerkInfo = deliveryClerkInfoService.selectDeliveryClerkInfoByUserId(deliveryClerkInfoParam.getUserId().toString());
        // 截取base64前缀
        String imageSubstring = ImageSizeTool.imageSubstring(image);
        deliveryClerkInfo.setImage(imageSubstring);
        // 生成人脸识别评分
        PersonVerify personVerify = new PersonVerify();
        String score = null;
        try {
             personverify = personVerify.personverify(deliveryClerkInfo);
             score = personverify.getResult().getScore();
        } catch (Exception e) {
            return Result.error(personverify.getError_code(),personverify.getError_msg());
        }
        Integer scoreInteger = Double.valueOf(score).intValue();
        deliveryClerkInfo.setScore(scoreInteger);
        Integer updateDeliveryClerkScore = deliveryClerkInfoService.updateDeliveryClerkScore(deliveryClerkInfo);
        if (updateDeliveryClerkScore <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }


}
