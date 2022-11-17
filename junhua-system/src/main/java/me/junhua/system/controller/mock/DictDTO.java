package me.junhua.system.controller.mock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DictDTO {

    @JsonProperty("importance")
    private List<ImportanceDTO> importance;

    @Data
    public static class ImportanceDTO {
        @JsonProperty("value")
        private Integer value;
        @JsonProperty("label")
        private String label;
    }
}
