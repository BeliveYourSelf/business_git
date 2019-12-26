package com.youxu.business.dao;

import com.youxu.business.pojo.SuperAdminDocumentSize;
import com.youxu.business.pojo.SuperAdminDocumentSizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SuperAdminDocumentSizeMapper {
    long countByExample(SuperAdminDocumentSizeExample example);

    int deleteByExample(SuperAdminDocumentSizeExample example);

    int deleteByPrimaryKey(Integer documentSizeId);

    int insert(SuperAdminDocumentSize record);

    int insertSelective(SuperAdminDocumentSize record);

    List<SuperAdminDocumentSize> selectByExample(SuperAdminDocumentSizeExample example);

    SuperAdminDocumentSize selectByPrimaryKey(Integer documentSizeId);

    int updateByExampleSelective(@Param("record") SuperAdminDocumentSize record, @Param("example") SuperAdminDocumentSizeExample example);

    int updateByExample(@Param("record") SuperAdminDocumentSize record, @Param("example") SuperAdminDocumentSizeExample example);

    int updateByPrimaryKeySelective(SuperAdminDocumentSize record);

    int updateByPrimaryKey(SuperAdminDocumentSize record);
    // 查看文档尺寸大小
    List<SuperAdminDocumentSize> selectDocumentSize(@Param("storeId") String storeId);
}