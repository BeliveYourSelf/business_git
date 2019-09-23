package com.youxu.business.service.impl;

import com.youxu.business.dao.PhotoRinsePriceListMapper;
import com.youxu.business.pojo.PhotoRinsePriceList;
import com.youxu.business.service.PhotoRinsePriceListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PhotoRinsePriceListServiceImpl implements PhotoRinsePriceListService {
    @Resource
    private PhotoRinsePriceListMapper photoRinsePriceListMapper;

    @Override
    public List<PhotoRinsePriceList> selectPhotoRinsePriceList(String storeId) {
        return photoRinsePriceListMapper.selectPhotoRinsePriceList(storeId);
    }
}
