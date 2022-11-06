package cn.wujiangbo.domain.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * 员工信息表
 * </p>
 *
 * @author 波波老师(weixin:javabobo0513)
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="sys_emp 表对应的实体对象", description="员工信息表")
public class SysEmp extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "员工姓名")
    @TableField(value = "user_name")
    private String userName;

    @ApiModelProperty(value = "用户邮箱")
    @TableField(value = "email")
    private String email;

    @ApiModelProperty(value = "手机号码")
    @TableField(value = "phone")
    private String phone;

    @ApiModelProperty(value = "备注")
    @TableField(value = "remark")
    private String remark;

    @ApiModelProperty(value = "年龄")
    @TableField(value = "age")
    private Integer age;
}