package com.youxu.business.dao;

import com.youxu.business.pojo.Share;
import com.youxu.business.pojo.ShareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShareMapper {
    long countByExample(ShareExample example);

    int deleteByExample(ShareExample example);

    int insert(Share record);

    int insertSelective(Share record);

    List<Share> selectByExample(ShareExample example);

    int updateByExampleSelective(@Param("record") Share record, @Param("example") ShareExample example);

    int updateByExample(@Param("record") Share record, @Param("example") ShareExample example);
    // 新增分享表
    Integer insertShare(Share share);
    // 查看分享表通过id
    Share selectShareById(int shareId);
    // 查看分享通过用户id和分享码
    Share selectShareByUserIdAndExtactionCode(@Param("share")Share share);
    // 查看下载分享
    Share downloadShare(@Param("share")Share share);
}