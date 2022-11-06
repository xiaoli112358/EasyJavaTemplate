package ${package.Controller}.${cfg.moduleName};

import ${cfg.basePath}.domain.${cfg.moduleName}.${entity};
import ${cfg.basePath}.result.PageList;
import ${cfg.basePath}.service.${cfg.moduleName}.${entity}Service;
import ${cfg.basePath}.query.${cfg.moduleName}.${entity}Query;
import ${cfg.basePath}.result.JSONResult;
import ${cfg.basePath}.controller.base.BaseController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.Arrays;
import java.util.List;

/**
 * @desc ${table.comment!} API接口
 * @author 波波老师(weixin:javabobo0513)
 * @date ${date}
 */
@RestController
@RequestMapping("/${table.entityPath}")
@Api(value = "/${table.entityPath}", tags = {"${table.comment!} API接口"})
public class ${entity}Controller extends BaseController{

    @Autowired
    public ${entity}Service ${table.entityPath}Service;

    /**
     * 新增数据到【${table.comment!}】
     * @date ${date}
     * @author 波波老师(weixin:javabobo0513)
     */
    @PostMapping(value="/save")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body", dataType = "${entity}", name = "${table.entityPath}", value = "")
    })
    @ApiOperation(value = "新增数据到【${table.comment!}】", notes = "新增数据到【${table.comment!}】", httpMethod = "POST")
    public JSONResult save(@RequestBody ${entity} ${table.entityPath}){
        ${table.entityPath}Service.save(${table.entityPath});
        return JSONResult.success(true);
    }

    /**
     * 修改【${table.comment!}】表数据
     * @date ${date}
     * @author 波波老师(weixin:javabobo0513)
     */
    @PostMapping(value="/update")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body", dataType = "${entity}", name = "${table.entityPath}", value = "")
    })
    @ApiOperation(value = "修改【${table.comment!}】表数据", notes = "修改【${table.comment!}】表数据", httpMethod = "POST")
    public JSONResult update(@RequestBody ${entity} ${table.entityPath}){
        ${table.entityPath}Service.updateById(${table.entityPath});
        return JSONResult.success(true);
    }

    /**
     * 批量删除【${table.comment!}】数据
     * @date ${date}
     * @author 波波老师(weixin:javabobo0513)
     */
    @PostMapping(value="/batchDelete")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body", dataType = "${entity}Query", name = "query", value = "")
    })
    @ApiOperation(value = "批量删除【${table.comment!}】数据", notes = "批量删除【${table.comment!}】数据", httpMethod = "POST")
    public JSONResult batchDelete(@RequestBody ${entity}Query query){
        //批量删除数据库数据
        ${table.entityPath}Service.removeByIds(Arrays.asList(query.getIds()));
        return JSONResult.success(true);
    }

    /**
     * 单个删除【${table.comment!}】数据
     * @date ${date}
     * @author 波波老师(weixin:javabobo0513)
    */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path", dataType = "long", name = "id", value = "")
    })
    @ApiOperation(value = "单个删除【${table.comment!}】数据", notes = "单个删除【${table.comment!}】数据", httpMethod = "DELETE")
    @DeleteMapping("/singleDelete/{id}")
    public JSONResult batchDelete(@PathVariable("id") Long id){
        //单个删除数据库数据
        ${table.entityPath}Service.removeById(id);
        return JSONResult.success(true);
    }

    /**
    * 根据ID查询【${table.comment!}】详情数据
    * @date ${date}
    * @author 波波老师(weixin:javabobo0513)
    */
    @GetMapping(value = "/{id}")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path", dataType = "long", name = "id", value = "")
    })
    @ApiOperation(value = "根据ID查询【${table.comment!}】详情数据", notes = "根据ID查询【${table.comment!}】详情数据", httpMethod = "GET")
    public JSONResult get(@PathVariable("id")Long id){
        return JSONResult.success(${table.entityPath}Service.getById(id));
    }

    /**
    * 查询【${table.comment!}】所有数据（不分页）
    * @date ${date}
    * @author 波波老师(weixin:javabobo0513)
    */
    @GetMapping(value = "/list")
    @ApiOperation(value = "查询【${table.comment!}】所有数据（不分页）", notes = "查询【${table.comment!}】所有数据（不分页）", httpMethod = "GET")
    public JSONResult list(){
        List<${entity}> list = ${table.entityPath}Service.list(null);
        return JSONResult.success(list);
    }

    /**
     * 查询【${table.comment!}】数据（分页）
     * @param query 查询对象
     * @return PageList 分页对象
     * @date ${date}
     * @author 波波老师(weixin:javabobo0513)
     */
    @PostMapping(value = "/pagelist")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body", dataType = "${entity}Query", name = "query", value = "查询对象")
    })
    @ApiOperation(value = "查询【${table.comment!}】数据（分页）", notes = "查询【${table.comment!}】数据（分页）", httpMethod = "POST")
    public JSONResult pagelist(@RequestBody ${entity}Query query){
        IPage<${entity}> page = ${table.entityPath}Service.selectMyPage(query);
        return JSONResult.success(new PageList<>(page.getTotal(), page.getRecords()));
    }

    /***********************************************************************************
    以上代码是自动生成的
    自己写的代码放在下面
    ***********************************************************************************/
}