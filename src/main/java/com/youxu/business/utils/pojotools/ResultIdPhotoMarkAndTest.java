package com.youxu.business.utils.pojotools;

import lombok.Data;

/**
 * 返回对象：接口2：制作并检测证件照
 */
@Data
public class ResultIdPhotoMarkAndTest {
    private String code;//状态码
    private String[] not_check_result;
    private ResultIdPhotoMarkAndTestObject result;



}
