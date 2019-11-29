package com.youxu.business.pojo;

import lombok.Data;

import java.util.List;

@Data
public class OrderDetailsPictureMapping {
    private Integer orderDetailsId;

    private Integer pictureId;

    private List<Picture> pictureList;

}