package me.junhua.common.util;


import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreeUtil {

    /**
     * 此方法可以直接构建树形列表（TreeNode要继承ITreeNode）
     *
     * @param treeNodes
     * @param <T>
     * @return
     */
    public static <T extends ITreeNode<T, ? extends Serializable>> List<T> build(List<T> treeNodes) {
        if (CollectionUtils.isEmpty(treeNodes)) {
            return treeNodes;
        }
        List<Serializable> selfIdEqSelfParent = new ArrayList<>();
        for (T parent : treeNodes) {
            Serializable id = parent.getId();
            for (T children : treeNodes) {
                if (parent != children) {
                    if (id.equals(children.getParentId())) {
                        parent.initChildren();
                        parent.getChildren().add(children);
                    }
                } else if (id.equals(parent.getParentId())) {

                    selfIdEqSelfParent.add(id);
                }
            }
        }
        // 找出根节点集合
        List<T> trees = new ArrayList<>();

        List<Serializable> allIds = new ArrayList<>();
        for (T baseNode : treeNodes) {
            allIds.add(baseNode.getId());
        }

        for (T baseNode : treeNodes) {
            if (!allIds.contains(baseNode.getParentId()) || selfIdEqSelfParent.contains(baseNode.getParentId())) {
                trees.add(baseNode);
            }
        }
        return trees;
    }
}
