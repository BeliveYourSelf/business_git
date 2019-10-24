package com.youxu.business.service;

import com.youxu.business.pojo.RecentFile;
import org.springframework.stereotype.Service;

import java.util.List;
public interface RecentFileService {
    List<RecentFile> selectRecentFileByUserId(String userId);

}
