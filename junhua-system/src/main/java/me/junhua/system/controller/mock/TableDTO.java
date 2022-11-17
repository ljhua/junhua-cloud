package me.junhua.system.controller.mock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TableDTO {
    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("status")
    private String status;
    @JsonProperty("author")
    private String author;
    @JsonProperty("display_time")
    private String displayTime;
    @JsonProperty("pageviews")
    private Integer pageviews;
}
