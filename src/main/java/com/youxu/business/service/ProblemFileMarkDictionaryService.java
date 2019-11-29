package com.youxu.business.service;

import com.youxu.business.pojo.ProblemFileMarkDictionary;

import java.util.List;

public interface ProblemFileMarkDictionaryService {
    List<ProblemFileMarkDictionary> selectProblemFileMarkDictionary(String storeId);
}
