package com.youxu.business.utils.OtherUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
public class FileToBase64 {
    /**
     * <p>将文件转成base64 字符串</p>
     * @param path 文件路径
     * @return
     * @throws Exception
     */
    public static String encodeBase64File(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer);
    }

    /**
     * <p>将文件转成base64 字符串</p>
     * @param
     * @return
     * @throws Exception
     */
    public static String fileEncodeBase64File(File file) throws Exception {
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer);
    }
    /**
     * <p>将base64字符解码保存文件</p>
     * @param base64Code
     * @param targetPath
     * @throws Exception
     */
    public static void decoderBase64File(String base64Code,String targetPath) throws Exception {
        byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }
    /**
     * <p>将base64字符保存文本文件</p>
     * @param base64Code
     * @param targetPath
     * @throws Exception
     */
    public static void toFile(String base64Code,String targetPath) throws Exception {
        byte[] buffer = base64Code.getBytes();
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }
    public static void main(String[] args) {
        try {
            String base64Code =encodeBase64File("/Users/Crazy/Pictures/zyb2.jpg");
            System.out.println(base64Code);
            decoderBase64File(base64Code, "/Users/Crazy/Desktop/zyb.png");
            toFile(base64Code, "/Users/Crazy/Desktop/zyb.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * MultipartFile 转化为 base64
     * @param file
     * @return
     * @throws Exception
     */
    public static String multipartFileTrancateFile(MultipartFile file) throws Exception{
        BASE64Encoder base64Encoder =new BASE64Encoder();
        String base64EncoderImg = file.getOriginalFilename()+","+ base64Encoder.encode(file.getBytes());
        return base64EncoderImg;
    }
}