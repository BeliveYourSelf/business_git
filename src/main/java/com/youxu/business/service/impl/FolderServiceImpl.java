package com.youxu.business.service.impl;

import com.youxu.business.dao.DocumentMapper;
import com.youxu.business.dao.FolderMapper;
import com.youxu.business.pojo.Document;
import com.youxu.business.pojo.Folder;
import com.youxu.business.service.FolderService;
import com.youxu.business.utils.OtherUtil.TreeUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

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
        Folder folderContainer = folderMapper.selectFolderById(id);
        List<Folder> folders = folderMapper.selectFolderCatalog(folder);
        List<Document> documents = documentMapper.selectDocument(folder);
        folderContainer.setFolderList(folders);
        folderContainer.setDocumentList(documents);
        return folderContainer;
    }

    @Override
    public List<Folder> selectFolderAndDocument(Folder folder) {
        List<Folder> folders = folderMapper.selectFolderAndDocument(folder);
        List<Folder> foldersNew = TreeUtil.listToTree(folders);
        return foldersNew;
    }

    @Override
    public Folder selectFolderAndDocumentByUserIdAndFolderId(Folder folder) {
        List<Folder> folders = folderMapper.selectFolderAndDocument(folder);
        List<Folder> foldersListNew = TreeUtil.listToTree(folders);
        Folder getFolderAndDocumentByIdAndUserId = null;
        // 从总文件目录中获取某一文件目录文件及文件夹
        for (Folder folderNew : foldersListNew) {
            if (folderNew.getId() == folder.getId()) {
                return folderNew;
            }
            getFolderAndDocumentByIdAndUserId = getFolderAndDocumentByIdAndUserId(folderNew.getFolderList(), folder.getId());
        }
        return getFolderAndDocumentByIdAndUserId;
    }

    @Override
    public Integer deleteFolderAndDocumentByUserIdAndFolderIdListAndDocumentListId(Folder folder) {
        List<Integer> folderListId = folder.getFolderListId();
        List<Integer> documentListId = folder.getDocumentListId();
        // 删除文件夹
        if (folderListId.size() >= 1) {
            Integer deleteFolderList = folderMapper.deleteFolderList(folderListId);
        }
        // 删除文件
        if (documentListId.size() >= 1) {
            Integer deleteDocumentList = documentMapper.deleteDocumentList(documentListId);
        }
        return 1;
    }

    @Override
    public Integer updateMoveFolderAndDocument(Folder folder) {
        Integer updateMoveFolder = folderMapper.updateMoveFolder(folder);
        Integer updateMoveDocument = documentMapper.updateMoveDocument(folder);
        return updateMoveFolder + updateMoveDocument;
    }

    @Override
    public Map<String, List<Object>> selectFolderAndDocumentByLike(String userId, String resourceName) {
        HashMap<String, List<Object>> stringListHashMap = new HashMap<>();
        List<Folder> selectFolderByLike= folderMapper.selectFolderByLike(userId, resourceName);
        List<Document> selectDocumentByLike = documentMapper.selectDocumentByLike(userId,resourceName);
        stringListHashMap.put("文件夹", Collections.singletonList(selectFolderByLike));
        stringListHashMap.put("文件集合", Collections.singletonList(selectDocumentByLike));
        return stringListHashMap;
    }

    /**
     * 递归：获取文件和文件夹通过文件夹id和用户id
     *
     * @param foldersNew
     * @param folderId
     * @return
     */
    private Folder getFolderAndDocumentByIdAndUserId(List<Folder> foldersNew, Integer folderId) {
        for (Folder folder : foldersNew) {
            if (folder.getId() == folderId) {
                return folder;
            }
            List<Folder> folderList = folder.getFolderList();
            if (folderList != null && folderList.size() >= 1 && folderList.get(0) != null) {
                return getFolderAndDocumentByIdAndUserId(folderList, folderId);
            }
        }
        return null;
    }
}
