package com.youxu.business.dao;

import com.youxu.business.pojo.DeliverySchedule;
import com.youxu.business.pojo.DeliveryScheduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeliveryScheduleMapper {
    long countByExample(DeliveryScheduleExample example);

    int deleteByExample(DeliveryScheduleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DeliverySchedule record);

    int insertSelective(DeliverySchedule record);

    List<DeliverySchedule> selectByExample(DeliveryScheduleExample example);

    DeliverySchedule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DeliverySchedule record, @Param("example") DeliveryScheduleExample example);

    int updateByExample(@Param("record") DeliverySchedule record, @Param("example") DeliveryScheduleExample example);

    int updateByPrimaryKeySelective(DeliverySchedule record);

    int updateByPrimaryKey(DeliverySchedule record);
    // 根据id查询时间点
    List<DeliverySchedule> selAutomaticGeneration(@Param("storeId") Integer storeId);
}