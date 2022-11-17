package me.junhua.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 租户信息表
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
@TableName("sys_tenant")
@ApiModel(value = "SysTenant对象", description = "租户信息表")
@Data
public class SysTenant implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("租户名称")
    private String tenantName;

    @ApiModelProperty("域名")
    private String domainName;

    @ApiModelProperty("背景图片")
    private String backgroundImage;

    @ApiModelProperty("联系人")
    private String contacts;

    @ApiModelProperty("联系电话")
    private String contactNumber;

    @ApiModelProperty("联系地址")
    private String address;

    @ApiModelProperty("账号限额")
    private Long accountLimit;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("过期时间")
    private LocalDateTime expireTime;

    @ApiModelProperty("授权码")
    private String licenseKey;

    @ApiModelProperty("租户状态 '0'禁用，'1' 启用,")
    private Integer tenantStatus;

    @ApiModelProperty("备注")
    private String comments;

    @ApiModelProperty("创建者")
    private Long createdBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty("更新者")
    private Long modifiedBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("更新时间")
    private LocalDateTime modifiedTime;

    @ApiModelProperty("1:删除 0:不删除")
    private Integer delFlag;
}
