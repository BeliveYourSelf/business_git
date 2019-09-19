package com.youxu.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.youxu.business.dao.CollectionMapper;
import com.youxu.business.pojo.Collection;
import com.youxu.business.service.CollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Resource
    private CollectionMapper collectionMapper;

    @Override
    public Integer insertCollection(Collection collection) {
        return collectionMapper.insertCollection(collection);
    }

    @Override
    public PageInfo<Collection> selectCollection(Collection collection) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(collection.getPageNo(), collection.getPageSize());
        List<Collection> collectionList = collectionMapper.selectCollection(collection);
        PageInfo<Collection> objectPageInfo = new PageInfo<Collection>(collectionList);
        return objectPageInfo;
    }

    @Override
    public Integer deleteCollection(String[] arrayCollectionId) {
        List<String> strings = Arrays.asList(arrayCollectionId);
        Integer deleteCollection= collectionMapper.deleteCollection(strings);
        return deleteCollection;
    }
}
