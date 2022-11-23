package me.junhua.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author ljhua
 * @since 2022-11-21
 */
@TableName("sys_resource")
@ApiModel(value = "SysResource对象", description = "权限表")
@Data
public class SysResource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("租户id")
    private Long tenantId;

    @ApiModelProperty("父id")
    private Long parentId;

    @ApiModelProperty("所有上级资源id的集合，便于查找")
    private String ancestors;

    @ApiModelProperty("资源名称-路由")
    private String name;

    @ApiModelProperty("资源类型编码（字典）")
    private String resourceTypeCode;

    @ApiModelProperty("资源类型名称（字典）")
    private String resourceTypeName;

    @ApiModelProperty("路由地址-路由")
    private String routerPath;

    @ApiModelProperty("组件路径-路由")
    private String routerComponent;

    @ApiModelProperty("菜单图标-路由")
    private String routerIcon;

    @ApiModelProperty("是否可见-路由")
    private Boolean routerVisible;

    @ApiModelProperty("是否缓存-路由")
    private Boolean routerKeepAlive;

    @ApiModelProperty("页面名称-路由")
    private String routerPageName;

    @ApiModelProperty("资源标识")
    private String permission;

    @ApiModelProperty("接口uri地址")
    private String uri;

    @ApiModelProperty("显示顺序")
    private Integer sort;

    @ApiModelProperty("1有效，0禁用")
    private Integer status;

    @ApiModelProperty("备注")
    private String comments;
}
