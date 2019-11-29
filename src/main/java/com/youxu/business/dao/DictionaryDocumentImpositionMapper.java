package com.youxu.business.dao;

import com.youxu.business.pojo.DictionaryDocumentImposition;
import com.youxu.business.pojo.DictionaryDocumentImpositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictionaryDocumentImpositionMapper {
    long countByExample(DictionaryDocumentImpositionExample example);

    int deleteByExample(DictionaryDocumentImpositionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DictionaryDocumentImposition record);

    int insertSelective(DictionaryDocumentImposition record);

    List<DictionaryDocumentImposition> selectByExample(DictionaryDocumentImpositionExample example);

    DictionaryDocumentImposition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DictionaryDocumentImposition record, @Param("example") DictionaryDocumentImpositionExample example);

    int updateByExample(@Param("record") DictionaryDocumentImposition record, @Param("example") DictionaryDocumentImpositionExample example);

    int updateByPrimaryKeySelective(DictionaryDocumentImposition record);

    int updateByPrimaryKey(DictionaryDocumentImposition record);
    // 查看文档拼版列表
    List<DictionaryDocumentImposition> selectDocumentImposition(@Param("storeId")String storeId);
}