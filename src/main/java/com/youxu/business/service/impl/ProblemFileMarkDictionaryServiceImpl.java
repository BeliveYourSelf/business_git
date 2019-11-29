package com.youxu.business.service.impl;

import com.youxu.business.dao.ProblemFileMarkDictionaryMapper;
import com.youxu.business.pojo.ProblemFileMarkDictionary;
import com.youxu.business.service.ProblemFileMarkDictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProblemFileMarkDictionaryServiceImpl implements ProblemFileMarkDictionaryService {
    @Resource
    private ProblemFileMarkDictionaryMapper problemFileMarkDictionaryMapper;

    @Override
    public List<ProblemFileMarkDictionary> selectProblemFileMarkDictionary(String storeId) {

        return problemFileMarkDictionaryMapper.selectProblemFileMarkDictionary(storeId);
    }
}
