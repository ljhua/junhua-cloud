package me.junhua.system.service.impl;

import me.junhua.system.entity.SysRoleResource;
import me.junhua.system.mapper.SysRoleResourceMapper;
import me.junhua.system.service.ISysRoleResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和权限关联表 服务实现类
 * </p>
 *
 * @author ljhua
 * @since 2022-11-12
 */
@Service
public class SysRoleResourceServiceImpl extends ServiceImpl<SysRoleResourceMapper, SysRoleResource> implements ISysRoleResourceService {

}
