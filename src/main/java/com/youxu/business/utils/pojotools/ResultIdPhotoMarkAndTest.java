package com.youxu.business.utils.pojotools;

import com.youxu.business.pojo.idphotonewadd.NotCheckResult;
import lombok.Data;

import java.util.List;

/**
 * 返回对象：接口2：制作并检测证件照
 */
@Data
public class ResultIdPhotoMarkAndTest {
    private String code;//状态码
    private List<NotCheckResult> not_check_result;
    private ResultIdPhotoMarkAndTestObject result;



}
