package com.youxu.business.dao;

import com.youxu.business.pojo.AccessToken;
import com.youxu.business.pojo.AccessTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccessTokenMapper {
    long countByExample(AccessTokenExample example);

    int deleteByExample(AccessTokenExample example);

    int insert(AccessToken record);

    int insertSelective(AccessToken record);

    List<AccessToken> selectByExample(AccessTokenExample example);

    int updateByExampleSelective(@Param("record") AccessToken record, @Param("example") AccessTokenExample example);

    int updateByExample(@Param("record") AccessToken record, @Param("example") AccessTokenExample example);
}