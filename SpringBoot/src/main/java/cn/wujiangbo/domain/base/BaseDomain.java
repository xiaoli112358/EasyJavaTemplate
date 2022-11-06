package cn.wujiangbo.domain.base;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

/**
 * @desc 基础Domain类
 * @author 波波老师(weixin:javabobo0513)
 */
@Data
public class BaseDomain implements Serializable {

    @ApiModelProperty(value = "创建人名称")
    @TableField(exist = false)
    private String createUserName;

    @ApiModelProperty(value = "更新人名称")
    @TableField(exist = false)
    private String updateUserName;

}
