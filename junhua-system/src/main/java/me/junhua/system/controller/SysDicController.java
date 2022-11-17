package me.junhua.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import me.junhua.common.result.GenericPage;
import me.junhua.common.result.PageResult;
import me.junhua.common.result.Result;
import me.junhua.system.dto.DicDTO;
import me.junhua.system.dto.QueryDicDTO;
import me.junhua.system.dto.SaveDicDTO;
import me.junhua.system.dto.UpdateDicDTO;
import me.junhua.system.entity.SysDic;
import me.junhua.system.service.ISysDicService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
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
        Page<DicDTO> dicPage = dicService.selectDicList(page, queryDicDTO);
        return Result.data(PageResult.data(dicPage.getTotal(), dicPage.getRecords()));
    }

    @GetMapping(value = "/getDicByPid")
    @ApiOperation(value = "查询子级列表")
    public Result<List<DicDTO>> getPage(Long pid) {
        List<DicDTO> dicList = dicService.selectDicByPid(pid);
        return Result.data(dicList);
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "新建字典")
    public Result<Boolean> save(@Validated @RequestBody SaveDicDTO saveDicDTO) {
        boolean result = dicService.saveDic(saveDicDTO);
        return Result.data(result);
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新字典")
    public Result<Boolean> update(@Validated @RequestBody UpdateDicDTO updateDicDTO) {
        boolean result = dicService.updateDic(updateDicDTO);
        return Result.data(result);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "查询字典")
    public Result<SysDic> detail(@RequestParam Long dicId) {
        SysDic dic = dicService.getById(dicId);
        return Result.data(dic);
    }

    @PostMapping("/status/{dicId}/{dicStatus}")
    @ApiOperation(value = "修改字典状态")
    public Result<Boolean> updateStatus(@PathVariable Long dicId, @PathVariable Integer dicStatus) {
        if (null == dicId || StringUtils.isEmpty(dicStatus)) {
            return Result.error("ID和状态不能为空");
        }
        UpdateDicDTO updateDicDTO = new UpdateDicDTO();
        updateDicDTO.setId(dicId);
        updateDicDTO.setDicStatus(dicStatus);
        boolean result = dicService.updateDic(updateDicDTO);
        return Result.data(result);
    }

    @PostMapping(value = "/delete/{dicId}")
    @ApiOperation(value = "删除字典")
    public Result<Boolean> delete(@PathVariable Long dicId) {
        if (null == dicId) {
            return Result.error("ID不能为空");
        }
        boolean result = dicService.deleteDic(dicId);
        return Result.data(result);
    }

    @PostMapping("/batch/delete")
    @ApiOperation(value = "批量删除字典")
    public Result<Boolean> batchDelete(@RequestBody List<Long> dicIdList) {
        if (CollectionUtils.isEmpty(dicIdList)) {
            return Result.error("请选中要删除的数据！");
        }
        boolean result = dicService.batchDeleteDic(dicIdList);
        return Result.data(result);
    }
}
