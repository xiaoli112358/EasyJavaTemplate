package cn.wujiangbo.query.base;

import lombok.Data;
import java.io.Serializable;

/**
 * 基础查询对象
 */
@Data
public class BaseQuery implements Serializable {

    private Long[] ids; //批量删除时，前端传来的主键ID集合
    private String keyword;//关键字

    private Integer current = 1; //当前页
    private Integer size = 10; //每页显示多少条
}
