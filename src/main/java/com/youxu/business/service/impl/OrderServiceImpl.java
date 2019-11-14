package com.youxu.business.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.youxu.business.dao.*;
import com.youxu.business.pojo.*;
import com.youxu.business.service.OrderService;
import com.youxu.business.utils.OtherUtil.DeleteFileUtil;
import com.youxu.business.utils.OtherUtil.OSSUploadUtil;
import com.youxu.business.utils.OtherUtil.UploadUtils;
import com.youxu.business.utils.normalQRcode.QRCodeUtil;
import com.youxu.business.utils.oss.download.DownLoadZip;
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
import java.util.*;
import java.util.stream.Collectors;

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
        // 收货码
        String shareCode = UUIDUtils.generateShortUuid();
        order.setDeliveryHarvestCode(shareCode);
        // 配送时间分改为毫秒
        String orderDeliveryPrescriptioTime = order.getOrderDeliveryPrescriptioTime();
        if (!StringUtils.isEmpty(orderDeliveryPrescriptioTime)) {
            Long orderDeliveryPrescriptioTimeInteger = Long.valueOf(orderDeliveryPrescriptioTime);
            Long orderTimeLong = orderDeliveryPrescriptioTimeInteger * 60000;// 分变成毫秒
            order.setOrderDeliveryPrescriptioTime(orderTimeLong.toString());
        }
        // 插入优惠券id
        List<Integer> vouchersIdList = order.getVouchersIdList();
        if (!StringUtils.isEmpty(vouchersIdList)) {
            String vouchersIdString = null;
            for (Integer vouchersId : vouchersIdList) {
                if (StringUtils.isEmpty(vouchersIdString)) {
                    vouchersIdString = vouchersId.toString();
                } else {
                    vouchersIdString = vouchersIdString + "," + vouchersId.toString();
                }
            }
            order.setVouchersIds(vouchersIdString);
        }
        Integer insertOrder = orderMapper.insertOrder(order);
        int orderId = orderMapper.lastInsertId();
        // 取件二维码url
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
                        orderDetailsPictureMappingMapper.insertOrderDetailsPictrueMapping(orderDetailsId + i - 1, pictureIdList);

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
        DeleteFileUtil.delete(destPath);
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
        Integer reminderOrder = null;
        Integer id = order.getId();
        Integer orderProcess = order.getOrderProcess();

        if (orderProcess == 2) {
            // 催单
            reminderOrder = orderMapper.reminderOrder(id, orderProcess);
        } else {
            // 确认收件
            reminderOrder = orderMapper.reminderOrderOverWrite(id, orderProcess);
        }
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
    public List<Order> selectOrderList(Order order) throws Exception {
//        DeliveryClerkInfo deliveryClerkInfo = deliveryClerkInfoMapper.selectDeliveryClerkInfoByUserId(order.getUserId().toString());
        List<Order> orderListNew = new ArrayList<>();
//        order.setOrderAssignExpress(deliveryClerkInfo.getTheCategory());
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(order.getPageNo(), order.getPageSize());
        List<Order> orderList = orderMapper.selectOrderListOverWrite(order);
        // 把多个文件路径写到 pictureUrlList中
        for (Order orderOne : orderList) {
            Order orderNew = addMoreUrl(orderOne);
            orderListNew.add(orderNew);
        }
        return orderListNew;
    }

    private Order addMoreUrl(Order order) {
        // 获取装订的多个文件pictureUrl
        List<OrderDetails> orderDetailsList = order.getOrderDetailsList();
        for (OrderDetails orderDetails : orderDetailsList) {
            ArrayList<String> pictureUlrList = new ArrayList<>();
            Integer orderDetalsId = orderDetails.getId();
            List<OrderDetailsPictureMapping> orderDetailsPictureMapping = orderDetailsPictureMappingMapper.selectOrderDetailsPictureMappingByOrderDetailId(orderDetalsId);
            if (!StringUtils.isEmpty(orderDetailsPictureMapping)) {
                for (OrderDetailsPictureMapping orderDetailsPictureMappingNew : orderDetailsPictureMapping) {
                    List<Picture> pictureList = orderDetailsPictureMappingNew.getPictureList();
                    if (!StringUtils.isEmpty(pictureList) && pictureList.size() > 0) {
                        for (Picture picture : pictureList) {
                            pictureUlrList.add(picture.getPictureUrl());
                        }
                        orderDetails.setPictureUrlList(pictureUlrList);
                    }
                }
            }
        }
        order.setOrderDetailsList(orderDetailsList);
        return order;
    }


    @Override
    public Integer updateOrderPayDateAndProcess(Integer orderId, Integer orderProcess) {
        return orderMapper.updateOrderPayDateAndProcess(orderId, orderProcess);
    }

    @Override
    public List<Order> selectDeliveryFileByStoreIdList(Order order) {
        // 查看配送员全职还是兼职（theCategory）
        Integer deliveryId = order.getDeliveryId();
        if (!StringUtils.isEmpty(deliveryId)) {
            DeliveryClerkInfo deliveryClerkInfo = deliveryClerkInfoMapper.selectDeliveryClerkInfoById(deliveryId.toString());
            Integer theCategory = deliveryClerkInfo.getTheCategory();
            if (StringUtils.isEmpty(deliveryClerkInfo) || StringUtils.isEmpty(theCategory)) {
                return null;  //配送员没有分配配送角色（全职/兼职）
            }else if(theCategory ==1){
                theCategory = 3;
            }
            else if (theCategory == 2) {
                theCategory = 4;  //  两个字段之间的关系     theCategory：1.全职/2.兼职 orderAssignExpress:指派快件（0.待指派/1.全部配送员/2特殊指派/3全职配送员/4.兼职配送员/5.顺丰配送）
            }
            order.setTheCategory(theCategory);
        }
        List<Order> orderList = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        if (order.getDeliveryStatus() == 1) {
            // 取件
            orders = orderMapper.selectDeliveryFileByStoreIdListGetFile(order);
        } else {
            // 配送中/问题件/已完成
            orders = orderMapper.selectDeliveryFileByStoreIdList(order);
        }
        // 统计到期时间
        for (Order orderNew : orders) {
            Order order1 = getOrder(orderNew);
            orderList.add(order1);
        }
        return orderList;
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
        deliveryClerkInfoMapper.updateDeliveryClerkInfo(deliveryClerkInfo);
        return orderMapper.updateDeliveryInfoToCompelete(order);
    }

    @Override
    public Integer updateDeliveryOrderProblem(Order order) throws Exception {
        String deliveryProblemFileMarkNew = order.getDeliveryProblemFileMark();
        Order orderNew = orderMapper.selectOrderById(order.getId().toString());
        String deliveryProblemFileMark = orderNew.getDeliveryProblemFileMark();
        // 获取指定格式的当前时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTimeFormat = simpleDateFormat.format(date);
        String mapKey = "deliveryClerk" + "#" + dateTimeFormat;
        // 第一次评价
        if (StringUtils.isEmpty(deliveryProblemFileMark)) {
            HashMap<String, String> problemMark = new HashMap<>();
            problemMark.put(mapKey, deliveryProblemFileMarkNew);
            String problemMarkMapJsonString = JSON.toJSONString(problemMark);
            order.setDeliveryProblemFileMark(problemMarkMapJsonString);
        } else {
            Map<String, String> problemMarkMap = mapStringToMap(deliveryProblemFileMark);
            problemMarkMap.put(mapKey, deliveryProblemFileMarkNew);
            String problemMarkMapJsonString = JSON.toJSONString(problemMarkMap);
            order.setDeliveryProblemFileMark(problemMarkMapJsonString);
        }
        return orderMapper.updateDeliveryOrderProblem(order);
    }

    /**
     * 字符串map转Map
     *
     * @param str
     * @return
     */
    public static Map<String, String> mapStringToMap(String str) throws Exception {
        str = str.substring(1, str.length() - 1);
        String[] strs = str.split(",");
        Map<String, String> map = new HashMap<String, String>();
        for (String string : strs) {
            String key = string.split("\":\"")[0];
            key = key.substring(1);
            String value = string.split("\":\"")[1];
            value = value.substring(0, value.length() - 1);
            map.put(key, value);
        }
        return map;
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
        Order order = orderMapper.selectOrderByIdOverWrite(id);
        Order orderNew = addMoreUrl(order);
        // 设置过期时间
        Order orderNow = getOrder(orderNew);
        // vouchersIds 转化vouchersIdList( java 8+)
        String vouchersIds = orderNow.getVouchersIds();
        if (!StringUtils.isEmpty(vouchersIds)) {
            List<Integer> list = Arrays.asList(vouchersIds.split(",")).stream()
                    .map(s -> Integer.parseInt(s))  //.map(Integer::valueOf)
                    .collect(Collectors.toList());
            orderNow.setVouchersIdList(list);
        }
        return orderNow;
    }


    @Override
    public Integer updateOrderPayDateAndProcessOverWrite(Integer orderId, Integer orderProcess) {
        return orderMapper.updateOrderPayDateAndProcessOverWrite(orderId, orderProcess);
    }

    @Override
    public Integer updateOrderOverWrite(Integer orderId) throws Exception {
        Order order = new Order();
        order.setId(orderId);
        order.setOrderProcess(1);// 订单进行状态:1.待付款2.进行中3.已完成4.已取消
        String shareCode = UUIDUtils.generateShortUuid();
        order.setDeliveryHarvestCode(shareCode);
        addDeliveryPickUpFileQRCodeUrl(orderId);
        return orderMapper.updateOrder(order);
    }

    @Override
    public String downLoadFileListOverWriteNew(String orderId) {
        Order order = orderMapper.selectOrderById(orderId);
        String path = DownLoadZip.zipFilesDown(order);
//        String path = DownLoadZip.zipFilesDownOverWtrite(order);
        return path;
    }

    /**
     * 设置过期时间
     *
     * @param orderNew
     * @return
     */
    private Order getOrder(Order orderNew) {
        String orderDeliveryPrescriptioTime = orderNew.getOrderDeliveryPrescriptioTime();
        if (!StringUtils.isEmpty(orderDeliveryPrescriptioTime)) {
            // 配送时间 mm
            Long orderDeliveryPrescriptioTimeLong = Long.valueOf(orderDeliveryPrescriptioTime);
            Date orderCreateTime = orderNew.getOrderCreateTime();
            // 支付时间 mm
            if (!StringUtils.isEmpty(orderCreateTime)) {
                Long orderPayDateLong = orderCreateTime.getTime();
                Long expireTime = orderDeliveryPrescriptioTimeLong + orderPayDateLong;
                orderNew.setExpireTime(expireTime.toString());
            }
        }
        return orderNew;
    }


}
