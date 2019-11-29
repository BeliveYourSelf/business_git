package com.youxu.business.utils.baiducloud.facerecognition.baiducloudutil;

import lombok.Data;

@Data
public class ResultObject {
    private String error_code;

    private String error_msg;

    private String log_id;

    private String timestamp;

    private String cashed;

    private ResultScore result;

}
