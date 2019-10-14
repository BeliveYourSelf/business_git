package com.youxu.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.youxu.business.dao.*;
import com.youxu.business.pojo.*;
import com.youxu.business.service.OrderService;
import com.youxu.business.utils.OtherUtil.OSSUploadUtil;
import com.youxu.business.utils.OtherUtil.UploadUtils;
import com.youxu.business.utils.normalQRcode.QRCodeUtil;
import com.youxu.business.utils.uuid.UUIDUtils;
import org.apache.http.entity.ContentType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderDetailsMapper orderDetailsMapper;
    @Resource
    private OrderDetailsBookBindingMapper orderDetailsBookBindingMapper;
    @Resource
    private OrderDetailsPictureMappingMapper orderDetailsPictureMappingMapper;
    @Resource
    private PictureMapper pictureMapper;
    @Resource
    private DeliveryClerkInfoMapper deliveryClerkInfoMapper;
    @Resource
    private StoreMapper storeMapper;
    @Override
    public Integer insertOrder(Order order) throws Exception {
        // 邀请码
        String shareCode = UUIDUtils.generateShortUuid();
        order.setDeliveryHarvestCode(shareCode);
        // 配送时间分改为毫秒
        String orderDeliveryPrescriptioTime = order.getOrderDeliveryPrescriptioTime();
        Long orderDeliveryPrescriptioTimeInteger = Long.valueOf(orderDeliveryPrescriptioTime);
        Long orderTimeLong = orderDeliveryPrescriptioTimeInteger * 60000;
        order.setOrderDeliveryPrescriptioTime(orderTimeLong.toString());
        Integer insertOrder = orderMapper.insertOrder(order);
        int orderId = orderMapper.lastInsertId();
        // 取件码url
        addDeliveryPickUpFileQRCodeUrl(orderId);
        if (!StringUtils.isEmpty(order)) {
            List<OrderDetails> orderDetailsList = order.getOrderDetailsList();
            for (OrderDetails orderDetails : orderDetailsList) {
                orderDetails.setOrderId(orderId);
            }
            if (orderDetailsList.size() > 0) {
                Integer insertOrderDetails = orderDetailsMapper.insertOrderDetails(orderDetailsList);
                int orderDetailsId = orderMapper.lastInsertId();
                for (int i = 1; orderDetailsList.size() >= i; i++) {
                    OrderDetailsBookBinding orderDetailsBookBinding = orderDetailsList.get(i - 1).getOrderDetailsBookBinding();
                    if (!StringUtils.isEmpty(orderDetailsBookBinding)) {
                        orderDetailsBookBinding.setOrderDetailsId(orderDetailsId + i - 1);//绑定订单明细和装订一对一关系
                        orderDetailsBookBindingMapper.insertOrderDetailsBookBinding(orderDetailsBookBinding);
                        int orderDetailsBookBindingId = orderMapper.lastInsertId();
                        List<String> pictureUrlList = orderDetailsList.get(i - 1).getPictureUrlList();
                        pictureMapper.insertPictureMapper(pictureUrlList);
                        int pictureFirstId = orderMapper.lastInsertId();
                        int size = pictureUrlList.size();
                        List<Integer> pictureIdList = new ArrayList<>();
                        for (int j = 1; size >= j; j++) {
                            pictureIdList.add(pictureFirstId + j - 1);
                        }
                        orderDetailsPictureMappingMapper.insertOrderDetailsPictrueMapping(orderDetailsBookBindingId, pictureIdList);

                    }
                }
            }

        }
        return orderId;
    }

    public void addDeliveryPickUpFileQRCodeUrl(Integer orderId) throws Exception {
        Order order = orderMapper.selectOrderById(orderId.toString());
        // 存放上传图片的文件夹
        File fileDir = UploadUtils.getImgDirFileCeshi(UploadUtils.IMG_PATH_PREFIX_QRcodeCeshi);

        // 存放在二维码中的内容
        String text = orderId.toString();

        // 嵌入二维码的图片路径
//            String imgPath = fileDir.getAbsolutePath() + File.separator + filename + ".png";
        String imgPath = null;
        // 生成的二维码的路径及名称
        String destPath = fileDir.getAbsolutePath() + File.separator + text + ".png";
        //生成二维码
        QRCodeUtil.encode(text, imgPath, destPath, true);
        //PDFUtils.createPDF417(text, destPath);
        MultipartFile multipartFileQRCode = fileTransToMultipartFile(destPath);
        String uploadBlog = OSSUploadUtil.uploadBlog(multipartFileQRCode, "barcode/");
        order.setDeliveryPickUpFileQRCodeUrl(uploadBlog);
        orderMapper.updateOrder(order);
    }

    public static MultipartFile fileTransToMultipartFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("copy" + file.getName(), file.getName(), ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
        return multipartFile;
    }

    @Override
    public Integer reminderOrder(Order order) {
        Integer id = order.getId();
        Integer orderProcess = order.getOrderProcess();
        Integer reminderOrder = orderMapper.reminderOrder(id, orderProcess);
        return reminderOrder;
    }

    @Override
    public Integer cancelOrder(String id) {
        return orderMapper.cancelOrder(id);
    }

    @Override
    public Integer updateOrder(Order order) {
        // 更新订单表
        Integer updateOrder = orderMapper.updateOrder(order);
        Integer id = order.getId();
        // 删除订单明细表
        Integer deleteOrderDetailsList = orderDetailsMapper.deleteOrderDetailsList(id);
        // 新增订单明细表
        List<OrderDetails> orderDetailsList = order.getOrderDetailsList();
        Integer insertOrderDetails = orderDetailsMapper.insertOrderDetails(orderDetailsList);
        return updateOrder;
    }

    @Override
    public Order insertOrderAgain(String id) {
        Order order = orderMapper.selectOrderById(id);
        return order;
    }

    @Override
    public List<Order> selectOrderList(Order order) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(order.getPageNo(), order.getPageSize());
        return orderMapper.selectOrderList(order);
    }

    @Override
    public Integer updateOrderPayDateAndProcess(Integer orderId, Integer orderProcess) {
        return orderMapper.updateOrderPayDateAndProcess(orderId, orderProcess);
    }

    @Override
    public List<Order> selectDeliveryFileByStoreIdList(Order order) {
        List<Order> orders = orderMapper.selectDeliveryFileByStoreIdList(order);
        for(Order orderNew:orders){
            String orderDeliveryPrescriptioTime = orderNew.getOrderDeliveryPrescriptioTime();
            // 配送时间 mm
            Long orderDeliveryPrescriptioTimeLong = Long.valueOf(orderDeliveryPrescriptioTime);
            Date orderPayDate = orderNew.getOrderPayDate();
            // 支付时间 mm
            if(!StringUtils.isEmpty(orderPayDate)){
                Long orderPayDateLong = orderPayDate.getTime();
                Long expireTime = orderDeliveryPrescriptioTimeLong+orderPayDateLong;
                orderNew.setExpireTime(expireTime.toString());
            }
        }
        return orders;
    }

    @Override
    public Order selectDeliveryFileByOrderId(String orderId) {
        return orderMapper.selectDeliveryFileByOrderId(orderId);
    }

    @Override
    public Integer updateOrderToPickUp(Order order) {
        return orderMapper.updateOrderToPickUp(order);
    }

    @Override
    public Integer updateDeliveryInfoToCompelete(Order order) {
        Order orderNew = orderMapper.selectOrderById(order.getId().toString());
        String deliveryHarvestCode = orderNew.getDeliveryHarvestCode();
        if (!deliveryHarvestCode.equals(order.getDeliveryHarvestCode())) {
            return -1;
        }
        // 配送员：配送数+1，配送收益增加
        // 查看该店铺的配送价格信息
        Integer storeId = orderNew.getStoreId();
        Store store = storeMapper.selectByStoreId(storeId);
        Integer deliveryId = orderNew.getDeliveryId();
        DeliveryClerkInfo deliveryClerkInfo = deliveryClerkInfoMapper.selectDeliveryClerkInfoById(deliveryId.toString());
        deliveryClerkInfo.setCumulativeDeliveryThisMonth(deliveryClerkInfo.getCumulativeDeliveryThisMonth() + 1);// 本月单数+1
        deliveryClerkInfo.setCumulativeIncome(deliveryClerkInfo.getCumulativeIncome() + store.getDeliveryclerkPricePerOne());// 本月收入
        deliveryClerkInfoMapper.updateDeliveryClerkInfo(deliveryClerkInfo)
        return orderMapper.updateDeliveryInfoToCompelete(order);
    }

    @Override
    public Integer updateDeliveryOrderProblem(Order order) {
        // 第一次评价
        Order orderNew = orderMapper.selectOrderById(order.getId().toString());
        String deliveryProblemFileMark = orderNew.getDeliveryProblemFileMark();
        if(StringUtils.isEmpty(deliveryProblemFileMark)){
            return orderMapper.updateDeliveryOrderProblem(order);
        }
        // 追加评价
        StringBuffer deliveryProblemFileMarkStringBuffer = new StringBuffer(deliveryProblemFileMark);
        deliveryProblemFileMarkStringBuffer.append("#").append(order.getDeliveryProblemFileMark());
        order.setDeliveryProblemFileMark(deliveryProblemFileMarkStringBuffer.toString());
        return orderMapper.updateDeliveryOrderProblem(order);
    }

    @Override
    public Integer insertOrderForMemberPrice(Share share) {
        Order orderNew = share.getOrder();
        return orderMapper.insertOrderForShareMemberPrice(orderNew);
    }

    @Override
    public Integer lastInsertId() {
        return orderMapper.lastInsertId();
    }

    @Override
    public Integer updateOrderCompelete(Integer orderId) {
        return orderMapper.updateOrderCompelete(orderId);
    }

    @Override
    public Integer deleteOrder(String id) {
        return orderMapper.deleteOrder(id);
    }

    @Override
    public Order selectOrderById(String id) {
        return orderMapper.selectOrderById(id);
    }


}
