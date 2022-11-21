package me.junhua.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import me.junhua.common.result.GenericPage;
import me.junhua.common.result.PageResult;
import me.junhua.common.result.Result;
import me.junhua.system.dto.query.QueryTenantDTO;
import me.junhua.system.dto.save.CreateTenantDTO;
import me.junhua.system.dto.update.UpdateTenantDTO;
import me.junhua.system.entity.SysTenant;
import me.junhua.system.service.ISysTenantService;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        Page<SysTenant> tenantPage = tenantService.selectPageList(queryTenantDTO, page);
        return Result.data(PageResult.data(tenantPage.getTotal(), tenantPage.getRecords()));
    }

    @PostMapping(value = "/create")
    @ApiOperation(value = "新增")
    public Result<Long> create(@Validated @RequestBody CreateTenantDTO createTenantDTO) {
        Long tenantId = tenantService.saveTenant(createTenantDTO);
        return Result.data(tenantId);
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新")
    public Result<Boolean> update(@Validated @RequestBody UpdateTenantDTO updateTenantDTO) {
        boolean result = tenantService.updateTenant(updateTenantDTO);
        return Result.data(result);
    }

    @PostMapping("/batch/delete")
    @ApiOperation(value = "批量删除")
    public Result<Boolean> batchDelete(@RequestBody List<Long> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return Result.error("请选中要删除的数据！");
        }
        boolean result = tenantService.batchDelete(idList);
        return Result.data(result);
    }
}
