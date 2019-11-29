package com.youxu.business.service.impl;

import com.youxu.business.dao.IdPhotoDictionaryMapper;
import com.youxu.business.dao.StoreMapper;
import com.youxu.business.pojo.IdPhotoDictionary;
import com.youxu.business.pojo.Store;
import com.youxu.business.service.IdPhotoDictionaryService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IdPhotoDictionaryServiceImpl implements IdPhotoDictionaryService {
    @Resource
    private IdPhotoDictionaryMapper idPhotoDictionaryMapper;

    @Resource
    private StoreMapper storeMapper;
    @Override
    public List<IdPhotoDictionary> selectIdPhotoDictionaryListByName(String idPhotoDictionaryName, String storeId) {
        List<IdPhotoDictionary> idPhotoDictionaries = idPhotoDictionaryMapper.selectIdPhotoDictionaryListByName(idPhotoDictionaryName);
        Store store = storeMapper.selectByStoreId(Integer.valueOf(storeId));
        if(!StringUtils.isEmpty(store) && !StringUtils.isEmpty(store.getLicencePrice())){
        for (IdPhotoDictionary idPhotoDictionary : idPhotoDictionaries) {
            Double licencePrice = store.getLicencePrice();
            idPhotoDictionary.setIdPhotoDictionaryPrice(licencePrice);
        }
        }
        return idPhotoDictionaries;
    }
}
