package cn.wujiangbo.domain.base;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

@Data
public class BaseDomain implements Serializable {

    @ApiModelProperty(value = "创建人名称")
    @TableField(exist = false)
    private String createUserName;

    @ApiModelProperty(value = "更新人名称")
    @TableField(exist = false)
    private String updateUserName;

}
