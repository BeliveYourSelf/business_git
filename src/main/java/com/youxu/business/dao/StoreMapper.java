package com.youxu.business.dao;

import com.youxu.business.pojo.Store;
import com.youxu.business.pojo.StoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreMapper {
    long countByExample(StoreExample example);

    int deleteByExample(StoreExample example);

    int insert(Store record);

    int insertSelective(Store record);

    List<Store> selectByExample(StoreExample example);

    int updateByExampleSelective(@Param("record") Store record, @Param("example") StoreExample example);

    int updateByExample(@Param("record") Store record, @Param("example") StoreExample example);
    // 查看所有店铺表
    List<Store> selectStoreList();
    // 查看店铺信息通过id
    Store selectByStoreId(@Param("storeId") Integer storeId);
}