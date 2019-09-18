package com.youxu.business.service;


import com.github.pagehelper.PageInfo;
import com.youxu.business.pojo.Collection;

import java.util.List;

public interface CollectionService {
    Integer insertCollection(Collection collection);

    PageInfo<Collection> selectCollection(Collection collection);
}
