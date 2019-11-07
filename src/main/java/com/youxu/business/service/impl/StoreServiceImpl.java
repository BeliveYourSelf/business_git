package com.youxu.business.service.impl;

import com.youxu.business.dao.StoreMapper;
import com.youxu.business.pojo.Store;
import com.youxu.business.service.StoreService;
import com.youxu.business.utils.OtherUtil.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.*;

@Service
public class StoreServiceImpl implements StoreService{
    @Resource
    private StoreMapper storeMapper;

    @Override
    public List<Store> selectStoreList() {
        return storeMapper.selectStoreList();
    }

    @Override
    public Store selectStore(Store store) {
        List<Store> stores = storeMapper.selectStoreList();
        HashMap<Double, Store> doubleStoreHashMap = new HashMap<>();
        for(Store storeNew :stores){
            // 勾股定理距离
            double distance = MapUtils.GetDistance(store.getStoreLatitude(), store.getStoreLongitude(), storeNew.getStoreLatitude(), storeNew.getStoreLongitude());
            doubleStoreHashMap.put(distance,storeNew);
        }
        // 查找数组中最小的数
        Set<Map.Entry<Double, Store>> entries = doubleStoreHashMap.entrySet();
        Double keyMin = null;
        Store storeMin  = new Store();
        for(Map.Entry<Double,Store> entryStore:entries){
            Double key = entryStore.getKey();
            if(StringUtils.isEmpty(keyMin) || keyMin > key){
                keyMin = key;
            }
        }
        for(Map.Entry<Double,Store> entryStore:entries){
            if(keyMin == entryStore.getKey()){
                storeMin = entryStore.getValue();
            }
        }
        return storeMin;
    }

    @Override
    public Store selectStoreById(String storeId) {
        Store store = storeMapper.selectByStoreId(Integer.valueOf(storeId));
        return store;
    }
}
