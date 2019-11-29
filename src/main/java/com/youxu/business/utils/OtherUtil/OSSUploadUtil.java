package com.youxu.business.utils.OtherUtil;


import com.aliyun.oss.OSSClient;
import com.youxu.business.service.BaseService;
import com.youxu.business.utils.pojotools.UpLoadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/1/4.
 */
public class OSSUploadUtil extends BaseService {
private final static Logger logger = LoggerFactory.getLogger(OSSUploadUtil.class);
    private static final String FALSE = "上传失败";

    /**
     * 图片上传
     */
    public static String uploadBlog(@RequestParam("file") MultipartFile file) {
        String filename = file.getOriginalFilename();
        logger.warn("=================================================================================================");
        logger.warn("file.getOriginalFilename()"+filename);
        logger.warn("=================================================================================================");
        try {
            if (file != null) {
                //拼接/log
                StringBuilder path = new StringBuilder("log/");
                //获取时间戳
                Date fileDate = new Date();
                StringBuilder datetime = new StringBuilder(String.valueOf(fileDate.getTime()));
                //获取时间文件夹,并且与时间戳进行拼接
                SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyyMMdd");
                String date = (dateFormatShow.format(new Date()));
                StringBuilder newName = new StringBuilder(date);
                path.append(newName.toString());
                path.append("/");
                path.append(datetime);
                path.append("/");
                path.append(filename);
                //获取文件后缀名--file.getOriginalFilename(); 获取的名字带后缀
               /* String extName = filename.substring(filename.lastIndexOf("."));
                path.append(extName);*/
                String yuming1 = path.toString();
                logger.warn("=================================================================================================");
                logger.warn("yuming1"+yuming1);
                logger.warn("=================================================================================================");
                File newFile = new File(filename);
                FileOutputStream os = new FileOutputStream(newFile);
                os.write(file.getBytes());
                os.close();
                // 上传到OSS /log/20190517/1218209821212.jpg
                OSSUploadUtil.uploadFile(ali_endpoint, ali_accesskey_id, ali_accesskey_secret, ali_logstorage, newFile, yuming1);
                // 删除上传的文件
                File file1 = new File(filename);
                String s = file1.getAbsolutePath();
                DeleteFileUtil.delete(s);
                //先拼接域名:
                StringBuilder yuming = new StringBuilder("https://youxu-print.oss-cn-beijing.aliyuncs.com/");
                //再拼接/log
                yuming.append(yuming1);
                return (yuming.toString());
            }
            return FALSE;
        } catch (Exception ex) {
            ex.printStackTrace();
            return FALSE;
        }
    }
    /**
     * 图片上传
     */
    public static String uploadBlog(@RequestParam("file") MultipartFile file, String pathPart) {
        String filename = file.getOriginalFilename();
        try {
            if (file != null) {
                //拼接/image
                StringBuilder path = new StringBuilder(pathPart);
                //获取时间戳
                Date fileDate = new Date();
                StringBuilder datetime = new StringBuilder(String.valueOf(fileDate.getTime()));
                //获取时间文件夹,并且与时间戳进行拼接
                SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyyMMdd");
                String date = (dateFormatShow.format(new Date()));
                StringBuilder newName = new StringBuilder(date);
                path.append(newName.toString());
                path.append("/");
                path.append(datetime);
                path.append("/");
                path.append(filename);
                //获取文件后缀名--file.getOriginalFilename(); 获取的名字带后缀
               /* String extName = filename.substring(filename.lastIndexOf("."));
                path.append(extName);*/
                String yuming1 = path.toString();
                File newFile = new File(filename);
                FileOutputStream os = new FileOutputStream(newFile);
                os.write(file.getBytes());
                os.close();
                // 上传到OSS /log/20190517/1218209821212.jpg
                OSSUploadUtil.uploadFile(ali_endpoint, ali_accesskey_id, ali_accesskey_secret, ali_logstorage, newFile, yuming1);
                // 删除上传的文件
                File file1 = new File(filename);
                String s = file1.getAbsolutePath();
                DeleteFileUtil.delete(s);
                //先拼接域名:
                StringBuilder yuming = new StringBuilder("http://youxu-print.oss-cn-beijing.aliyuncs.com/");
                //再拼接/log
                yuming.append(yuming1);
                return (yuming.toString());
            }
            return FALSE;
        } catch (Exception ex) {
            ex.printStackTrace();
            return FALSE;
        }
    }
    /**
     *
     * @MethodName: uploadFile
     * @param file
     */
    public static void uploadFile(String endpoint, String accessKeyId, String accessKeySecret, String storageName, File file, String name) {
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件
        ossClient.putObject(storageName, name,new File(String.valueOf(file)));
        // 关闭client
        ossClient.shutdown();
    }
    public static void deleteFile(String endpoint, String accessKeyId, String accessKeySecret, String storageName, String name) {
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件
        ossClient.deleteObject(storageName, name);
        // 关闭client
        ossClient.shutdown();
    }

    /**
     * 图片上传
     */
    public static String uploadBlogOverWrite(MultipartFile multipartFile,String multipartFileName) {
        try {
            if (multipartFile != null) {
                //拼接/log
                StringBuilder path = new StringBuilder("log/");
                //获取时间戳
                Date fileDate = new Date();
                StringBuilder datetime = new StringBuilder(String.valueOf(fileDate.getTime()));
                //获取时间文件夹,并且与时间戳进行拼接
                SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyyMMdd");
                String date = (dateFormatShow.format(new Date()));
                StringBuilder newName = new StringBuilder(date);
                path.append(newName.toString());
                path.append("/");
                path.append(datetime);
                path.append("/");
                path.append(multipartFileName);
                //获取文件后缀名--file.getOriginalFilename(); 获取的名字带后缀
               /* String extName = filename.substring(filename.lastIndexOf("."));
                path.append(extName);*/
                String yuming1 = path.toString();
                logger.warn("=================================================================================================");
                logger.warn("yuming1"+yuming1);
                logger.warn("=================================================================================================");
                File newFile = new File(multipartFileName);
                FileOutputStream os = new FileOutputStream(newFile);
                os.write(multipartFile.getBytes());
                os.close();
                // 上传到OSS /log/20190517/1218209821212.jpg
                OSSUploadUtil.uploadFile(ali_endpoint, ali_accesskey_id, ali_accesskey_secret, ali_logstorage, newFile, yuming1);
                // 删除上传的文件
                File file1 = new File(multipartFileName);
                String s = file1.getAbsolutePath();
                DeleteFileUtil.delete(s);
                //先拼接域名:
                StringBuilder yuming = new StringBuilder("https://youxu-print.oss-cn-beijing.aliyuncs.com/");
                //再拼接/log
                yuming.append(yuming1);
                return (yuming.toString());
            }
            return FALSE;
        } catch (Exception ex) {
            ex.printStackTrace();
            return FALSE;
        }
    }


    /**
     * 图片上传
     */
    public static String uploadBlogFile(File zipFile,FileInputStream fileInputStream, String multipartFileName) {
        try {
            if (fileInputStream != null) {
                //拼接/log
                StringBuilder path = new StringBuilder("log/");
                //获取时间戳
                Date fileDate = new Date();
                StringBuilder datetime = new StringBuilder(String.valueOf(fileDate.getTime()));
                //获取时间文件夹,并且与时间戳进行拼接
                SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyyMMdd");
                String date = (dateFormatShow.format(new Date()));
                StringBuilder newName = new StringBuilder(date);
                path.append(newName.toString());
                path.append("/");
                path.append(datetime);
                path.append("/");
                path.append(multipartFileName);
                //获取文件后缀名--file.getOriginalFilename(); 获取的名字带后缀
               /* String extName = filename.substring(filename.lastIndexOf("."));
                path.append(extName);*/
                String yuming1 = path.toString();
                logger.warn("=================================================================================================");
                logger.warn("yuming1"+yuming1);
                logger.warn("=================================================================================================");
                File newFile = new File(multipartFileName);
                FileOutputStream os = new FileOutputStream(newFile);
                BufferedInputStream buff = new BufferedInputStream(fileInputStream);
                byte[] car=new byte[1024];
                int l=0;
                while (l < zipFile.length()) {
                    int j = buff.read(car, 0, 1024);
                    l += j;
                    os.write(car, 0, j);
                }
                os.close();
                // 上传到OSS /log/20190517/1218209821212.jpg
                OSSUploadUtil.uploadFile(ali_endpoint, ali_accesskey_id, ali_accesskey_secret, ali_logstorage, newFile, yuming1);
                // 删除上传的文件
                File file1 = new File(multipartFileName);
                String s = file1.getAbsolutePath();
                DeleteFileUtil.delete(s);
                //先拼接域名:
                StringBuilder yuming = new StringBuilder("https://youxu-print.oss-cn-beijing.aliyuncs.com/");
                //再拼接/log
                yuming.append(yuming1);
                return (yuming.toString());
            }
            return FALSE;
        } catch (Exception ex) {
            ex.printStackTrace();
            return FALSE;
        }
    }
}

