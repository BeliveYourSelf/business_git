package com.youxu.business.utils.pojotools;

import lombok.Data;

/**
 * 返回对象：接口1：证件照环境监测
 */
@Data
public class ResultIdPhotoBusinessLicenses {
    private String code;

    private String msg;

    private ResultIdPhotoBusinessLicensesObject result;

    private String total_result;
}
