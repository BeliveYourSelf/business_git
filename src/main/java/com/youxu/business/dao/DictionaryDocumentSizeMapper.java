package com.youxu.business.dao;

import com.youxu.business.pojo.DictionaryDocumentSize;
import com.youxu.business.pojo.DictionaryDocumentSizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictionaryDocumentSizeMapper {
    long countByExample(DictionaryDocumentSizeExample example);

    int deleteByExample(DictionaryDocumentSizeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DictionaryDocumentSize record);

    int insertSelective(DictionaryDocumentSize record);

    List<DictionaryDocumentSize> selectByExample(DictionaryDocumentSizeExample example);

    DictionaryDocumentSize selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DictionaryDocumentSize record, @Param("example") DictionaryDocumentSizeExample example);

    int updateByExample(@Param("record") DictionaryDocumentSize record, @Param("example") DictionaryDocumentSizeExample example);

    int updateByPrimaryKeySelective(DictionaryDocumentSize record);

    int updateByPrimaryKey(DictionaryDocumentSize record);
}