package me.junhua.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import me.junhua.system.mybatis.JsonLongSetTypeHandler;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * <p>
 * 租户套餐表
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
@TableName("sys_tenant_package")
@ApiModel(value = "SysTenantPackage对象", description = "租户套餐表")
@Data
public class SysTenantPackage extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("套餐名称")
    private String name;

    @ApiModelProperty("套餐状态 '0'禁用，'1' 启用,")
    private Integer status;

    @ApiModelProperty("关联的菜单ID")
    @TableField(typeHandler = JsonLongSetTypeHandler.class)
    private Set<Long> resourceIds;
}
