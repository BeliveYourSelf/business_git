package com.youxu.business.dao;

import com.youxu.business.pojo.Document;
import com.youxu.business.pojo.DocumentExample;
import java.util.List;
import com.youxu.business.pojo.Folder;
import org.apache.ibatis.annotations.Param;

public interface DocumentMapper {
    long countByExample(DocumentExample example);

    int deleteByExample(DocumentExample example);

    int insert(Document record);

    int insertSelective(Document record);

    List<Document> selectByExample(DocumentExample example);

    int updateByExampleSelective(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByExample(@Param("record") Document record, @Param("example") DocumentExample example);
    // 查看文件夹下一级文件列表
    List<Document> selectDocument(@Param("record") Folder record);
    // 删除文件
    Integer deleteDocumentList(@Param("documentListId")List<Integer> documentListId);

    // 移动文件到某个文件夹
    Integer updateMoveDocument(@Param("folder") Folder folder);
    // 支付后转存
    Integer insertDocument(@Param("documentList") List<Document> documentList);
    // 查看文件集合模糊查找
    List<Document> selectDocumentByLike(@Param("userId") String userId, @Param("resourceName") String resourceName);
    // 查看最近上传的文件
    List<Document> selectRecentFileByUserId(@Param("userId")String userId);
    // 更新文件名称通过文件id
    Integer updateDocumentNameByDocumentId(@Param("documentId") String documentId,@Param("documentName") String documentName);
}