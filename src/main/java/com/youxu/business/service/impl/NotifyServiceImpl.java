package com.youxu.business.service.impl;

import com.youxu.business.dao.NotifyMapper;
import com.youxu.business.pojo.Notify;
import com.youxu.business.service.NotifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class NotifyServiceImpl implements NotifyService {
    @Resource
    private NotifyMapper notifyMapper;

    @Override
    public Notify selectNofity() {
        return notifyMapper.selectNofity();
    }
}
