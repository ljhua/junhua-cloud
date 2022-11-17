package me.junhua.system.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import me.junhua.system.entity.SysDic;

@Data
public class QueryDicDTO extends SysDic {
    @ApiModelProperty(value = "开始时间")
    private String beginDateTime;

    @ApiModelProperty(value = "结束时间")
    private String endDateTime;
}
