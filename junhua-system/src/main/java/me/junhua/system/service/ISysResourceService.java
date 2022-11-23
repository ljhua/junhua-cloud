package me.junhua.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.junhua.system.dto.query.QueryResourceDTO;
import me.junhua.system.dto.save.CreateResourceDTO;
import me.junhua.system.dto.update.UpdateResourceDTO;
import me.junhua.system.dto.view.ResourceDTO;
import me.junhua.system.dto.view.ResourceTreeNode;
import me.junhua.system.entity.SysResource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author ljhua
 * @since 2022-11-21
 */
public interface ISysResourceService extends IService<SysResource> {

    Page<ResourceDTO> selectPageList(Page<ResourceDTO> page, QueryResourceDTO queryResourceDTO);

    List<ResourceDTO> selectByPid(Long pid);

    boolean saveResource(CreateResourceDTO createResourceDTO);

    boolean updateResource(UpdateResourceDTO updateResourceDTO);

    int countByPid(Long pid);

    List<ResourceTreeNode> findResourceTreeNodeList();
}
