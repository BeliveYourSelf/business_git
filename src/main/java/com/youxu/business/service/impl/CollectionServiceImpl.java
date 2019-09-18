package com.youxu.business.service.impl;

import com.youxu.business.dao.CollectionMapper;
import com.youxu.business.pojo.Collection;
import com.youxu.business.service.CollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Resource
    private CollectionMapper collectionMapper;

    @Override
    public Integer insertCollection(Collection collection) {
        return collectionMapper.insertCollection(collection);
    }
}
