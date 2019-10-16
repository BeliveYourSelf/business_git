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
    // 支付后转存    todo ceshi**********
    Integer insertDocument(@Param("document")Document document,@Param("documentUrlList") List<String> documentUrlList);
    // 查看文件集合模糊查找
    List<Document> selectDocumentByLike(@Param("userId") String userId, @Param("resourceName") String resourceName);
}