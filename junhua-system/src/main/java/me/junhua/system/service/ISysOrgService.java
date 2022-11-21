package me.junhua.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.junhua.system.dto.view.OrgDTO;
import me.junhua.system.dto.query.QueryOrgDTO;
import me.junhua.system.dto.save.CreateOrgDTO;
import me.junhua.system.dto.update.UpdateOrgDTO;
import me.junhua.system.entity.SysOrg;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 组织表 服务类
 * </p>
 *
 * @author ljhua
 * @since 2022-11-12
 */
public interface ISysOrgService extends IService<SysOrg> {

    Page<OrgDTO> selectPageList(Page<OrgDTO> page, QueryOrgDTO queryOrgDTO);

    List<OrgDTO> selectByPid(Long pid);

    int countByPid(Long id);

    boolean saveOrg(CreateOrgDTO createOrgDTO);

    boolean updateOrg(UpdateOrgDTO updateOrgDTO);

    boolean batchDelete(List<Long> idList);
}
