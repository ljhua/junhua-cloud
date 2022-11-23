package me.junhua.system.dto.view;

import lombok.Data;
import me.junhua.common.util.ITreeNode;

import java.util.List;

@Data
public class ResourceTreeNode implements ITreeNode<ResourceTreeNode, Long> {

    private Long id;
    private Long parentId;
    private String name;
    private List<ResourceTreeNode> children;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public Long getParentId() {
        return this.parentId;
    }

    @Override
    public List<ResourceTreeNode> getChildren() {
        return this.children;
    }

    @Override
    public void setChildren(List<ResourceTreeNode> children) {
        this.children = children;
    }
}
