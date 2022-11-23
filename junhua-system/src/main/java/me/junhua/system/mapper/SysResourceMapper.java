package me.junhua.system.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.junhua.system.dto.query.QueryResourceDTO;
import me.junhua.system.dto.view.ResourceDTO;
import me.junhua.system.dto.view.ResourceTreeNode;
import me.junhua.system.entity.SysResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author ljhua
 * @since 2022-11-21
 */
public interface SysResourceMapper extends BaseMapper<SysResource> {

    Page<ResourceDTO> selectPageList(Page<ResourceDTO> page, QueryResourceDTO queryResourceDTO);

    List<ResourceDTO> selectByPid(Long pid);

    List<ResourceTreeNode> findResourceTreeNodeList();
}
