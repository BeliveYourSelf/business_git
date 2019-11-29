package com.youxu.business.dao;

import com.youxu.business.pojo.UserWallet;
import com.youxu.business.pojo.UserWalletExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserWalletMapper {
    long countByExample(UserWalletExample example);

    int deleteByExample(UserWalletExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserWallet record);

    int insertSelective(UserWallet record);

    List<UserWallet> selectByExample(UserWalletExample example);

    UserWallet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserWallet record, @Param("example") UserWalletExample example);

    int updateByExample(@Param("record") UserWallet record, @Param("example") UserWalletExample example);

    int updateByPrimaryKeySelective(UserWallet record);

    int updateByPrimaryKey(UserWallet record);
    // 根据用户id查看积分
    UserWallet selectUserWalletByUserId(@Param("userId") Integer userId);
    // 更新用户积分
    int updateUserWallet(@Param("userWallet") UserWallet userWallet);

}