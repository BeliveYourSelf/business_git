package com.youxu.business.dao;

import com.youxu.business.pojo.DocumentCoverColor;
import com.youxu.business.pojo.DocumentCoverColorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocumentCoverColorMapper {
    long countByExample(DocumentCoverColorExample example);

    int deleteByExample(DocumentCoverColorExample example);

    int insert(DocumentCoverColor record);

    int insertSelective(DocumentCoverColor record);

    List<DocumentCoverColor> selectByExample(DocumentCoverColorExample example);

    int updateByExampleSelective(@Param("record") DocumentCoverColor record, @Param("example") DocumentCoverColorExample example);

    int updateByExample(@Param("record") DocumentCoverColor record, @Param("example") DocumentCoverColorExample example);
    // 查看文档封面颜色
    List<DocumentCoverColor> selectDocumentCoverColorByStoreId(@Param("storeId")String storeId);
}