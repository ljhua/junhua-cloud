package me.junhua.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import me.junhua.common.result.GenericPage;
import me.junhua.common.result.PageResult;
import me.junhua.common.result.Result;
import me.junhua.system.dto.query.QueryDicDTO;
import me.junhua.system.dto.save.CreateDicDTO;
import me.junhua.system.dto.update.UpdateDicDTO;
import me.junhua.system.dto.view.DicDTO;
import me.junhua.system.entity.SysDic;
import me.junhua.system.service.ISysDicService;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 数据字典表 前端控制器
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
@RestController
@RequestMapping("/sysDic")
@RequiredArgsConstructor
public class SysDicController {

    private final ISysDicService dicService;

    @GetMapping(value = "/getPage")
    @ApiOperation(value = "分页列表")
    public Result<GenericPage<DicDTO>> getPage(QueryDicDTO queryDicDTO, Page<DicDTO> page) {
        Page<DicDTO> dicPage = dicService.selectPageList(page, queryDicDTO);
        return Result.data(PageResult.data(dicPage.getTotal(), dicPage.getRecords()));
    }

    @GetMapping(value = "/getByPid")
    @ApiOperation(value = "通过pid查询子级列表")
    public Result<List<DicDTO>> getByPid(Long pid) {
        List<DicDTO> dicList = dicService.selectByPid(pid);
        return Result.data(dicList);
    }

    @GetMapping(value = "/getChildrenByDicCode")
    @ApiOperation(value = "通过dicCode查询子级列表")
    public Result<List<SysDic>> getChildrenByDicCode(String dicCode) {
        List<SysDic> dicList = dicService.getChildrenByDicCode(dicCode);
        return Result.data(dicList);
    }

    @PostMapping(value = "/create")
    @ApiOperation(value = "新增")
    public Result<Boolean> create(@Validated @RequestBody CreateDicDTO createDicDTO) {
        boolean result = dicService.saveDic(createDicDTO);
        return Result.data(result);
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新")
    public Result<Boolean> update(@Validated @RequestBody UpdateDicDTO updateDicDTO) {
        boolean result = dicService.updateDic(updateDicDTO);
        return Result.data(result);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public Result<SysDic> detail(@RequestParam Long id) {
        SysDic dic = dicService.getById(id);
        return Result.data(dic);
    }

    @PostMapping("/batch/delete")
    @ApiOperation(value = "批量删除")
    public Result<Boolean> batchDelete(@RequestBody List<Long> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return Result.error("请选中要删除的数据！");
        }
        boolean result = dicService.batchDelete(idList);
        return Result.data(result);
    }
}
