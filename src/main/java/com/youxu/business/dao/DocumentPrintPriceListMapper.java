package com.youxu.business.dao;

import com.youxu.business.pojo.DocumentPrintPriceList;
import com.youxu.business.pojo.DocumentPrintPriceListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocumentPrintPriceListMapper {
    long countByExample(DocumentPrintPriceListExample example);

    int deleteByExample(DocumentPrintPriceListExample example);

    int insert(DocumentPrintPriceList record);

    int insertSelective(DocumentPrintPriceList record);

    List<DocumentPrintPriceList> selectByExample(DocumentPrintPriceListExample example);

    int updateByExampleSelective(@Param("record") DocumentPrintPriceList record, @Param("example") DocumentPrintPriceListExample example);

    int updateByExample(@Param("record") DocumentPrintPriceList record, @Param("example") DocumentPrintPriceListExample example);
}