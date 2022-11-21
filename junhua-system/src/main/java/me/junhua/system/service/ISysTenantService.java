package me.junhua.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import me.junhua.system.dto.query.QueryTenantDTO;
import me.junhua.system.dto.save.CreateTenantDTO;
import me.junhua.system.dto.update.UpdateTenantDTO;
import me.junhua.system.entity.SysTenant;

import java.util.List;

/**
 * <p>
 * 租户信息表 服务类
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
public interface ISysTenantService extends IService<SysTenant> {

    Page<SysTenant> selectPageList(QueryTenantDTO queryTenantDTO, Page<SysTenant> page);

    Long saveTenant(CreateTenantDTO createTenantDTO);

    boolean updateTenant(UpdateTenantDTO updateTenantDTO);

    boolean batchDelete(List<Long> idList);
}
