package com.youxu.business.dao;

import com.youxu.business.pojo.Picture;
import com.youxu.business.pojo.PictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PictureMapper {
    long countByExample(PictureExample example);

    int deleteByExample(PictureExample example);

    int insert(Picture record);

    int insertSelective(Picture record);

    List<Picture> selectByExample(PictureExample example);

    int updateByExampleSelective(@Param("record") Picture record, @Param("example") PictureExample example);

    int updateByExample(@Param("record") Picture record, @Param("example") PictureExample example);

    int insertPictureMapper(@Param("pictureUrlList")List<String> pictureUrlList);

    int insertPictureMapperOverWrite(@Param("pictureList")List<Picture> pictureList);
}