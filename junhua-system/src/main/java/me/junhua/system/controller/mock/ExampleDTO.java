package me.junhua.system.controller.mock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExampleDTO {

    @JsonProperty("id")
    private String id;
    @JsonProperty("author")
    private String author;
    @JsonProperty("title")
    private String title;
    @JsonProperty("content")
    private String content;
    @JsonProperty("importance")
    private Integer importance;
    @JsonProperty("display_time")
    private String displayTime;
    @JsonProperty("pageviews")
    private Integer pageviews;
}
