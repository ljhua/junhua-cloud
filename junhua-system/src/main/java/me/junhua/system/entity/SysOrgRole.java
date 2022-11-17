package me.junhua.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 可以给组织权限，在该组织下的所有用户都有此权限
 * </p>
 *
 * @author ljhua
 * @since 2022-11-12
 */
@TableName("sys_org_role")
@ApiModel(value = "SysOrgRole对象", description = "可以给组织权限，在该组织下的所有用户都有此权限")
public class SysOrgRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("组织机构id")
    private Long orgId;

    @ApiModelProperty("角色id")
    private Long roleId;
}
