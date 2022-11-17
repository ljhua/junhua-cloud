package me.junhua.system.service.impl;

import me.junhua.system.entity.SysTenantPackage;
import me.junhua.system.mapper.SysTenantPackageMapper;
import me.junhua.system.service.ISysTenantPackageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租户套餐表 服务实现类
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
@Service
public class SysTenantPackageServiceImpl extends ServiceImpl<SysTenantPackageMapper, SysTenantPackage> implements ISysTenantPackageService {

    @Override
    public SysTenantPackage validTenantPackage(Long tenantPackageId) {
        return null;
    }
}
