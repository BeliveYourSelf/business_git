package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class PhotoRinsePriceList {
    private Integer id;

    private Integer storeId;

    private String tbPhotoRinseName;

    private Double tbPhotoRinsePrice;

    private Date tbPhotoRinseCreateTime;

    private Date tbPhotoRinseModifyTime;

    private Boolean tbPhotoRinseStatus;

}