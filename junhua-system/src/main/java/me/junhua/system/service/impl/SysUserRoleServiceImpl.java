package me.junhua.system.service.impl;

import me.junhua.system.entity.SysUserRole;
import me.junhua.system.mapper.SysUserRoleMapper;
import me.junhua.system.service.ISysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author ljhua
 * @since 2022-11-12
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

}
