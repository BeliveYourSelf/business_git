package com.youxu.business.service.impl;

import com.youxu.business.dao.IdPhotoSerachHistoryMapper;
import com.youxu.business.pojo.IdPhotoSerachHistory;
import com.youxu.business.service.IdPhotoSerachHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IdPhotoSerachHistoryServiceImpl implements IdPhotoSerachHistoryService {
    @Resource
    private IdPhotoSerachHistoryMapper idPhotoSerachHistoryMapper;

    @Override
    public void insertHistoryByUserId(String userId, String serachName) {
        idPhotoSerachHistoryMapper.insertHistoryByUserId(userId, serachName);
    }

    @Override
    public List<IdPhotoSerachHistory> getIdPhotoSerachHistoryByUserId(String userId) {
        return idPhotoSerachHistoryMapper.getIdPhotoSerachHistoryByUserId(userId);
    }
}
