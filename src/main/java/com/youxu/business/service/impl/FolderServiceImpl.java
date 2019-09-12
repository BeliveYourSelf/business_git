package com.youxu.business.service.impl;

import com.youxu.business.dao.DocumentMapper;
import com.youxu.business.dao.FolderMapper;
import com.youxu.business.pojo.Document;
import com.youxu.business.pojo.Folder;
import com.youxu.business.service.FolderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FolderServiceImpl implements FolderService {
    @Resource
    private FolderMapper folderMapper;
    @Resource
    private DocumentMapper documentMapper;
    @Override
    public Integer insertFolder(Folder folder) {
        return folderMapper.insertFolder(folder);
    }

    @Override
    public Integer updateFolder(Folder folder) {
        return folderMapper.updateFolder(folder);
    }

    @Override
    public Folder selectFolderCatalog(Folder folder) {
        Integer id = folder.getId();
        Folder folderContainer  = folderMapper.selectFolderById(id);
        List<Folder> folders = folderMapper.selectFolderCatalog(folder);
        List<Document> documents= documentMapper.selectDocument(folder);
        folderContainer.setFolderList(folders);
        folderContainer.setDocumentList(documents);
        return folderContainer;
    }
}
