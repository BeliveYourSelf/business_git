package com.youxu.business.utils.pojotools;

import lombok.Data;

/**
 * 返回对象：接口2：制作并检测证件照
 * 第3层内部类
 */
@Data
public class CheckResult {
    private String background_color;
    private String clothes_similar;
    private String eyes_close;
    private String face_blur;
    private String face_center;
    private String face_noise;
    private String facial_pose;
    private String file_size;
    private String headpose_pitch;
    private String headpose_roll;
    private String headpose_yaw;
    private String name;
    private String photo_format;
    private String px_and_mm;
    private String shoulder_equal;
    private String sight_line;
    private String spec_id;
}
