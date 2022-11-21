package me.junhua.system.service.impl;

import me.junhua.system.dto.save.CreateRoleDTO;
import me.junhua.system.entity.SysRole;
import me.junhua.system.mapper.SysRoleMapper;
import me.junhua.system.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Override
    public void assignRoleResource(Long roleId, Set<Long> resourceIds) {

    }

    @Override
    public Long createRole(CreateRoleDTO createRoleDTO, Integer type) {
        return null;
    }
}
