package me.junhua.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.junhua.system.dto.view.DicDTO;
import me.junhua.system.dto.query.QueryDicDTO;
import me.junhua.system.entity.SysDic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 数据字典表 Mapper 接口
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
public interface SysDicMapper extends BaseMapper<SysDic> {

    Page<DicDTO> selectPageList(Page<DicDTO> page, @Param("dic") QueryDicDTO dict);

    List<DicDTO> selectByPid(Long pid);

    List<SysDic> getChildrenByDicCode(String dicCode);
}
