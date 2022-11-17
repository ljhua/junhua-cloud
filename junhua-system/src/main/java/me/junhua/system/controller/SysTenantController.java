package me.junhua.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import me.junhua.common.result.GenericPage;
import me.junhua.common.result.PageResult;
import me.junhua.common.result.Result;
import me.junhua.system.dto.CreateTenantDTO;
import me.junhua.system.dto.QueryTenantDTO;
import me.junhua.system.dto.UpdateTenantDTO;
import me.junhua.system.entity.SysTenant;
import me.junhua.system.service.ISysTenantService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 租户信息表 前端控制器
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
@RestController
@RequestMapping("/sysTenant")
@RequiredArgsConstructor
public class SysTenantController {

    private final ISysTenantService tenantService;

    @GetMapping(value = "/getPage")
    @ApiOperation(value = "分页列表")
    public Result<GenericPage<SysTenant>> getPage(QueryTenantDTO queryTenantDTO, Page<SysTenant> page) {
        Page<SysTenant> tenantPage = tenantService.selectTenantList(queryTenantDTO, page);
        return Result.data(PageResult.data(tenantPage.getTotal(), tenantPage.getRecords()));
    }

    @PostMapping(value = "/create")
    @ApiOperation(value = "新建租户")
    public Result<Long> create(@Validated @RequestBody CreateTenantDTO createTenantDTO) {
        Long tenantId = tenantService.createTenant(createTenantDTO);
        return Result.data(tenantId);
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新租户")
    public Result<Boolean> update(@Validated @RequestBody UpdateTenantDTO updateTenantDTO) {
        boolean result = tenantService.updateTenant(updateTenantDTO);
        return Result.data(result);
    }

    @PostMapping(value = "/delete/{tenantId}")
    @ApiOperation(value = "删除租户")
    public Result<Boolean> delete(@PathVariable Long tenantId) {
        if (null == tenantId) {
            return Result.error("ID不能为空");
        }
        boolean result = tenantService.deleteTenant(tenantId);
        return Result.data(result);
    }
}
