package me.junhua.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import me.junhua.common.util.BeanCopierUtils;
import me.junhua.system.dto.view.OrgDTO;
import me.junhua.system.dto.query.QueryOrgDTO;
import me.junhua.system.dto.save.CreateOrgDTO;
import me.junhua.system.dto.update.UpdateOrgDTO;
import me.junhua.system.entity.SysOrg;
import me.junhua.system.mapper.SysOrgMapper;
import me.junhua.system.service.ISysOrgService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 组织表 服务实现类
 * </p>
 *
 * @author ljhua
 * @since 2022-11-12
 */
@Service
@RequiredArgsConstructor
public class SysOrgServiceImpl extends ServiceImpl<SysOrgMapper, SysOrg> implements ISysOrgService {

    private final SysOrgMapper orgMapper;

    @Override
    public Page<OrgDTO> selectPageList(Page<OrgDTO> page, QueryOrgDTO queryOrgDTO) {
        Page<OrgDTO> orgPage = orgMapper.selectPageList(page, queryOrgDTO);
        List<OrgDTO> records = orgPage.getRecords();
        records.stream().forEach(orgDTO -> {
            Long id = orgDTO.getId();
            int count = this.countByPid(id);
            if (count > 0) {
                orgDTO.setHasChildren(true);
            }
        });
        return orgPage;
    }

    @Override
    public List<OrgDTO> selectByPid(Long pid) {
        List<OrgDTO> orgList = orgMapper.selectByPid(pid);
        orgList.stream().forEach(orgDTO -> {
            Long id = orgDTO.getId();
            int count = this.countByPid(id);
            if (count > 0) {
                orgDTO.setHasChildren(true);
            }
        });
        return orgList;
    }

    @Override
    public int countByPid(Long pid) {
        Wrapper<SysOrg> wrapper = Wrappers.lambdaQuery(SysOrg.class).eq(SysOrg::getParentId, pid);
        return this.count(wrapper);
    }

    @Override
    public boolean saveOrg(CreateOrgDTO createOrgDTO) {
        SysOrg org = BeanCopierUtils.copyByClass(createOrgDTO, SysOrg.class);
        return this.save(org);
    }

    @Override
    public boolean updateOrg(UpdateOrgDTO updateOrgDTO) {
        SysOrg org = BeanCopierUtils.copyByClass(updateOrgDTO, SysOrg.class);
        return this.updateById(org);
    }

    @Transactional
    @Override
    public boolean batchDelete(List<Long> idList) {
        return false;
    }
}
