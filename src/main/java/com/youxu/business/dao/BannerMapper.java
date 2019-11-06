package com.youxu.business.dao;

import com.youxu.business.pojo.Banner;
import com.youxu.business.pojo.BannerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BannerMapper {
    long countByExample(BannerExample example);

    int deleteByExample(BannerExample example);

    int insert(Banner record);

    int insertSelective(Banner record);

    List<Banner> selectByExampleWithBLOBs(BannerExample example);

    List<Banner> selectByExample(BannerExample example);

    int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByExampleWithBLOBs(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByExample(@Param("record") Banner record, @Param("example") BannerExample example);
    // 查看banner集合
    List<Banner> selectBannerList(@Param("contentType") String contentType);
    // 查看详细banner通过id
    Banner selectBannerById(@Param("id") String id);
}