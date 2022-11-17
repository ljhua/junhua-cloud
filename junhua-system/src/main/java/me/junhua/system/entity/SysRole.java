package me.junhua.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
@TableName("sys_role")
@ApiModel(value = "SysRole对象", description = "角色表")
@Data
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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
