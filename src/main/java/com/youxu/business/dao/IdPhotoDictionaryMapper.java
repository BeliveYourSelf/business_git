package com.youxu.business.dao;

import com.youxu.business.pojo.IdPhotoDictionary;
import com.youxu.business.pojo.IdPhotoDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IdPhotoDictionaryMapper {
    long countByExample(IdPhotoDictionaryExample example);

    int deleteByExample(IdPhotoDictionaryExample example);

    int insert(IdPhotoDictionary record);

    int insertSelective(IdPhotoDictionary record);

    List<IdPhotoDictionary> selectByExample(IdPhotoDictionaryExample example);

    int updateByExampleSelective(@Param("record") IdPhotoDictionary record, @Param("example") IdPhotoDictionaryExample example);

    int updateByExample(@Param("record") IdPhotoDictionary record, @Param("example") IdPhotoDictionaryExample example);

    // 根据证件照规格名称查看
    List<IdPhotoDictionary> selectIdPhotoDictionaryListByName(@Param("idPhotoDictionaryName") String idPhotoDictionaryName);

}