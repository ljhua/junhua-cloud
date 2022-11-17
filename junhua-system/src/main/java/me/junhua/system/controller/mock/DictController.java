package me.junhua.system.controller.mock;

import me.junhua.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DictController {

    @GetMapping("/dict/list")
    public Result<DictDTO> dictList() {
        DictDTO dictDTO = new DictDTO();
        List<DictDTO.ImportanceDTO> importanceDTOList = new ArrayList<>();
        DictDTO.ImportanceDTO importanceDTO0 = new DictDTO.ImportanceDTO();
        importanceDTO0.setValue(0);
        importanceDTO0.setLabel("tableDemo.commonly");
        importanceDTOList.add(importanceDTO0);

        DictDTO.ImportanceDTO importanceDTO1 = new DictDTO.ImportanceDTO();
        importanceDTO1.setValue(0);
        importanceDTO1.setLabel("tableDemo.good");
        importanceDTOList.add(importanceDTO1);

        DictDTO.ImportanceDTO importanceDTO2 = new DictDTO.ImportanceDTO();
        importanceDTO2.setValue(0);
        importanceDTO2.setLabel("tableDemo.important");
        importanceDTOList.add(importanceDTO2);

        dictDTO.setImportance(importanceDTOList);
        return Result.data(dictDTO);
    }
}
