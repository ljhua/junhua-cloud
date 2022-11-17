package me.junhua.system.controller.mock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserInfo {
    @JsonProperty("roles")
    private List<String> roles;
    @JsonProperty("introduction")
    private String introduction;
    @JsonProperty("avatar")
    private String avatar;
    @JsonProperty("name")
    private String name;
}
