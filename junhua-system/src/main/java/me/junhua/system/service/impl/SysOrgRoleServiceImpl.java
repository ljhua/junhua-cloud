package me.junhua.system.service.impl;

import me.junhua.system.entity.SysOrgRole;
import me.junhua.system.mapper.SysOrgRoleMapper;
import me.junhua.system.service.ISysOrgRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 可以给组织权限，在该组织下的所有用户都有此权限 服务实现类
 * </p>
 *
 * @author ljhua
 * @since 2022-11-12
 */
@Service
public class SysOrgRoleServiceImpl extends ServiceImpl<SysOrgRoleMapper, SysOrgRole> implements ISysOrgRoleService {

}
