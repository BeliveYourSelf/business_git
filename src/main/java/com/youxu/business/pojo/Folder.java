package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Folder {
    private Integer id;

    private Integer userId;

    private Integer folderParentId;

    private String folderName;

    private Date createTime;

    private Date modifyTime;

    private Boolean status;

    // 新增属性用户vo
    private List<Folder> folderList;

    private List<Document> documentList;

    private List<Integer> documentListId;

    private List<Integer> folderListId;

}