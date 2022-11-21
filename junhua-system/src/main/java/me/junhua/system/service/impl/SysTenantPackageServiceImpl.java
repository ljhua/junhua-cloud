package me.junhua.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import me.junhua.common.util.BeanCopierUtils;
import me.junhua.system.dto.query.QueryTenantPackageDTO;
import me.junhua.system.dto.save.CreateTenantPackageDTO;
import me.junhua.system.dto.update.UpdateTenantPackageDTO;
import me.junhua.system.dto.view.TenantPackageDTO;
import me.junhua.system.entity.SysTenantPackage;
import me.junhua.system.mapper.SysTenantPackageMapper;
import me.junhua.system.service.ISysTenantPackageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 租户套餐表 服务实现类
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
@Service
@RequiredArgsConstructor
public class SysTenantPackageServiceImpl extends ServiceImpl<SysTenantPackageMapper, SysTenantPackage> implements ISysTenantPackageService {

    private final SysTenantPackageMapper tenantPackageMapper;

    @Override
    public SysTenantPackage validTenantPackage(Long tenantPackageId) {
        return null;
    }

    @Override
    public Page<TenantPackageDTO> selectPageList(Page<TenantPackageDTO> page, QueryTenantPackageDTO queryTenantPackageDTO) {
        return tenantPackageMapper.selectPageList(page, queryTenantPackageDTO);
    }

    @Override
    public boolean saveTenantPackage(CreateTenantPackageDTO createTenantPackageDTO) {
        SysTenantPackage tenantPackage = BeanCopierUtils.copyByClass(createTenantPackageDTO, SysTenantPackage.class);
        tenantPackage.setCreatedTime(LocalDateTime.now());
        return this.save(tenantPackage);
    }

    @Override
    public boolean updateTenantPackage(UpdateTenantPackageDTO updateTenantPackageDTO) {
        SysTenantPackage tenantPackage = BeanCopierUtils.copyByClass(updateTenantPackageDTO, SysTenantPackage.class);
        tenantPackage.setModifiedTime(LocalDateTime.now());
        return this.updateById(tenantPackage);
    }

    @Transactional
    @Override
    public boolean batchDelete(List<Long> idList) {
        return false;
    }
}
