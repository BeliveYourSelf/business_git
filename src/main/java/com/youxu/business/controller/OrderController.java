package com.youxu.business.controller;

import com.youxu.business.pojo.Order;
import com.youxu.business.pojo.OrderDetails;
import com.youxu.business.pojo.OrderProcess;
import com.youxu.business.pojo.idphotonewadd.FileNameFather;
import com.youxu.business.service.IdPhotoBusinessService;
import com.youxu.business.service.OrderService;
import com.youxu.business.utils.Enum.ResultCodeEnum;
import com.youxu.business.utils.ResponseUtil.ResponseMessage;
import com.youxu.business.utils.ResponseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Api(description = "订单表")
@RequestMapping("/api")
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @Resource
    private IdPhotoBusinessService idPhotoBusinessService;

    @ApiOperation(value = "新增订单", notes = "{\"orderCouponMoney\":0,\"orderCouponDeliveryMoney\":0,\"orderDeliveryMoney\":2,\"userId\":20,\"orderType\":3,\"orderProcess\":1,\"orderFromStoreGet\":3,\"orderPrintMoney\":0,\"orderConsumeMoney\":0,\"vouchersIdList\":[],\"orderTypeOther\":1,\"orderAllPage\":90,\"orderAddresseeAddress\":\"天津市天津市华木里8-1-501\",\"orderAddresseeName\":\"古井\",\"orderAddresseePhone\":\"16600205437\",\"storeId\":1,\"orderDeliveryPrescriptioTime\":\"92\",\"orderActualMoney\":2,\"orderDetailsList\":[{\"orderDetailsCount\":1,\"orderDetailsName\":\"woshipdf.pdf\",\"orderDetailsOnePictureUrl\":\"https://youxu-print.oss-cn-beijing.aliyuncs.com/log/20191120/1574218255499/woshipdf.pdf\",\"orderDetailsTotalPrice\":0,\"orderSpecName\":\"A3/默认（无拼版）/单面/竖版\",\"orderDetailsCountColour\":0,\"orderDetailsType\":4,\"orderDetailsPage\":\"1\"},{\"orderDetailsCount\":1,\"orderDetailsName\":\"推荐二维码.png\",\"orderDetailsOnePictureUrl\":\"https://youxu-print.oss-cn-beijing.aliyuncs.com/log/20191024/1571898056220/推荐二维码.png\",\"orderDetailsTotalPrice\":0,\"orderSpecName\":\"A3/默认（无拼版）/单面/竖版\",\"orderDetailsCountColour\":0,\"orderDetailsType\":4,\"orderDetailsPage\":1},{\"orderDetailsCount\":1,\"orderDetailsName\":\"项目计划表.xlsx\",\"orderDetailsOnePictureUrl\":\"https://youxu-print.oss-cn-beijing.aliyuncs.com/log/20191205/1575532820764/项目计划表.xlsx\",\"orderDetailsTotalPrice\":0,\"orderSpecName\":\"A3/默认（无拼版）/单面/竖版\",\"orderDetailsCountColour\":0,\"orderDetailsType\":4,\"orderDetailsPage\":\"1\"},{\"orderDetailsCount\":1,\"orderDetailsName\":\"选题PPT.pptx\",\"orderDetailsOnePictureUrl\":\"https://youxu-print.oss-cn-beijing.aliyuncs.com/log/20191205/1575533477542/选题PPT.pptx\",\"orderDetailsTotalPrice\":0,\"orderSpecName\":\"A3/默认（无拼版）/单面/竖版\",\"orderDetailsCountColour\":0,\"orderDetailsType\":4,\"orderDetailsPage\":29},{\"orderDetailsCount\":1,\"orderDetailsName\":\"装订1\",\"orderSpecName\":\"A3-默认（无拼版）-单面-竖版 58P\",\"orderDetailsCountColour\":0,\"orderDetailsType\":3,\"orderDetailsPage\":58,\"orderDetailsBookBinding\":{\"coverColor\":\"皮纹纸/淡蓝色\",\"coverFileUrl\":null,\"faceDirection\":\"竖版\"},\"pictureList\":[{\"pictureUrl\":\"https://youxu-print.oss-cn-beijing.aliyuncs.com/log/20191205/1575533710029/选题PPT.pptx\",\"pictureUrlPdf\":\"https://youxu-print.oss-cn-beijing.aliyuncs.com/log/20191205/1575533710029/选题PPT.pptx\"},{\"pictureUrl\":\"https://youxu-print.oss-cn-beijing.aliyuncs.com/log/20191205/1575533710029/选题PPT.pptx\",\"pictureUrlPdf\":\"https://youxu-print.oss-cn-beijing.aliyuncs.com/log/20191205/1575533710029/选题PPT.pptx\"}]}],\"orderCategory\":\"1\"}   新字段：orderDetailsOnePictureUrlPdf：订单详情Pdf路径,pictureUrl发生变化")
    @PostMapping("/insertOrder")
    public ResponseMessage<Integer> insertOrder(@RequestBody Order order, HttpServletRequest request, HttpServletResponse response) {
        Integer orderId = null;
        try {
            // 更换证件照路径为oss
            List<OrderDetails> orderDetailsOssPathByIdPhoto = getOssPathByIdPhoto(order.getOrderDetailsList(), request, response);
            order.setOrderDetailsList(orderDetailsOssPathByIdPhoto);
            orderId = orderService.insertOrder(order);
        } catch (Exception e) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "新增失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", orderId);
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
        Integer orderId = null;
        try {
            // 重新计算价格
            List<Integer> integerList = new ArrayList();
            integerList.add(0);
            insertOrderAgain.setOrderProcess(1);
            insertOrderAgain.setOrderDeliveryPrescriptioTime("5");// 重新下单时效5分钟
            insertOrderAgain.setVouchersIdList(null);// 优惠券置为空
            insertOrderAgain.setOrderCouponMoneyId(0);// 优惠券id（代金券）
            insertOrderAgain.setOrderConsumeMoney(0.0);// 优惠券为null
            insertOrderAgain.setOrderCouponDeliveryId(0);// 配送券id
            insertOrderAgain.setOrderCouponDeliveryMoney(0);// 配送券价格
            Double orderConsumeMoney = insertOrderAgain.getOrderConsumeMoney();
            Integer orderCouponDeliveryMoney = insertOrderAgain.getOrderCouponDeliveryMoney();
            Double orderActualMoney = insertOrderAgain.getOrderActualMoney();
            double actualMoney = orderActualMoney + (orderConsumeMoney == null ? 0 : orderConsumeMoney) + (orderCouponDeliveryMoney == null ? 0 : orderCouponDeliveryMoney);
            insertOrderAgain.setOrderActualMoney(actualMoney);
            orderId = orderService.insertOrder(insertOrderAgain);
            // 更新取件二维码和收获码
            Integer integer = orderService.updateOrderOverWrite(orderId);
        } catch (Exception e) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        if (orderId <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", orderId);
    }


    @ApiOperation(value = "查看订单打印列表", notes = "{\"pageNo\":\"1\" ,\"pageSize\":\"1\" ,\"orderProcess\":\"1\"\n" +
            ",\"userId\":\"1\"}         orderProcess：订单进行状态:1.待付款2.进行中3.已完成4.已取消")
    @PostMapping("/selectOrderList")
    public ResponseMessage<List<Order>> selectOrderList(@RequestBody Order order) {
        List<Order> selectOrderList = null;
        try {
            selectOrderList = orderService.selectOrderList(order);
        } catch (Exception e) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "暂无列表");
        }
        if (selectOrderList.size() <= 0) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "暂无列表");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", selectOrderList);
    }

    @ApiOperation(value = "查看订单详情", notes = "id：订单id")
    @GetMapping("/selectOrderById")
    public ResponseMessage<Order> selectOrderById(@RequestParam String id) {
        Order selectOrderById = orderService.selectOrderById(id);
        if (org.springframework.util.StringUtils.isEmpty(selectOrderById)) {
            return Result.error(ResultCodeEnum.NODATA_CODE.getValueCode(), "失败");
        }
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", selectOrderById);
    }

    @ApiOperation(value = "批量下载文件到本地重写新", notes = "")
    @GetMapping("/downLoadFileListOverWriteNew")
    public ResponseMessage<List<String>> downLoadFileListOverWriteNew(@RequestParam String orderId) {
        try {
            List<String> pathList = orderService.downLoadFileListOverWriteNew(orderId);
            return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", pathList);
        } catch (Exception e) {
            return Result.error(ResultCodeEnum.ERROE_CODE.getValueCode(), "失败");
        }
    }

    @ApiOperation(value = "查看订单类别个数", notes = "userId：用户id")
    @GetMapping("/selectCountOrderProcess")
    public ResponseMessage<OrderProcess> selectCountOrderProcess(@RequestParam String userId) {
        OrderProcess orderProcess = orderService.selectCountOrderProcess(userId);
        return Result.success(ResultCodeEnum.SUCCESS_CODE.getValueCode(), "成功", orderProcess);
    }

    /**
     * 判断时候为证件照，如果为证件照，则把证件照第三方的路径换成oss（第三方服务器上两小时图片时效）
     */
    private List<OrderDetails> getOssPathByIdPhoto(List<OrderDetails> orderDetailsList, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!StringUtils.isEmpty(orderDetailsList) && orderDetailsList.size() > 0) {
            for (OrderDetails orderDetailListOne : orderDetailsList) {
                String orderDetailsOnePictureUrl = orderDetailListOne.getOrderDetailsOnePictureUrl();
                if(!StringUtils.isEmpty(orderDetailsOnePictureUrl)){
                boolean contains = orderDetailsOnePictureUrl.contains("leqi-imgcall.oss-cn-shanghai.aliyuncs.com"); // 证件照官网路径
                if (contains) {
                    FileNameFather fileNameFather = new FileNameFather();
                    fileNameFather.setFilePath(orderDetailsOnePictureUrl);
                    fileNameFather.setFileName(orderDetailListOne.getOrderDetailsName() + ".jpg");
                    String getOssPathByFilePath = idPhotoBusinessService.getOssPathByFilePath(fileNameFather, request, response);
                    orderDetailListOne.setOrderDetailsOnePictureUrl(getOssPathByFilePath);
                }
                }
            }
        }
        return orderDetailsList;
    }

}
