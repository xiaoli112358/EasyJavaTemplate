package cn.wujiangbo.domain.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableField;
import cn.wujiangbo.domain.base.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author wujiangbo(weixin:wjb1134135987)
 * @since 2022-09-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="sys_user 表对应的实体对象", description="用户信息表")
public class SysUser extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户账号")
    @TableField(value = "user_name")
    private String userName;

    @ApiModelProperty(value = "用户邮箱")
    @TableField(value = "email")
    private String email;

    @ApiModelProperty(value = "手机号码")
    @TableField(value = "phonenumber")
    private String phonenumber;

    @ApiModelProperty(value = "头像地址")
    @TableField(value = "avatar")
    private String avatar;

    @ApiModelProperty(value = "密码")
    @TableField(value = "password")
    private String password;

    @ApiModelProperty(value = "备注")
    @TableField(value = "remark")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建人")
    @TableField(value = "create_user_id")
    private Long createUserId;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "更新人")
    @TableField(value = "update_user_id")
    private Long updateUserId;
}