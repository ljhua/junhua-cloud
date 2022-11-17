package me.junhua.system.controller.mock;

import me.junhua.common.result.GenericPage;
import me.junhua.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExampleController {

    @GetMapping("/example/list")
    public Result<GenericPage<ExampleDTO>> exampleList(Integer pageSize, Integer pageIndex) {
        GenericPage<ExampleDTO> page = new GenericPage<>();
        page.setTotalRows(200);
        List<ExampleDTO> exampleDTOList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ExampleDTO exampleDTO = new ExampleDTO();
            exampleDTO.setId("id" + i);
            exampleDTO.setAuthor("author" + i);
            exampleDTO.setTitle("title" + i);
            exampleDTO.setContent("content" + i);
            exampleDTO.setImportance(0);
            exampleDTO.setDisplayTime("");
            exampleDTO.setPageviews(0);
            exampleDTOList.add(exampleDTO);
        }
        page.setList(exampleDTOList);
        return Result.data(page);
    }
}
