package me.junhua.system.dto.save;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateTenantDTO {

    @ApiModelProperty("租户套餐ID")
    private Long tenantPackageId;

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
}
