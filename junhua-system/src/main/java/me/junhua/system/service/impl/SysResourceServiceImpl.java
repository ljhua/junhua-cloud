package me.junhua.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import me.junhua.common.util.BeanCopierUtils;
import me.junhua.system.dto.query.QueryResourceDTO;
import me.junhua.system.dto.save.CreateResourceDTO;
import me.junhua.system.dto.update.UpdateResourceDTO;
import me.junhua.system.dto.view.ResourceDTO;
import me.junhua.system.dto.view.ResourceTreeNode;
import me.junhua.system.entity.SysResource;
import me.junhua.system.mapper.SysResourceMapper;
import me.junhua.system.service.ISysResourceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author ljhua
 * @since 2022-11-21
 */
@Service
@RequiredArgsConstructor
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements ISysResourceService {

    private final SysResourceMapper resourceMapper;

    @Override
    public Page<ResourceDTO> selectPageList(Page<ResourceDTO> page, QueryResourceDTO queryResourceDTO) {
        Page<ResourceDTO> resourcePage = resourceMapper.selectPageList(page, queryResourceDTO);
        List<ResourceDTO> records = resourcePage.getRecords();
        records.stream().forEach(resourceDTO -> {
            Long id = resourceDTO.getId();
            int count = this.countByPid(id);
            if (count > 0) {
                resourceDTO.setHasChildren(true);
            }
        });
        return resourcePage;
    }

    @Override
    public List<ResourceDTO> selectByPid(Long pid) {
        List<ResourceDTO> resourceList = resourceMapper.selectByPid(pid);
        resourceList.stream().forEach(resourceDTO -> {
            Long id = resourceDTO.getId();
            int count = this.countByPid(id);
            if (count > 0) {
                resourceDTO.setHasChildren(true);
            }
        });
        return resourceList;
    }

    @Override
    public boolean saveResource(CreateResourceDTO createResourceDTO) {
        SysResource resource = BeanCopierUtils.copyByClass(createResourceDTO, SysResource.class);
        return this.save(resource);
    }

    @Override
    public boolean updateResource(UpdateResourceDTO updateResourceDTO) {
        SysResource resource = BeanCopierUtils.copyByClass(updateResourceDTO, SysResource.class);
        return this.updateById(resource);
    }

    @Override
    public int countByPid(Long pid) {
        Wrapper<SysResource> wrapper = Wrappers.lambdaQuery(SysResource.class).eq(SysResource::getParentId, pid);
        return this.count(wrapper);
    }

    @Override
    public List<ResourceTreeNode> findResourceTreeNodeList() {
        return resourceMapper.findResourceTreeNodeList();
    }
}
