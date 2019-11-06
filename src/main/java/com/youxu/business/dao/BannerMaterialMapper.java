package com.youxu.business.dao;

import com.youxu.business.pojo.BannerMaterial;
import com.youxu.business.pojo.BannerMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BannerMaterialMapper {
    long countByExample(BannerMaterialExample example);

    int deleteByExample(BannerMaterialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BannerMaterial record);

    int insertSelective(BannerMaterial record);

    List<BannerMaterial> selectByExampleWithBLOBs(BannerMaterialExample example);

    List<BannerMaterial> selectByExample(BannerMaterialExample example);

    BannerMaterial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BannerMaterial record, @Param("example") BannerMaterialExample example);

    int updateByExampleWithBLOBs(@Param("record") BannerMaterial record, @Param("example") BannerMaterialExample example);

    int updateByExample(@Param("record") BannerMaterial record, @Param("example") BannerMaterialExample example);

    int updateByPrimaryKeySelective(BannerMaterial record);

    int updateByPrimaryKeyWithBLOBs(BannerMaterial record);

    int updateByPrimaryKey(BannerMaterial record);
}