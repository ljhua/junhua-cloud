package me.junhua.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import me.junhua.common.result.GenericPage;
import me.junhua.common.result.PageResult;
import me.junhua.common.result.Result;
import me.junhua.system.dto.query.QueryTenantPackageDTO;
import me.junhua.system.dto.save.CreateTenantPackageDTO;
import me.junhua.system.dto.view.TenantPackageDTO;
import me.junhua.system.dto.update.UpdateTenantPackageDTO;
import me.junhua.system.entity.SysTenantPackage;
import me.junhua.system.service.ISysTenantPackageService;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 租户套餐表 前端控制器
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
@RestController
@RequestMapping("/sysTenantPackage")
@RequiredArgsConstructor
public class SysTenantPackageController {

    private final ISysTenantPackageService tenantPackageService;

    @GetMapping(value = "/getPage")
    @ApiOperation(value = "分页列表")
    public Result<GenericPage<TenantPackageDTO>> getPage(QueryTenantPackageDTO queryTenantPackageDTO, Page<TenantPackageDTO> page) {
        Page<TenantPackageDTO> tenantPackagePage = tenantPackageService.selectPageList(page, queryTenantPackageDTO);
        return Result.data(PageResult.data(tenantPackagePage.getTotal(), tenantPackagePage.getRecords()));
    }

    @PostMapping(value = "/create")
    @ApiOperation(value = "新增")
    public Result<Boolean> create(@Validated @RequestBody CreateTenantPackageDTO createTenantPackageDTO) {
        boolean result = tenantPackageService.saveTenantPackage(createTenantPackageDTO);
        return Result.data(result);
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新")
    public Result<Boolean> update(@Validated @RequestBody UpdateTenantPackageDTO updateTenantPackageDTO) {
        boolean result = tenantPackageService.updateTenantPackage(updateTenantPackageDTO);
        return Result.data(result);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "查询详情")
    public Result<SysTenantPackage> detail(@RequestParam Long tenantPackageId) {
        SysTenantPackage tenantPackage = tenantPackageService.getById(tenantPackageId);
        return Result.data(tenantPackage);
    }

    @PostMapping("/batch/delete")
    @ApiOperation(value = "批量删除")
    public Result<Boolean> batchDelete(@RequestBody List<Long> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return Result.error("请选中要删除的数据！");
        }
        boolean result = tenantPackageService.batchDelete(idList);
        return Result.data(result);
    }
}
