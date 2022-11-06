package ${cfg.basePath}.service.${cfg.moduleName};

import ${cfg.basePath}.domain.${cfg.moduleName}.${entity};
import ${cfg.basePath}.mapper.${cfg.moduleName}.${entity}Mapper;
import ${cfg.basePath}.query.${cfg.moduleName}.${entity}Query;
import ${cfg.basePath}.util.MyTools;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author 波波老师(weixin:javabobo0513)
 * @date ${date}
 */
@Service
@Slf4j
@Transactional
public class ${table.serviceName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}>{

    //查询分页列表数据
    public IPage<${entity}> selectMyPage(${entity}Query query) {
        QueryWrapper<${entity}> wrapper = new QueryWrapper<>();
        if (MyTools.hasLength(query.getKeyword())) {
            wrapper.and(i -> i.like("id", query.getKeyword()));
        }
        //排序
        wrapper.orderByDesc("id");
        IPage<${entity}> page = new Page<>(query.getCurrent(), query.getSize());
        return super.page(page, wrapper);
    }
}