package me.junhua.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 数据字典表
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
@Data
@TableName("sys_dic")
@ApiModel(value = "SysDic对象", description = "数据字典表")
public class SysDic extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("字典上级")
    private Long parentId;

    @ApiModelProperty("所有上级字典id的集合，便于查找")
    private String ancestors;

    @ApiModelProperty("字典名称")
    private String dicName;

    @ApiModelProperty("字典值")
    private String dicCode;

    @ApiModelProperty("排序")
    private Integer dicOrder;

    @ApiModelProperty("1有效，0禁用")
    private Integer dicStatus;

    @ApiModelProperty("备注")
    private String comments;
}
