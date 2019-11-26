package com.youxu.business.service;

import com.youxu.business.pojo.IdPhotoSerachHistory;

import java.util.List;

public interface IdPhotoSerachHistoryService {
    void insertHistoryByUserId(String userId, String serachName);

    List<IdPhotoSerachHistory> getIdPhotoSerachHistoryByUserId(String userId);
}
