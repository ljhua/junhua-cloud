package me.junhua.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import me.junhua.common.util.BeanCopierUtils;
import me.junhua.system.dto.query.QueryDicDTO;
import me.junhua.system.dto.save.CreateDicDTO;
import me.junhua.system.dto.update.UpdateDicDTO;
import me.junhua.system.dto.view.DicDTO;
import me.junhua.system.entity.SysDic;
import me.junhua.system.mapper.SysDicMapper;
import me.junhua.system.service.ISysDicService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        dic.setModifiedTime(LocalDateTime.now());
        return this.updateById(dic);
    }

    @Override
    public boolean saveDic(CreateDicDTO createDicDTO) {
        SysDic dic = BeanCopierUtils.copyByClass(createDicDTO, SysDic.class);
        dic.setCreatedTime(LocalDateTime.now());
        return this.save(dic);
    }

    @Override
    public boolean batchDelete(List<Long> dicIdList) {
        // 删除子级
        Wrapper<SysDic> wrapper = Wrappers.lambdaQuery(SysDic.class).in(SysDic::getParentId, dicIdList);
        this.remove(wrapper);
        // 删除
        this.removeByIds(dicIdList);
        return true;
    }

    @Override
    public Page<DicDTO> selectPageList(Page<DicDTO> dicPageDTO, QueryDicDTO queryDicDTO) {
        Page<DicDTO> dicPage = dicMapper.selectPageList(dicPageDTO, queryDicDTO);
        List<DicDTO> records = dicPage.getRecords();
        records.stream().forEach(dicDTO -> {
            Long id = dicDTO.getId();
            int count = this.countByPid(id);
            if (count > 0) {
                dicDTO.setHasChildren(true);
            }
        });
        return dicPage;
    }

    @Override
    public int countByPid(Long pid) {
        Wrapper<SysDic> wrapper = Wrappers.lambdaQuery(SysDic.class).eq(SysDic::getParentId, pid);
        return this.count(wrapper);
    }

    @Override
    public List<DicDTO> selectByPid(Long pid) {
        return dicMapper.selectByPid(pid);
    }

    @Override
    public List<SysDic> getChildrenByDicCode(String dicCode) {
        return dicMapper.getChildrenByDicCode(dicCode);
    }
}
