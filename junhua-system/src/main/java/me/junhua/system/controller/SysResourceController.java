package me.junhua.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import me.junhua.common.result.GenericPage;
import me.junhua.common.result.PageResult;
import me.junhua.common.result.Result;
import me.junhua.common.util.TreeUtil;
import me.junhua.system.dto.query.QueryResourceDTO;
import me.junhua.system.dto.save.CreateResourceDTO;
import me.junhua.system.dto.update.UpdateResourceDTO;
import me.junhua.system.dto.view.ResourceDTO;
import me.junhua.system.dto.view.ResourceTreeNode;
import me.junhua.system.service.ISysResourceService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author ljhua
 * @since 2022-11-21
 */
@RestController
@RequestMapping("/sysResource")
@RequiredArgsConstructor
public class SysResourceController {

    private final ISysResourceService resourceService;

    @GetMapping(value = "/getPage")
    @ApiOperation(value = "分页列表")
    public Result<GenericPage<ResourceDTO>> getPage(QueryResourceDTO queryResourceDTO, Page<ResourceDTO> page) {
        Page<ResourceDTO> resourcePage = resourceService.selectPageList(page, queryResourceDTO);
        return Result.data(PageResult.data(resourcePage.getTotal(), resourcePage.getRecords()));
    }

    @GetMapping(value = "/findResourceTree")
    @ApiOperation(value = "查询资源树")
    public Result<List<ResourceTreeNode>> findResourceTree() {
        List<ResourceTreeNode> resourceTreeNodeList = resourceService.findResourceTreeNodeList();
        List<ResourceTreeNode> buildTree = TreeUtil.build(resourceTreeNodeList);
        return Result.data(buildTree);
    }

    @GetMapping(value = "/getByPid")
    @ApiOperation(value = "查询子级列表")
    public Result<List<ResourceDTO>> getByPid(Long pid) {
        List<ResourceDTO> resourceList = resourceService.selectByPid(pid);
        return Result.data(resourceList);
    }

    @PostMapping(value = "/create")
    @ApiOperation(value = "新增")
    public Result<Boolean> create(@Validated @RequestBody CreateResourceDTO createResourceDTO) {
        boolean result = resourceService.saveResource(createResourceDTO);
        return Result.data(result);
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新")
    public Result<Boolean> update(@Validated @RequestBody UpdateResourceDTO updateResourceDTO) {
        boolean result = resourceService.updateResource(updateResourceDTO);
        return Result.data(result);
    }
}
