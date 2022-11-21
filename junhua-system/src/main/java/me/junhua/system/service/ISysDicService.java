package me.junhua.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.junhua.system.dto.view.DicDTO;
import me.junhua.system.dto.save.CreateDicDTO;
import me.junhua.system.dto.query.QueryDicDTO;
import me.junhua.system.dto.update.UpdateDicDTO;
import me.junhua.system.entity.SysDic;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 数据字典表 服务类
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
public interface ISysDicService extends IService<SysDic> {

    boolean updateDic(UpdateDicDTO updateDicDTO);

    boolean saveDic(CreateDicDTO createDicDTO);

    boolean batchDelete(List<Long> dicIdList);

    Page<DicDTO> selectPageList(Page<DicDTO> page, QueryDicDTO queryDicDTO);

    int countByPid(Long pid);

    List<DicDTO> selectByPid(Long pid);

    List<SysDic> getChildrenByDicCode(String dicCode);
}
