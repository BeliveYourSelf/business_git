package com.youxu.business.utils.OtherUtil;

public class ImageSizeTool {

    /**
     *通过图片base64流判断图片等于多少字节
     *image 图片流
     */
    public static Integer imageSize(String image){
        String str=image.substring(23); // 1.需要计算文件流大小，首先把头部的data:image/png;base64,（注意有逗号）去掉。
        Integer equalIndex= str.indexOf("=");//2.找到等号，把等号也去掉
        if(str.indexOf("=")>0) {
            str=str.substring(0, equalIndex);
        }
        Integer strLength=str.length();//3.原来的字符流大小，单位为字节
        Integer size=strLength-(strLength/8)*2;//4.计算后得到的文件流大小，单位为字节
        return size;
    }

    /**
     *通过图片base64流判断图片等于多少字节
     *image 图片流
     */
    public static String imageSubstring(String image){
        String str=image.substring(23); // 1.需要计算文件流大小，首先把头部的data:image/png;base64,（注意有逗号）去掉。
        return str;
    }
}
