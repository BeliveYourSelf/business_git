package com.youxu.business.dao;

import com.youxu.business.pojo.ServiceTime;
import com.youxu.business.pojo.ServiceTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceTimeMapper {
    long countByExample(ServiceTimeExample example);

    int deleteByExample(ServiceTimeExample example);

    int insert(ServiceTime record);

    int insertSelective(ServiceTime record);

    List<ServiceTime> selectByExample(ServiceTimeExample example);

    int updateByExampleSelective(@Param("record") ServiceTime record, @Param("example") ServiceTimeExample example);

    int updateByExample(@Param("record") ServiceTime record, @Param("example") ServiceTimeExample example);
    // 查看今天
    List<ServiceTime> selectServiceTime(@Param("storeId")Integer storeId, @Param("dayType") Integer dayType);
    // 查看明后天
    List<ServiceTime> selectServiceTimeAllDay(@Param("storeId")Integer storeId, @Param("dayType") Integer dayType, @Param("serviceType") Integer serviceType);

}