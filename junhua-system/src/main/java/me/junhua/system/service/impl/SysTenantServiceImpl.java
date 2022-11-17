package me.junhua.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import me.junhua.common.util.BeanCopierUtils;
import me.junhua.system.dto.CreateTenantDTO;
import me.junhua.system.dto.QueryTenantDTO;
import me.junhua.system.dto.RoleCreateDTO;
import me.junhua.system.dto.UpdateTenantDTO;
import me.junhua.system.entity.SysTenant;
import me.junhua.system.entity.SysTenantPackage;
import me.junhua.system.mapper.SysTenantMapper;
import me.junhua.system.service.ISysRoleService;
import me.junhua.system.service.ISysTenantPackageService;
import me.junhua.system.service.ISysTenantService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * 租户信息表 服务实现类
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
@Service
@RequiredArgsConstructor
public class SysTenantServiceImpl extends ServiceImpl<SysTenantMapper, SysTenant> implements ISysTenantService {

    private final SysTenantMapper tenantMapper;

    private final ISysTenantPackageService tenantPackageService;
    private final ISysRoleService roleService;

    @Override
    public Page<SysTenant> selectTenantList(QueryTenantDTO queryTenantDTO, Page<SysTenant> page) {
        Wrapper<SysTenant> wrapper = Wrappers.lambdaQuery(SysTenant.class)
                .like(StringUtils.isNotBlank(queryTenantDTO.getTenantName()), SysTenant::getTenantName, queryTenantDTO.getTenantName())
                .like(StringUtils.isNotBlank(queryTenantDTO.getContacts()), SysTenant::getContacts, queryTenantDTO.getContacts())
                .eq(StringUtils.isNotBlank(queryTenantDTO.getContactNumber()), SysTenant::getContactNumber, queryTenantDTO.getContactNumber())
                .eq(Objects.nonNull(queryTenantDTO.getTenantStatus()), SysTenant::getTenantStatus, queryTenantDTO.getTenantStatus());
        return tenantMapper.selectPage(page, wrapper);
    }

    @Override
    public Long createTenant(CreateTenantDTO createTenantDTO) {
        SysTenantPackage tenantPackage = tenantPackageService.validTenantPackage(createTenantDTO.getTenantPackageId());
        SysTenant tenant = BeanCopierUtils.copyByClass(createTenantDTO, SysTenant.class);
        // 存储租户信息
        this.save(tenant);
        // 创建角色
        Long roleId = createRole(tenantPackage);
        // 创建用户，并分配角色
        createUser(roleId, createTenantDTO);
        return tenant.getId();
    }

    private void createUser(Long roleId, CreateTenantDTO createTenantDTO) {
    }

    private Long createRole(SysTenantPackage tenantPackage) {
        // 创建角色
        RoleCreateDTO roleCreateDTO = new RoleCreateDTO();
        roleCreateDTO.setRoleName("租户管理员");
        roleCreateDTO.setComments("系统自动生成");

        Long roleId = roleService.createRole(roleCreateDTO, 12);
        // 分配权限
        roleService.assignRoleResource(roleId, tenantPackage.getResourceIds());
        return roleId;
    }

    @Override
    public boolean updateTenant(UpdateTenantDTO updateTenantDTO) {
        SysTenant tenant = BeanCopierUtils.copyByClass(updateTenantDTO, SysTenant.class);
        return this.updateById(tenant);
    }

    @Override
    public boolean deleteTenant(Long tenantId) {
        return this.removeById(tenantId);
    }
}
