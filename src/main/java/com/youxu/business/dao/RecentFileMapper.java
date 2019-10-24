package com.youxu.business.dao;

import com.youxu.business.pojo.RecentFile;
import com.youxu.business.pojo.RecentFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecentFileMapper {
    long countByExample(RecentFileExample example);

    int deleteByExample(RecentFileExample example);

    int insert(RecentFile record);

    int insertSelective(RecentFile record);

    List<RecentFile> selectByExample(RecentFileExample example);

    int updateByExampleSelective(@Param("record") RecentFile record, @Param("example") RecentFileExample example);

    int updateByExample(@Param("record") RecentFile record, @Param("example") RecentFileExample example);
    // 查看最近10个近期文件
    List<RecentFile> selectRecentFileByUserId(@Param("userId") String userId);
}