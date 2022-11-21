package me.junhua.system.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.junhua.system.dto.view.OrgDTO;
import me.junhua.system.dto.query.QueryOrgDTO;
import me.junhua.system.entity.SysOrg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 组织表 Mapper 接口
 * </p>
 *
 * @author ljhua
 * @since 2022-11-12
 */
public interface SysOrgMapper extends BaseMapper<SysOrg> {

    Page<OrgDTO> selectPageList(Page<OrgDTO> page, @Param("org") QueryOrgDTO queryOrgDTO);

    List<OrgDTO> selectByPid(Long pid);
}
