package com.youxu.business.service;


import com.github.pagehelper.PageInfo;
import com.youxu.business.pojo.Collection;

import java.util.List;

public interface CollectionService {
    Integer insertCollection(List<Collection> collectionList);

    PageInfo<Collection> selectCollection(Collection collection);

    Integer deleteCollection(String[] arrayCollectionId);
}
