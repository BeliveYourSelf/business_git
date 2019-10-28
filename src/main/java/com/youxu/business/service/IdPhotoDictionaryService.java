package com.youxu.business.service;

import com.youxu.business.pojo.IdPhotoDictionary;

import java.util.List;

public interface IdPhotoDictionaryService {
    List<IdPhotoDictionary> selectIdPhotoDictionaryListByName(String idPhotoDictionaryName, String storeId);
}
