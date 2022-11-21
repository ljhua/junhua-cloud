package me.junhua.system.dto.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreateRoleDTO {

    @ApiModelProperty("父id")
    private Long parentId;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色标识")
    private String roleKey;

    @ApiModelProperty("角色级别")
    private Integer roleLevel;

    @ApiModelProperty("1有效，0禁用")
    private Integer roleStatus;

    @ApiModelProperty("角色数据权限类型,默认只能查询本人数据")
    private String dataPermissionType;

    @ApiModelProperty("描述")
    private String comments;
}
