package com.youxu.business.dao;

import com.youxu.business.pojo.PhotoRinsePriceList;
import com.youxu.business.pojo.PhotoRinsePriceListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhotoRinsePriceListMapper {
    long countByExample(PhotoRinsePriceListExample example);

    int deleteByExample(PhotoRinsePriceListExample example);

    int insert(PhotoRinsePriceList record);

    int insertSelective(PhotoRinsePriceList record);

    List<PhotoRinsePriceList> selectByExample(PhotoRinsePriceListExample example);

    int updateByExampleSelective(@Param("record") PhotoRinsePriceList record, @Param("example") PhotoRinsePriceListExample example);

    int updateByExample(@Param("record") PhotoRinsePriceList record, @Param("example") PhotoRinsePriceListExample example);
    // 查看照片冲印价格表
    List<PhotoRinsePriceList> selectPhotoRinsePriceList(String storeId);
}