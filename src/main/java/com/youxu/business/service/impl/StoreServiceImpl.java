package com.youxu.business.service.impl;

import com.youxu.business.dao.StoreMapper;
import com.youxu.business.pojo.Store;
import com.youxu.business.service.StoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService{
    @Resource
    private StoreMapper storeMapper;

    @Override
    public List<Store> selectStoreList() {
        return storeMapper.selectStoreList();
    }
}
