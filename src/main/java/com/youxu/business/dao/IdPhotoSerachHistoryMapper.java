package com.youxu.business.dao;

import com.youxu.business.pojo.IdPhotoSerachHistory;
import com.youxu.business.pojo.IdPhotoSerachHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IdPhotoSerachHistoryMapper {
    long countByExample(IdPhotoSerachHistoryExample example);

    int deleteByExample(IdPhotoSerachHistoryExample example);

    int insert(IdPhotoSerachHistory record);

    int insertSelective(IdPhotoSerachHistory record);

    List<IdPhotoSerachHistory> selectByExample(IdPhotoSerachHistoryExample example);

    int updateByExampleSelective(@Param("record") IdPhotoSerachHistory record, @Param("example") IdPhotoSerachHistoryExample example);

    int updateByExample(@Param("record") IdPhotoSerachHistory record, @Param("example") IdPhotoSerachHistoryExample example);
    // 新增搜索历史
    void insertHistoryByUserId(@Param("userId") String userId, @Param("serachName") String serachName );
    // 获取证件照搜索历史通过用户id
    List<IdPhotoSerachHistory> getIdPhotoSerachHistoryByUserId(@Param("userId") String userId);
}