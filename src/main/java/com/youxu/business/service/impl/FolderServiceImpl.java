package com.youxu.business.service.impl;

import com.youxu.business.dao.FolderMapper;
import com.youxu.business.pojo.Folder;
import com.youxu.business.service.FolderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FolderServiceImpl implements FolderService {
    @Resource
    private FolderMapper folderMapper;
    @Override
    public Integer insertFolder(Folder folder) {
        return folderMapper.insertFolder(folder);
    }

    @Override
    public Integer updateFolder(Folder folder) {
        return folderMapper.updateFolder(folder);
    }
}
