package me.junhua.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 角色和权限关联表
 * </p>
 *
 * @author ljhua
 * @since 2022-11-12
 */
@TableName("sys_role_resource")
@ApiModel(value = "SysRoleResource对象", description = "角色和权限关联表")
public class SysRoleResource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("角色id")
    private Long roleId;

    @ApiModelProperty("资源id")
    private Long resourceId;
}
