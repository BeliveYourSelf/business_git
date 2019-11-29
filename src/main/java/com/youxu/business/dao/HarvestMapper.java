package com.youxu.business.dao;

import com.youxu.business.pojo.Harvest;
import com.youxu.business.pojo.HarvestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HarvestMapper {
    long countByExample(HarvestExample example);

    int deleteByExample(HarvestExample example);

    int insert(Harvest record);

    int insertSelective(Harvest record);

    List<Harvest> selectByExample(HarvestExample example);

    int updateByExampleSelective(@Param("record") Harvest record, @Param("example") HarvestExample example);

    int updateByExample(@Param("record") Harvest record, @Param("example") HarvestExample example);
    // 新增收获地址
    Integer insertHarvestAddress(Harvest harvest);
    // 编辑收获地址
    Integer updateHarvestAddress(@Param("record")Harvest record);
    // 查看一个收获地址
    Harvest selectOneHarvestAddress(@Param("id")Integer id);
    // 查看收获地址集合
    List<Harvest> selectHarvestAddressList(@Param("harvest") Harvest harvest);
}