package com.youxu.business.utils.pojotools;

import com.youxu.business.pojo.idphotonewadd.BackgroundColor;
import lombok.Data;

import java.util.List;

@Data
public class IdPhotoMarkAndTest {

    String file;
    // 制作并检测
    String app_key = "2abf79c1e6f1aa18583f6a38d05336eae9baf3e3";

    String spec_id;

    List<BackgroundColor> background_color;
}
