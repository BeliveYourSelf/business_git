package com.youxu.business.service.impl;

import com.youxu.business.dao.ShareMapper;
import com.youxu.business.pojo.Share;
import com.youxu.business.service.ShareService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShareServiceImpl implements ShareService {
    @Resource
    private ShareMapper shareMapper;
    @Override
    public Integer insertShare(Share share) {
        return shareMapper.insertShare(share);
    }
}
