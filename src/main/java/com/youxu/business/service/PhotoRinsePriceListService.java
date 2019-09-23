package com.youxu.business.service;

import com.youxu.business.pojo.PhotoRinsePriceList;

import java.util.List;

public interface PhotoRinsePriceListService {
    List<PhotoRinsePriceList> selectPhotoRinsePriceList(String storeId);
}
