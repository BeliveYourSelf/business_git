package com.youxu.business.dao;

import com.youxu.business.pojo.Collection;
import com.youxu.business.pojo.CollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectionMapper {
    long countByExample(CollectionExample example);

    int deleteByExample(CollectionExample example);

    int insert(Collection record);

    int insertSelective(Collection record);

    List<Collection> selectByExample(CollectionExample example);

    int updateByExampleSelective(@Param("record") Collection record, @Param("example") CollectionExample example);

    int updateByExample(@Param("record") Collection record, @Param("example") CollectionExample example);
    // 新增收藏
    Integer insertCollection(@Param("collectionList") List<Collection> collectionList);
    // 查看收藏列表
    List<Collection> selectCollection(@Param("collection") Collection collection);
    // 查看所有收藏列表
    List<Collection> selectCollectionAll();
    // 删除收藏列表
    Integer deleteCollection(@Param("ids") List<String> ids);
    // 更新收藏有效期
    Integer updateCollectionEffectiveTime();
}