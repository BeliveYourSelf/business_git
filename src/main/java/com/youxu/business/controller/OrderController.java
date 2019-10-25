package com.youxu.business.controller;

import com.youxu.business.pojo.Order;
import com.youxu.business.service.OrderService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import com.youxu.business.utils.uuid.UUIDUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Api(description = "订单表")
@RequestMapping("/api")
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @ApiOperation(value = "新增订单", notes = "{ \"orderActualMoney\": \"100\" , \"orderAddresseeAddress\": \"天津市立晟科技\" , \"orderAddresseeName\": \"李文轩\" , \"orderAddresseePhone\": \"13652157270\" , \"orderConsumeMoney\": 10 , \"orderCouponMoney\": 10 , \"orderDeliveryMoney\": \"10\" , \"orderDeliveryPrescriptioTime\": \"60\" , \"orderDetailsList\": [ { \"orderDetailsCount\": 10 ,\"orderDetailsName\":\"文档打印pdf\" ,\"orderDetailsOnePictureUrl\":\"xxxx\" ,\"orderDetailsTotalPrice\":\"200\" ,\"orderSpecName\":\"一寸6合一横板\" ,\"orderDetailsCountColour\":\"10\" ,\"pictureUrlList\":[ \"string1\" ,\"string2\" ] ,\"orderDetailsBookBinding\": { \"coverColor\": \"黑色\", \"coverFileUrl\": \"xxx\", \"faceDirection\": \"横向\"\n" +
            "\n" +
            "} } ] , \"orderExtraMoney\": 10 , \"orderFromStoreGet\": \"3\" , \"orderFromStoreGetWhere\": \"天津工业大学1号宿舍楼\" , \"orderPrintMoney\": \"10\" , \"orderProcess\": 1 , \"orderType\": 1 , \"storeId\": 1 , \"userId\": 1 , \"orderRemark\":\"帮我装订好哦\" ,\"shareId\":\"1\",\n" +
            " \"vouchersIdList\":[\n" +
            "        \"1\",\n" +
            "        \"2\"\n" +
            "    ]}        vouchersIdList：优惠券id   ")
    @PostMapping("/insertOrder")
    public ResponseMessage<Integer> insertOrder(@RequestBody Order order) {
        Integer orderId = null;
        try {
            orderId = orderService.insertOrder(order);
        } catch (Exception e) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "新增失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功",orderId);
    }

    /**
     * 催单/确认收件-----------------------------------
     */
    @ApiOperation(value = "催单/确认收件", notes = "{\"id\":\"1\"\n" +
            ",\"orderProcess\":\"2\"}")
    @PostMapping("/reminderOrder")
    public ResponseMessage<Integer> reminderOrder(@RequestBody Order order) {
        Integer reminderOrder = orderService.reminderOrder(order);
        if (reminderOrder <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }

    /**
     * 取消订单
     */
    @ApiOperation(value = "取消订单", notes = "{\"id\":\"1\"}")
    @GetMapping("/cancleOrder")
    public ResponseMessage<Integer> cancelOrder(@RequestParam String id) {
        Integer cancelOrder = orderService.cancelOrder(id);
        if (cancelOrder <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }

    /**
     * 删除订单
     */
    @ApiOperation(value = "删除订单", notes = "{\"id\":\"1\"}")
    @GetMapping("/deleteOrder")
    public ResponseMessage<Integer> deleteOrder(@RequestParam String id) {
        Integer cancelOrder = orderService.deleteOrder(id);
        if (cancelOrder <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }

    /**
     * 更新订单
     */
    @ApiOperation(value = "更新订单", notes = "{\"id\":\"1\", \"orderActualMoney\": \"100\", \"orderAddresseeAddress\": \"天津市立晟科技\", \"orderAddresseeName\": \"李文轩1\", \"orderAddresseePhone\": \"13652157270\", \"orderConsumeMoney\": 10, \"orderCouponMoney\": 10, \"orderDeliveryMoney\": \"10\", \"orderDeliveryPrescriptioTime\": \"60\", \"orderDetailsList\": [ { \"orderDetailsCount\": 10,\n" +
            "\n" +
            "  \"orderDetailsName\": \"一寸白底\",\n" +
            "  \"orderDetailsOnePictureUrl\": \"/dishesPicture/20190611/app小程序制作.png\",\n" +
            "  \"orderDetailsTotalPrice\": 10,\n" +
            "  \"orderDetailsTypesettingPictureUrl\": \"/dishesPicture/20190611/app小程序制作.png\",\n" +
            "  \"orderId\": 1,\n" +
            "  \"orderSpecName\":\"一寸白底-横板-六合一\",\n" +
            "  \"orderDetailsCountColour\":\"10\"\n" +
            "}\n" +
            "], \"orderExtraMoney\": 10, \"orderFromStoreGet\": \"3\", \"orderFromStoreGetWhere\": \"天津工业大学1号宿舍楼\", \"orderPrintMoney\": \"10\", \"orderProcess\": 1, \"orderType\": 1, \"storeId\": 1, \"userId\": 1 }")
    @PostMapping("/updateOrder")
    public ResponseMessage<Integer> updateOrder(@RequestBody Order order) {
        Integer updateOrder = orderService.updateOrder(order);
        if (updateOrder <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功");
    }

    @ApiOperation(value = "重新下单/再次下单", notes = "id 订单id")
    @GetMapping("/insertOrderAgain")
    public ResponseMessage<Integer> insertOrderAgain(@RequestParam String id) {
        Order insertOrderAgain = orderService.insertOrderAgain(id);
        Integer insertOrder = null;
        try {
            insertOrderAgain.setOrderProcess(1);
            insertOrder = orderService.insertOrder(insertOrderAgain);
            Integer orderId = orderService.lastInsertId();
            // 更新取件二维码和收获码
            Integer integer = orderService.updateOrderOverWrite(orderId);
        } catch (Exception e) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        if (insertOrder <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功",insertOrder);
    }




    @ApiOperation(value = "查看订单打印列表", notes = "{\"pageNo\":\"1\" ,\"pageSize\":\"1\" ,\"orderProcess\":\"1\"\n" +
            ",\"userId\":\"1\"}         orderProcess：订单进行状态:1.待付款2.进行中3.已完成4.已取消")
    @PostMapping("/selectOrderList")
    public ResponseMessage<List<Order>> selectOrderList(@RequestBody Order order) {
        List<Order> selectOrderList = orderService.selectOrderList(order);
        if (selectOrderList.size() <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功",selectOrderList);
    }

    @ApiOperation(value = "查看订单详情", notes = "id：订单id")
    @GetMapping("/selectOrderById")
    public ResponseMessage<Order> selectOrderById(@RequestParam String id) {
        Order selectOrderById = orderService.selectOrderById(id);
        if (org.springframework.util.StringUtils.isEmpty(selectOrderById)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功",selectOrderById);
    }

    @ApiOperation(value = "批量下载文件到本地重写新", notes = "{\n" +
            "  \"fileUrlList\": [\n" +
            "    \"https://youxu-print.oss-cn-beijing.aliyuncs.com/log/20190929/1569720759130.pdf\"\n" +
            ",\"https://youxu-print.oss-cn-beijing.aliyuncs.com/log/20190929/1569724765061.pdf\"\n" +
            "  ],\n" +
            "  \"localFilePath\": \"C:\\\\Users\\\\Dell\\\\Desktop\"\n" +
            "}")
    @GetMapping("/downLoadFileListOverWriteNew")
    public ResponseMessage<HttpServletResponse> downLoadFileListOverWriteNew(@RequestParam String orderId, HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpServletResponse httpServletResponse = orderService.downLoadFileListOverWriteNew(orderId, request, response);
            return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功",httpServletResponse);
        }
        catch(Exception e){
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), "失败");
        }
    }


}
