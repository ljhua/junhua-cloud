package me.junhua.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author ljhua
 * @since 2022-11-12
 */
@TableName("sys_district")
@ApiModel(value = "SysDistrict对象", description = "")
@Data
public class SysDistrict implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Long parentId;

    private String initial;

    private String initials;

    private String pinyin;

    private String suffix;

    private String code;

    private Integer order;
}
