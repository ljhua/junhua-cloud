package me.junhua.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.junhua.system.dto.DicDTO;
import me.junhua.system.dto.SaveDicDTO;
import me.junhua.system.dto.QueryDicDTO;
import me.junhua.system.dto.UpdateDicDTO;
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

    boolean saveDic(SaveDicDTO saveDicDTO);

    boolean deleteDic(Long dicId);

    boolean batchDeleteDic(List<Long> dicIdList);

    Page<DicDTO> selectDicList(Page<DicDTO> page, QueryDicDTO queryDicDTO);

    int countByPid(Long pid);

    List<DicDTO> selectDicByPid(Long pid);
}
