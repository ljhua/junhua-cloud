package me.junhua.system.dto.update;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UpdateResourceDTO {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("父id")
    private Long parentId;

    @ApiModelProperty("所有上级资源id的集合，便于查找")
    private String ancestors;

    @ApiModelProperty("资源名称")
    private String resourceName;

    @ApiModelProperty("资源标识")
    private String resourceKey;

    @ApiModelProperty("资源类型编码（字典）")
    private String resourceTypeCode;

    @ApiModelProperty("资源类型名称（字典）")
    private String resourceTypeName;

    @ApiModelProperty("资源图标")
    private String resourceIcon;

    @ApiModelProperty("资源路径")
    private String resourcePath;

    @ApiModelProperty("资料链接")
    private String resourceUrl;

    @ApiModelProperty("资源级别")
    private Integer resourceLevel;

    @ApiModelProperty("是否显示")
    private Boolean resourceShow;

    @ApiModelProperty("是否缓存")
    private Boolean resourceCache;

    @ApiModelProperty("资源页面名称")
    private String resourcePageName;

    @ApiModelProperty("1有效，0禁用")
    private Integer resourceStatus;

    @ApiModelProperty("备注")
    private String comments;
}
