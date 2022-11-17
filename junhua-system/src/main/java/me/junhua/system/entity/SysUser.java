package me.junhua.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ljhua
 * @since 2022-11-11
 */
@TableName("sys_user")
@ApiModel(value = "SysUser对象", description = "用户表")
@Data
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("账号")
    private String account;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("真实姓名")
    private String realName;

    @ApiModelProperty("1 : 男，0 : 女  -1：未知")
    private String gender;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("电话")
    private String mobile;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("'0'禁用，'1' 启用, '2' 密码过期或初次未修改")
    private Integer status;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("国家")
    private String country;

    @ApiModelProperty("省")
    private String province;

    @ApiModelProperty("市")
    private String city;

    @ApiModelProperty("区")
    private String area;

    @ApiModelProperty("街道详细地址")
    private String street;

    @ApiModelProperty("备注")
    private String comments;
}
