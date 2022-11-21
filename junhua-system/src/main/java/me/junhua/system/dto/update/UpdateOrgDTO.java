package me.junhua.system.dto.update;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UpdateOrgDTO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("父组织id")
    private Long parentId;

    @ApiModelProperty("所有上级组织id的集合，便于机构查找")
    private String ancestors;

    @ApiModelProperty("组织类型编码（字典）")
    private String orgTypeCode;

    @ApiModelProperty("组织类型名称（字典）")
    private String orgTypeName;

    @ApiModelProperty("组织名称")
    private String orgName;

    @ApiModelProperty("组织编码")
    private String orgCode;

    @ApiModelProperty("组织图标")
    private String orgIcon;

    @ApiModelProperty("组织级别（排序）")
    private Integer orgLevel;

    @ApiModelProperty("1有效，0禁用")
    private Integer orgStatus;

    @ApiModelProperty("省")
    private String province;

    @ApiModelProperty("市")
    private String city;

    @ApiModelProperty("区")
    private String area;

    @ApiModelProperty("街道")
    private String street;

    @ApiModelProperty("描述")
    private String comments;
}
