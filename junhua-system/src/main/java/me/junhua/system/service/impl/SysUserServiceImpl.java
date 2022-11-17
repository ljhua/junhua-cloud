package me.junhua.system.service.impl;

import me.junhua.system.entity.SysUser;
import me.junhua.system.mapper.SysUserMapper;
import me.junhua.system.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
