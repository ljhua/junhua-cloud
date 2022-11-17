package me.junhua.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 机构用户表
 * </p>
 *
 * @author ljhua
 * @since 2022-11-12
 */
@TableName("sys_org_user")
@ApiModel(value = "SysOrgUser对象", description = "机构用户表")
public class SysOrgUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("机构id")
    private Long orgId;

    @ApiModelProperty("用户id")
    private Long userId;
}
