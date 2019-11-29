package com.youxu.business.service.impl;

import com.youxu.business.dao.RecentFileMapper;
import com.youxu.business.pojo.RecentFile;
import com.youxu.business.service.RecentFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RecentFileServiceImpl implements RecentFileService {
    @Resource
    private RecentFileMapper recentFileMapper;

    @Override
    public List<RecentFile> selectRecentFileByUserId(String userId) {
        return recentFileMapper.selectRecentFileByUserId(userId);
    }
}
