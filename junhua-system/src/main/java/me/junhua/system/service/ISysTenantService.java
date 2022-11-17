package me.junhua.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.junhua.system.dto.CreateTenantDTO;
import me.junhua.system.dto.QueryTenantDTO;
import me.junhua.system.dto.UpdateTenantDTO;
import me.junhua.system.entity.SysTenant;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 租户信息表 服务类
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
public interface ISysTenantService extends IService<SysTenant> {

    Page<SysTenant> selectTenantList(QueryTenantDTO queryTenantDTO, Page<SysTenant> page);

    Long createTenant(CreateTenantDTO createTenantDTO);

    boolean updateTenant(UpdateTenantDTO updateTenantDTO);

    boolean deleteTenant(Long tenantId);
}
