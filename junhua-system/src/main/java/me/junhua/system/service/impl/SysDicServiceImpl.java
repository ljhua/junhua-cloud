package me.junhua.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import me.junhua.common.util.BeanCopierUtils;
import me.junhua.system.dto.DicDTO;
import me.junhua.system.dto.QueryDicDTO;
import me.junhua.system.dto.SaveDicDTO;
import me.junhua.system.dto.UpdateDicDTO;
import me.junhua.system.entity.SysDic;
import me.junhua.system.mapper.SysDicMapper;
import me.junhua.system.service.ISysDicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 数据字典表 服务实现类
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
@Service
@RequiredArgsConstructor
public class SysDicServiceImpl extends ServiceImpl<SysDicMapper, SysDic> implements ISysDicService {

    private final SysDicMapper dicMapper;

    @Override
    public boolean updateDic(UpdateDicDTO updateDicDTO) {
        SysDic dic = BeanCopierUtils.copyByClass(updateDicDTO, SysDic.class);
        return this.updateById(dic);
    }

    @Override
    public boolean saveDic(SaveDicDTO saveDicDTO) {
        SysDic dic = BeanCopierUtils.copyByClass(saveDicDTO, SysDic.class);
        return this.save(dic);
    }

    @Transactional
    @Override
    public boolean deleteDic(Long dicId) {
        // 删除子级
        Wrapper<SysDic> wrapper = Wrappers.lambdaQuery(SysDic.class).eq(SysDic::getParentId, dicId);
        this.remove(wrapper);
        // 删除
        this.removeById(dicId);
        return true;
    }

    @Override
    public boolean batchDeleteDic(List<Long> dicIdList) {
        // 删除子级
        Wrapper<SysDic> wrapper = Wrappers.lambdaQuery(SysDic.class).in(SysDic::getParentId, dicIdList);
        this.remove(wrapper);
        // 删除
        this.removeByIds(dicIdList);
        return true;
    }

    @Override
    public Page<DicDTO> selectDicList(Page<DicDTO> dicPageDTO, QueryDicDTO queryDicDTO) {
        Page<DicDTO> dicPageList = dicMapper.getDicPageList(dicPageDTO, queryDicDTO);
        List<DicDTO> records = dicPageList.getRecords();
        records.stream().forEach(dicDTO -> {
            Long id = dicDTO.getId();
            int count = this.countByPid(id);
            if (count > 0) {
                dicDTO.setHasChildren(true);
            }
        });
        return dicPageList;
    }

    @Override
    public int countByPid(Long pid) {
        Wrapper<SysDic> wrapper = Wrappers.lambdaQuery(SysDic.class).eq(SysDic::getParentId, pid);
        return this.count(wrapper);
    }

    @Override
    public List<DicDTO> selectDicByPid(Long pid) {
        return dicMapper.selectDicByPid(pid);
    }
}
