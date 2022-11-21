package me.junhua.system.dto.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Set;

@Data
public class CreateTenantPackageDTO {

    @ApiModelProperty("套餐名称")
    private String name;

    @ApiModelProperty("套餐状态 '0'禁用，'1' 启用,")
    private Integer status;

    @ApiModelProperty("关联的菜单ID")
    private Set<Long> resourceIds;
}
