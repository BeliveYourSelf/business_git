package com.youxu.business.utils.pojotools;

/**
 * 返回对象：接口2：制作并检测证件照
 * 第二层内部类
 */
public class ResultIdPhotoMarkAndTestObject {
    private CheckResult check_result;
    private String[] file_name;//无水印图片名字，包括多种可选颜色
    private String[] file_name_print;//无水印排版图片名字，包括多种可选颜色
    private String[] file_name_print_wm;//带水印排版图片名字，包括多种可选颜色
    private String[] file_name_wm;//带水印图片名字，包括多种可选颜色
    private String is_print;//有无排版
    private String[] size;//图片尺寸
    private String[] size_print;//排版后图片尺寸
}
