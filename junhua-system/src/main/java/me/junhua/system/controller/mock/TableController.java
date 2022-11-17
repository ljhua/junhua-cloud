package me.junhua.system.controller.mock;

import me.junhua.common.result.GenericPage;
import me.junhua.common.result.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TableController {

    @CrossOrigin
    @GetMapping("/vue-admin-template/table/list")
    public Result<GenericPage<TableDTO>> xx() {
        GenericPage<TableDTO> page = new GenericPage<>();
        page.setTotalRows(200);
        List<TableDTO> tableDTOList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            TableDTO tableDTO = new TableDTO();
            tableDTO.setId("id" + i);
            tableDTO.setTitle("title" + i);
            tableDTO.setStatus("status" + i);
            tableDTO.setAuthor("author" + i);
            tableDTO.setDisplayTime("");
            tableDTO.setTitle("title" + i);
            tableDTO.setPageviews(0);
            tableDTOList.add(tableDTO);
        }
        page.setList(tableDTOList);
        return Result.data(page);
    }
}
