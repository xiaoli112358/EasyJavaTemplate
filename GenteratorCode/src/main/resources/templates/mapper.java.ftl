package ${package.Mapper}.${cfg.moduleName};

import ${cfg.basePath}.domain.${cfg.moduleName}.${entity};
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* <p>
* ${table.comment!} Mapper接口
* </p>
*
* @author wujiangbo(weixin:wjb1134135987)
* @since ${date}
*/
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {
}