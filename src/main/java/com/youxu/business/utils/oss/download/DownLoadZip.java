package com.youxu.business.utils.oss.download;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.youxu.business.pojo.Order;
import com.youxu.business.pojo.OrderDetails;
import com.youxu.business.pojo.OrderDetailsBookBinding;
import com.youxu.business.service.BaseService;
import com.youxu.business.utils.OtherUtil.OSSUploadUtil;
import org.apache.commons.lang.StringUtils;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DownLoadZip extends BaseService {


    public static String zipFilesDown(Order order) {
        HashMap<String, String> map = new HashMap<>();
        String mapValueObjectName = null;
        String path = null;
        try {
            List<OrderDetails> orderDetailsList = order.getOrderDetailsList();
            for (OrderDetails orderDetails : orderDetailsList) {
                String fileDetailName = orderDetails.getOrderDetailsName();
                String orderSpecName = orderDetails.getOrderSpecName();
                if(StringUtils.isNotEmpty(orderSpecName)){
                    fileDetailName += "-"+orderSpecName;
                }
                OrderDetailsBookBinding orderDetailsBookBinding = orderDetails.getOrderDetailsBookBinding();
                if (!org.springframework.util.StringUtils.isEmpty(orderDetailsBookBinding)) {
                    fileDetailName += "-" + orderDetailsBookBinding.getCoverColor();
                }
                String orderDetailsOnePictureUrl = orderDetails.getOrderDetailsOnePictureUrl();
                // if:证件照订单    else:照片冲印和文档打印
                if (!StringUtils.isEmpty(orderDetailsOnePictureUrl)) {
                    mapValueObjectName = orderDetailsOnePictureUrl.split("https://youxu-print.oss-cn-beijing.aliyuncs.com/")[1];
                    map.put(fileDetailName, mapValueObjectName);
                } else {
                    List<String> pictureUrlList = orderDetails.getPictureUrlList();
                    if (!org.springframework.util.StringUtils.isEmpty(pictureUrlList) && pictureUrlList.size() > 0) {
                        for (String pictureUrl : pictureUrlList) {
                            String pictureUrlObjectName = pictureUrl.split("https://youxu-print.oss-cn-beijing.aliyuncs.com/")[1];
                            map.put(fileDetailName + "-" + new Date().getTime() + "-", pictureUrlObjectName);
                        }
                    }
                }
            }
            // 初始化
            OSSClient ossClient = new OSSClient(ali_endpoint, ali_accesskey_id, ali_accesskey_secret);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd#HH:mm:ss");
            String dateTime = simpleDateFormat.format(new Date());
            String fileName = order.getId() + "-" + order.getOrderAddresseeName() +".zip";
            // 创建临时文件
            File zipFile = File.createTempFile(order.getId() + "-" + order.getOrderAddresseeName(), ".zip");
            FileOutputStream f = new FileOutputStream(zipFile);
            /**
             * 作用是为任何OutputStream产生校验和
             * 第一个参数是制定产生校验和的输出流，第二个参数是指定Checksum的类型 （Adler32（较快）和CRC32两种）
             */
            CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
            // 用于将数据压缩成Zip文件格式
            ZipOutputStream zos = new ZipOutputStream(csum);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                // 获取Object，返回结果为OSSObject对象     注意：ossfile（key）全路径（不包含域名）
                OSSObject ossObject = ossClient.getObject(ali_logstorage, value);
                // 读去Object内容  返回
                InputStream inputStream = ossObject.getObjectContent();
                // 对于每一个要被存放到压缩包的文件，都必须调用ZipOutputStream对象的putNextEntry()方法，确保压缩包里面文件不同名
                zos.putNextEntry(new ZipEntry(key));
                int bytesRead = 0;
                // 向压缩文件中输出数据
                while ((bytesRead = inputStream.read()) != -1) {
                    zos.write(bytesRead);
                }
                inputStream.close();
                zos.closeEntry(); // 当前文件写完，定位为写入下一条项目
            }
            zos.close();
            ossClient.shutdown();
            // 上传压缩包到oss
            String absolutePath = zipFile.getAbsolutePath();
            File file = new File(absolutePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            path = OSSUploadUtil.uploadBlogFile(file, fileInputStream, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }
}