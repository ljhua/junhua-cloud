package me.junhua.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.junhua.system.dto.query.QueryTenantPackageDTO;
import me.junhua.system.dto.view.TenantPackageDTO;
import me.junhua.system.entity.SysTenantPackage;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 租户套餐表 Mapper 接口
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
public interface SysTenantPackageMapper extends BaseMapper<SysTenantPackage> {

    Page<TenantPackageDTO> selectPageList(Page<TenantPackageDTO> page, @Param("tenantPackage") QueryTenantPackageDTO queryTenantPackageDTO);
}
