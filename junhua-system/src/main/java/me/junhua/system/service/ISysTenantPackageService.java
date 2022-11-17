package me.junhua.system.service;

import me.junhua.system.entity.SysTenantPackage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 租户套餐表 服务类
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
public interface ISysTenantPackageService extends IService<SysTenantPackage> {

    SysTenantPackage validTenantPackage(Long tenantPackageId);
}
