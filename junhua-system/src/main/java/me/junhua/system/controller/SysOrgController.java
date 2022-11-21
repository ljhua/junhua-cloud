package me.junhua.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import me.junhua.common.result.GenericPage;
import me.junhua.common.result.PageResult;
import me.junhua.common.result.Result;
import me.junhua.system.dto.query.QueryOrgDTO;
import me.junhua.system.dto.save.CreateOrgDTO;
import me.junhua.system.dto.update.UpdateOrgDTO;
import me.junhua.system.dto.view.OrgDTO;
import me.junhua.system.entity.SysOrg;
import me.junhua.system.service.ISysOrgService;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 组织表 前端控制器
 * </p>
 *
 * @author ljhua
 * @since 2022-11-12
 */
@RestController
@RequestMapping("/sysOrg")
@RequiredArgsConstructor
public class SysOrgController {

    private final ISysOrgService orgService;

    @GetMapping(value = "/getPage")
    @ApiOperation(value = "分页列表")
    public Result<GenericPage<OrgDTO>> getPage(QueryOrgDTO queryOrgDTO, Page<OrgDTO> page) {
        Page<OrgDTO> orgPage = orgService.selectPageList(page, queryOrgDTO);
        return Result.data(PageResult.data(orgPage.getTotal(), orgPage.getRecords()));
    }

    @GetMapping(value = "/getByPid")
    @ApiOperation(value = "查询子级列表")
    public Result<List<OrgDTO>> getByPid(Long pid) {
        List<OrgDTO> orgList = orgService.selectByPid(pid);
        return Result.data(orgList);
    }

    @PostMapping(value = "/create")
    @ApiOperation(value = "新增")
    public Result<Boolean> create(@Validated @RequestBody CreateOrgDTO createOrgDTO) {
        boolean result = orgService.saveOrg(createOrgDTO);
        return Result.data(result);
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新")
    public Result<Boolean> update(@Validated @RequestBody UpdateOrgDTO updateOrgDTO) {
        boolean result = orgService.updateOrg(updateOrgDTO);
        return Result.data(result);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public Result<SysOrg> detail(@RequestParam Long id) {
        SysOrg org = orgService.getById(id);
        return Result.data(org);
    }

    @PostMapping("/batch/delete")
    @ApiOperation(value = "批量删除")
    public Result<Boolean> batchDelete(@RequestBody List<Long> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return Result.error("请选中要删除的数据！");
        }
        boolean result = orgService.batchDelete(idList);
        return Result.data(result);
    }
}
