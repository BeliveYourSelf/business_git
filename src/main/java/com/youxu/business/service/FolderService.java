package com.youxu.business.service;

import com.youxu.business.pojo.Folder;

import java.util.List;

public interface FolderService {
    Integer insertFolder(Folder folder);

    Integer updateFolder(Folder folder);

    Folder selectFolderCatalog(Folder folder);

    List<Folder> selectFolderAndDocument(Folder folder);

    Folder selectFolderAndDocumentByUserIdAndFolderId(Folder folder);

    Integer deleteFolderAndDocumentByUserIdAndFolderIdListAndDocumentListId(Folder folder);

    Integer updateMoveFolderAndDocument(Folder folder);
}
