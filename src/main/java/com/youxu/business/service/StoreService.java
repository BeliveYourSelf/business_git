package com.youxu.business.service;

import com.youxu.business.pojo.Store;

import java.util.List;

public interface StoreService {
    List<Store> selectStoreList();

    Store selectStore(Store store);

    Store selectStoreById(String storeId);
}
