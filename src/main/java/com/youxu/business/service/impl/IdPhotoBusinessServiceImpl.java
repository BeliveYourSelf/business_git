package com.youxu.business.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.GsonBuilder;
import com.youxu.business.pojo.idphotonewadd.*;
import com.youxu.business.utils.HttpTools.HttpToolOther;
import com.youxu.business.utils.OtherUtil.Base64TransToBinarySystemToFile;
import com.youxu.business.utils.OtherUtil.DeleteFileUtil;
import com.youxu.business.utils.OtherUtil.OSSUploadUtil;
import com.youxu.business.utils.pojotools.*;
import net.sf.json.JSONObject;
import com.youxu.business.pojo.IdPhotoBusiness;
import com.youxu.business.service.BaseService;
import com.youxu.business.service.IdPhotoBusinessService;
import com.youxu.business.utils.HttpTools.HttpResult;
import com.youxu.business.utils.HttpTools.HttpTool;
import org.reflections.vfs.Vfs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class IdPhotoBusinessServiceImpl extends BaseService implements IdPhotoBusinessService {
    private final static Logger logger = LoggerFactory.getLogger(IdPhotoBusinessServiceImpl.class);
    @Resource
    private HttpTool httpTool;

    @Override
    public IdPhotoBusiness makeIdPhoto(IdPhotoBusiness idPhotoBusiness) throws Exception {
        IdPhotoBusiness idPhotoBusinessNew = threeIntegrationOfIdPhotoBusiness(idPhotoBusiness);
        return idPhotoBusinessNew;
    }

    @Override
    public GetSpecs getSpecs(String specId) throws Exception {
        String requestPath = GETIDPHOTOSPECBYID + specId;
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        HttpMethod method = HttpMethod.GET;
        HttpResult results = httpTool.doHttp(requestPath, method, header, null, null);
        com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(results.getResult());
        String jsonObjectString = com.alibaba.fastjson.JSONObject.toJSONString(jsonObject);
        GetSpecs getSpecs = com.alibaba.fastjson.JSONObject.parseObject(jsonObjectString, GetSpecs.class);
        String background_color = getSpecs.getBackground_color();
        List<BackgroundColor> backgroundColorList = JSONArray.parseArray(background_color, BackgroundColor.class);
        getSpecs.setBackground_color_List(backgroundColorList);
        return getSpecs;
    }

    /**
     * 更换背景
     *
     * @param idPhotoBusiness
     * @return
     */
    @Override
    public IdPhotoBusiness udpateBackGroundColor(IdPhotoBusiness idPhotoBusiness) throws Exception {
        IdPhotoBusiness idPhotoBusinessNew = updateIdPhotoBusiness(idPhotoBusiness);
        return idPhotoBusinessNew;
    }

    @Override
    public String getIdPhotoWaterMarkByFileName(String fileName, HttpServletResponse response) throws IOException {
        String requestPath = null;
        if (fileName.contains("http")) {
            requestPath = fileName;
        } else {
            requestPath = GETIDPHOTOWATERMARKANDTYPESETTINGURL + fileName;
        }
        // 获取输入流
        URL url = new URL(null, requestPath, new sun.net.www.protocol.https.Handler());
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int contentLength = connection.getContentLength();
        // 向输出流写入
        InputStream inputStream = connection.getInputStream();
        response.setHeader("content-type", "text/html;charset=utf-8");
        byte[] bytes = new byte[contentLength];
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inputStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        bytes = swapStream.toByteArray();
        inputStream.close();
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }

    @Override
    public CutChangeClothesResult cutChangeClothes(CutChangeClothes cutChangeClothes) {
        JSONObject jsonObject = JSONObject.fromObject(cutChangeClothes);
        JSONObject jsonObjectNew = HttpTool.httpPost(CUTCHANGECLOTHES, jsonObject, false);
        String jsonString = com.alibaba.fastjson.JSONObject.toJSONString(jsonObjectNew);
        CutChangeClothesResult cutChangeClothesResult = com.alibaba.fastjson.JSONObject.parseObject(jsonString, CutChangeClothesResult.class);
        return cutChangeClothesResult;
    }

    @Override
    public String getOssPathByFilePath(FileNameFather fileNameFather, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileNamePath = getFileNamePath(request, fileNameFather.getFileName());
        // 创建文件输出流
        File file = new File(fileNameFather.getFileName());
        FileOutputStream fos = new FileOutputStream(file);
        URL url = new URL(null, fileNameFather.getFilePath(), new sun.net.www.protocol.https.Handler());
        HttpURLConnection httpURLConnection = (HttpsURLConnection) url.openConnection();
        httpURLConnection.connect();
        InputStream inputStream = httpURLConnection.getInputStream();
        byte[] bytes = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(bytes)) > 0) {
            // 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            fos.write(bytes, 0, length);
        }
        fos.close();
        // 上传到OSS /log/20190517/1218209821212.jpg
        OSSUploadUtil.uploadFile(ali_endpoint, ali_accesskey_id, ali_accesskey_secret, ali_logstorage, file, fileNamePath);
        // 删除上传的文件
        String s = file.getAbsolutePath();
        DeleteFileUtil.delete(s);
        //先拼接域名:
        StringBuilder yuming = new StringBuilder("https://youxu-print.oss-cn-beijing.aliyuncs.com/");
        //再拼接/log
        yuming.append(fileNamePath);
        return (yuming.toString());
    }

    private String getFileNamePath(HttpServletRequest request, String filename) {
        //拼接/log
        StringBuilder path = new StringBuilder(request.getContextPath());
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
        String filenamePath = path.toString();
        return filenamePath;
    }

    /**
     * 整合证件照三个接口-更换证件照背景
     */
    private IdPhotoBusiness updateIdPhotoBusiness(IdPhotoBusiness idPhotoBusiness) throws Exception {
        IdPhotoBusiness idPhotoBusinessStatus = new IdPhotoBusiness();
        IdPhotoBusinessServiceImpl idPhotoBusinessService = new IdPhotoBusinessServiceImpl();
        // 接口1：证件照环境监测
        ResultIdPhotoBusinessLicenses resultIdPhotoBusinessLicenses = idPhotoBusinessService.idPhotoBusinessLicenses(idPhotoBusiness.getBase64());
        String codeResultIdPhotoBusinessLicenses = resultIdPhotoBusinessLicenses.getCode();
        if (!"200".equals(codeResultIdPhotoBusinessLicenses)) {
            idPhotoBusinessStatus.setCode(Integer.valueOf(codeResultIdPhotoBusinessLicenses));
            idPhotoBusinessStatus.setMessage(resultIdPhotoBusinessLicenses.getMsg());
            return idPhotoBusinessStatus;
        }
        // 接口2：制作并检测证件照
        ResultIdPhotoMarkAndTest resultIdPhotoMarkAndTest = idPhotoBusinessService.idPhotoMarkAndTest(idPhotoBusiness.getBase64(), idPhotoBusiness.getSpecId(), idPhotoBusiness.getBackgroundColorList(), idPhotoBusiness.getIs_fair(), idPhotoBusiness.getFair_level());
        String codeResultIdPhotoMarkAndTest = resultIdPhotoMarkAndTest.getCode();
        if (!"200".equals(codeResultIdPhotoMarkAndTest)) {
            idPhotoBusinessStatus.setCode(Integer.valueOf(codeResultIdPhotoMarkAndTest));
            idPhotoBusinessStatus.setMessage("制作并检测证件照失败");
            return idPhotoBusinessStatus;
        }
        idPhotoBusinessStatus.setResultIdPhotoMarkAndTest(resultIdPhotoMarkAndTest);
        return idPhotoBusinessStatus;
    }

    /**
     * 整合证件照三个接口-original
     */
    private IdPhotoBusiness threeIntegrationOfIdPhotoBusiness(IdPhotoBusiness idPhotoBusiness) throws Exception {
        IdPhotoBusiness idPhotoBusinessStatus = new IdPhotoBusiness();
        IdPhotoBusinessServiceImpl idPhotoBusinessService = new IdPhotoBusinessServiceImpl();
        // 接口1：证件照环境监测
        ResultIdPhotoBusinessLicenses resultIdPhotoBusinessLicenses = idPhotoBusinessService.idPhotoBusinessLicenses(idPhotoBusiness.getBase64());
        String codeResultIdPhotoBusinessLicenses = resultIdPhotoBusinessLicenses.getCode();
        if (!"200".equals(codeResultIdPhotoBusinessLicenses)) {
            idPhotoBusinessStatus.setCode(Integer.valueOf(codeResultIdPhotoBusinessLicenses));
            idPhotoBusinessStatus.setMessage(resultIdPhotoBusinessLicenses.getMsg());
            return idPhotoBusinessStatus;
        }
        // 接口2：制作并检测证件照
        ResultIdPhotoMarkAndTest resultIdPhotoMarkAndTest = idPhotoBusinessService.idPhotoMarkAndTest(idPhotoBusiness.getBase64(), idPhotoBusiness.getSpecId(), null, null, null);
        String codeResultIdPhotoMarkAndTest = resultIdPhotoMarkAndTest.getCode();
        if (!"200".equals(codeResultIdPhotoMarkAndTest)) {
            idPhotoBusinessStatus.setCode(Integer.valueOf(codeResultIdPhotoMarkAndTest));
            idPhotoBusinessStatus.setMessage("制作并检测证件照失败");
            return idPhotoBusinessStatus;
        }
        // 接口3:同时获取无水印单张和排版图片
        String name = resultIdPhotoMarkAndTest.getResult().getCheck_result().getName();
        String[] file_name = resultIdPhotoMarkAndTest.getResult().getFile_name();//无水印图片名字，包括多种可选颜色
        String[] file_name_print = resultIdPhotoMarkAndTest.getResult().getFile_name_print();//无水印排版图片名字，包括多种可选颜色
        ResultGetIdPhotoNoWaterMarkAndTypeSettingUrl idPhotoNoWaterMarkAndTypeSettingUrl = idPhotoBusinessService.getIdPhotoNoWaterMarkAndTypeSettingUrl(file_name[0]);
        String code = idPhotoNoWaterMarkAndTypeSettingUrl.getData().getCode();
        if (!"200".equals(code)) {
            idPhotoBusinessStatus.setCode(Integer.valueOf(codeResultIdPhotoMarkAndTest));
            idPhotoBusinessStatus.setMessage("制作并检测证件照失败");
            return idPhotoBusinessStatus;
        }
        ResultGetIdPhotoNoWaterMarkAndTypeSettingUrlObject data = idPhotoNoWaterMarkAndTypeSettingUrl.getData();
        String file_nameUrl = data.getFile_name();
        String file_name_list = data.getFile_name_list();
        idPhotoBusinessStatus.setCode(200);
        idPhotoBusinessStatus.setMessage("成功");
        idPhotoBusinessStatus.setSpecId(idPhotoBusiness.getSpecId());
        idPhotoBusinessStatus.setPictureUrl(file_nameUrl);
        return idPhotoBusinessStatus;
    }

    /**
     * 接口1：证件照环境监测
     */
    private ResultIdPhotoBusinessLicenses idPhotoBusinessLicenses(String base64Picture) throws Exception {
        IdPhotoBusinessLicenses idPhotoBusinessLicenses = new IdPhotoBusinessLicenses();
        idPhotoBusinessLicenses.setFile(base64Picture);
        JSONObject jsonObjectIdPhotoBusinessLicenses = JSONObject.fromObject(idPhotoBusinessLicenses);
        JSONObject jsonObject = HttpTool.httpPost(IDPHOTOBUSINESSLICENSEURL, jsonObjectIdPhotoBusinessLicenses, false);
        //JSONObject转换成对象
        Map<String, Class<ResultIdPhotoBusinessLicensesObject>> map = new HashMap<String, Class<ResultIdPhotoBusinessLicensesObject>>();
        map.put("resultIdPhotoBusinessLicensesObject", ResultIdPhotoBusinessLicensesObject.class); // key为teacher私有变量的属性名
        // 使用JSONObject.toBean(jsonObject, beanClass, classMap)
        ResultIdPhotoBusinessLicenses resultIdPhotoBusinessLicenses = (ResultIdPhotoBusinessLicenses) JSONObject.toBean(jsonObject, ResultIdPhotoBusinessLicenses.class, map);
        return resultIdPhotoBusinessLicenses;
    }

    /**
     * 接口2：制作并检测证件照
     */
    private ResultIdPhotoMarkAndTest idPhotoMarkAndTest(String base64Picture, String specId, List<BackgroundColor> backgroundColorList, Integer is_fair, Integer fair_level) throws Exception {
        IdPhotoMarkAndTest idPhotoMarkAndTest = new IdPhotoMarkAndTest();
        idPhotoMarkAndTest.setFile(base64Picture);
        idPhotoMarkAndTest.setSpec_id(specId);
        idPhotoMarkAndTest.setBackground_color(backgroundColorList);
        if (!org.springframework.util.StringUtils.isEmpty(is_fair)) {
            idPhotoMarkAndTest.setIs_fair(is_fair);
        }
        if (!org.springframework.util.StringUtils.isEmpty(fair_level)) {
            idPhotoMarkAndTest.setFair_level(fair_level);
        }
        //Object转JSON字符串:
        String idPhotoMarkAndTestJsonString = com.alibaba.fastjson.JSONObject.toJSONString(idPhotoMarkAndTest);
        //JSON字符串转JSONObject:
        com.alibaba.fastjson.JSONObject idPhotoMarkAndTestJsonObject = com.alibaba.fastjson.JSONObject.parseObject(idPhotoMarkAndTestJsonString);
        //请求结果
        String jsonStringResultIdPhotoMarkAndTest = HttpToolOther.httpPostReturnJsonString(IDPHOTOMAKEANDTESTURL, idPhotoMarkAndTestJsonObject, false);
        ResultIdPhotoMarkAndTest resultIdPhotoMarkAndTest = new GsonBuilder().create().fromJson(jsonStringResultIdPhotoMarkAndTest, ResultIdPhotoMarkAndTest.class);
        return resultIdPhotoMarkAndTest;
    }

    /**
     * 接口3:同时获取无水印单张和排版图片
     */
    private ResultGetIdPhotoNoWaterMarkAndTypeSettingUrl getIdPhotoNoWaterMarkAndTypeSettingUrl(String fileName) throws Exception {
        GetIdPhotoNoWaterMarkAndTypeSettingUrl getIdPhotoNoWaterMarkAndTypeSettingUrl = new GetIdPhotoNoWaterMarkAndTypeSettingUrl();
        getIdPhotoNoWaterMarkAndTypeSettingUrl.setFile_name(fileName);
        JSONObject jsonObjectIdPhotoMarkAndTest = JSONObject.fromObject(getIdPhotoNoWaterMarkAndTypeSettingUrl);
        JSONObject jsonObject = HttpTool.httpPost(GETIDPHOTONOWATERMARKANDTYPESETTINGURL, jsonObjectIdPhotoMarkAndTest, false);
        String jsonString = com.alibaba.fastjson.JSONObject.toJSONString(jsonObject);
        ResultGetIdPhotoNoWaterMarkAndTypeSettingUrl resultGetIdPhotoNoWaterMarkAndTypeSettingUrl = com.alibaba.fastjson.JSONObject.parseObject(jsonString, ResultGetIdPhotoNoWaterMarkAndTypeSettingUrl.class);
        return resultGetIdPhotoNoWaterMarkAndTypeSettingUrl;
    }

    @Override
    public void downLoadSteamByDocumentUrl(HttpServletRequest request, HttpServletResponse response, String documentUrl) throws IOException {
        // 获取格式
        int format = documentUrl.lastIndexOf(".");
        String formatString = documentUrl.substring(format);
        // 获取输入流
        URL url = new URL(documentUrl);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        // 向输出流写入
        InputStream inputStream = connection.getInputStream();
        setContentTypeBySuffix(formatString, response);
        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        // 所读取的内容使用n来接收
        int n = 0;
        byte[] bytes = new byte[1024];
        while ((n = inputStream.read(bytes)) != -1) {
            // 将字节数组的数据全部输出到输出流
            outputStream.write(bytes, 0, n);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }

    @Override
    public String changeBase64ToImageAnduploadOss(String base64String) throws IOException {
        File file = null;
        FileInputStream fileInputStream = null;
        try {
            // 下载图片路径

            String pathString = "base64图片.jpg";
            // base64转图片
            logger.info("base64转成本地文件开始：");
            boolean b = Base64TransToBinarySystemToFile.changeBase64ToImage(base64String, pathString);
            logger.info("base64转成本地文件结束：" + b);
            if (b) {
                logger.info("读取本地文件为流");
                file = new File(pathString);
                fileInputStream = new FileInputStream(file.getAbsoluteFile());
                MultipartFile multipartFile = new MockMultipartFile("temp.jpg", "temp.jpg", "", fileInputStream);
                logger.info("上传file到oss");
                String uploadSuccess = OSSUploadUtil.uploadBlog(multipartFile);
                logger.info("上传oss成功");
                return uploadSuccess;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fileInputStream.close();
            String s = file.getAbsolutePath();
            DeleteFileUtil.delete(s);
        }
        return null;
    }

    private void setContentTypeBySuffix(String suffix, HttpServletResponse response) {
        switch (suffix) {
            case ".pdf":
                response.setContentType("application/pdf");
                break;
            case ".doc":
                response.setContentType("application/msword");
                break;
            case ".docx":
                response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                break;
            case ".jpg":
                response.setContentType("image/jpeg");
                break;
            case ".jpeg":
                response.setContentType("application/pdf");
                break;
            case ".png":
                response.setContentType("image/png");
                break;
            case ".wps":
                response.setContentType("application/vnd.ms-works");
                break;
            case ".ppt":
                response.setContentType("application/vnd.ms-powerpoint");
                break;
            case ".pptx":
                response.setContentType("application/vnd.openxmlformats-officedocument.presentationml.presentation");
                break;
            case ".xls":
                response.setContentType("application/vnd.ms-excel");
                break;
            case ".xlsx":
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                break;
            default:
                break;
        }
    }
}
