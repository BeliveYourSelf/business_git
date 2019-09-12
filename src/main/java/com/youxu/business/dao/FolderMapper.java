package com.youxu.business.dao;

import com.youxu.business.pojo.Folder;
import com.youxu.business.pojo.FolderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FolderMapper {
    long countByExample(FolderExample example);

    int deleteByExample(FolderExample example);

    int insert(Folder record);

    int insertSelective(Folder record);

    List<Folder> selectByExample(FolderExample example);

    int updateByExampleSelective(@Param("record") Folder record, @Param("example") FolderExample example);

    int updateByExample(@Param("record") Folder record, @Param("example") FolderExample example);
    // 新建文件夹
    Integer insertFolder(@Param("record") Folder record);
    // 更新文件夹
    Integer updateFolder(@Param("record") Folder record);
}