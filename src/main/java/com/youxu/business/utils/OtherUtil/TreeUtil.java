package com.youxu.business.utils.OtherUtil;



import com.youxu.business.pojo.Folder;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

//用List构建带有层次结构的json数据
//List父子节点构造树形Json
public class TreeUtil {
    //将list集合转成树形结构的list集合
    public static List<Folder> listToTree(List<Folder> list) {
        //用递归找子。
        List<Folder> treeList = new ArrayList<Folder>();
        for (Folder tree : list) {
            if (StringUtils.isEmpty(tree.getFolderParentId())) {
                treeList.add(findChildren(tree, list));
            }
        }
        return treeList;
    }

    //寻找子节点
    private static Folder findChildren(Folder tree, List<Folder> list) {
        for (Folder node : list) {
            if (!StringUtils.isEmpty(node.getFolderParentId()) && node.getFolderParentId().equals(tree.getId())) {
                if (tree.getFolderList() == null) {
                    tree.setFolderList(new ArrayList<Folder>());
                }
                tree.getFolderList().add(findChildren(node, list));
            }
        }
        return tree;
    }

}
