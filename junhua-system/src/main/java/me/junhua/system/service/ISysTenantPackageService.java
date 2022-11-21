package me.junhua.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.junhua.system.dto.query.QueryTenantPackageDTO;
import me.junhua.system.dto.save.CreateTenantPackageDTO;
import me.junhua.system.dto.view.TenantPackageDTO;
import me.junhua.system.dto.update.UpdateTenantPackageDTO;
import me.junhua.system.entity.SysTenantPackage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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

    Page<TenantPackageDTO> selectPageList(Page<TenantPackageDTO> page, QueryTenantPackageDTO queryTenantPackageDTO);

    boolean saveTenantPackage(CreateTenantPackageDTO createTenantPackageDTO);

    boolean updateTenantPackage(UpdateTenantPackageDTO updateTenantPackageDTO);

    boolean batchDelete(List<Long> idList);
}
