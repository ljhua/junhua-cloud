package me.junhua.system.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SaveDicDTO {

    @ApiModelProperty("字典上级")
    private Long parentId;

    @ApiModelProperty("所有上级字典id的集合，便于查找")
    private String ancestors;

    @ApiModelProperty("字典名称")
    @NotBlank(message = "字典名称不能为空")
    @Size(max = 40, message = "字典名称长度不能超过40个字符")
    private String dicName;

    @ApiModelProperty("字典编码")
    @NotBlank(message = "字典编码不能为空")
    @Size(max = 32, message = "字典编码长度不能超过32个字符")
    private String dicCode;

    @ApiModelProperty("排序")
    private Integer dicOrder;

    @ApiModelProperty("1有效，0禁用")
    private Integer dicStatus;

    @ApiModelProperty("备注")
    @Size(max = 255, message = "备注长度不能超过255个字符")
    private String comments;
}
