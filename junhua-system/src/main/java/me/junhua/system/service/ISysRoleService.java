package me.junhua.system.service;

import me.junhua.system.dto.save.CreateRoleDTO;
import me.junhua.system.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
public interface ISysRoleService extends IService<SysRole> {

    void assignRoleResource(Long roleId, Set<Long> resourceIds);

    Long createRole(CreateRoleDTO createRoleDTO, Integer type);
}
