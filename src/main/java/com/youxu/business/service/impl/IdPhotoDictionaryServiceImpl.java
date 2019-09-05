package com.youxu.business.service.impl;

import com.youxu.business.dao.IdPhotoDictionaryMapper;
import com.youxu.business.pojo.IdPhotoDictionary;
import com.youxu.business.service.IdPhotoDictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IdPhotoDictionaryServiceImpl implements IdPhotoDictionaryService {
    @Resource
    private IdPhotoDictionaryMapper idPhotoDictionaryMapper;
    @Override
    public List<IdPhotoDictionary> selectIdPhotoDictionaryListByName(String idPhotoDictionaryName) {
        return idPhotoDictionaryMapper.selectIdPhotoDictionaryListByName(idPhotoDictionaryName);
    }
}
