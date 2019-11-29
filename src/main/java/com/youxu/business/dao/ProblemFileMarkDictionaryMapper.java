package com.youxu.business.dao;

import com.youxu.business.pojo.ProblemFileMarkDictionary;
import com.youxu.business.pojo.ProblemFileMarkDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProblemFileMarkDictionaryMapper {
    long countByExample(ProblemFileMarkDictionaryExample example);

    int deleteByExample(ProblemFileMarkDictionaryExample example);

    int insert(ProblemFileMarkDictionary record);

    int insertSelective(ProblemFileMarkDictionary record);

    List<ProblemFileMarkDictionary> selectByExample(ProblemFileMarkDictionaryExample example);

    int updateByExampleSelective(@Param("record") ProblemFileMarkDictionary record, @Param("example") ProblemFileMarkDictionaryExample example);

    int updateByExample(@Param("record") ProblemFileMarkDictionary record, @Param("example") ProblemFileMarkDictionaryExample example);
    // 查看问题单标注集合
    List<ProblemFileMarkDictionary> selectProblemFileMarkDictionary(@Param("storyId")String storyId);
}