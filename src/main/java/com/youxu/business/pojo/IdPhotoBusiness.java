package com.youxu.business.pojo;

import lombok.Data;

import java.io.File;
import java.util.Map;

@Data
public class IdPhotoBusiness {
    private String specId;

    private String base64;

    private File file;

    private Integer userId;

    private Integer code;//

    private String message;//

    private Map result;
}
