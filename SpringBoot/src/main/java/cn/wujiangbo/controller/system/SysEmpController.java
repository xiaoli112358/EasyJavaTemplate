package cn.wujiangbo.controller.system;

import cn.wujiangbo.domain.system.SysEmp;
import cn.wujiangbo.result.PageList;
import cn.wujiangbo.service.system.SysEmpService;
import cn.wujiangbo.query.system.SysEmpQuery;
import cn.wujiangbo.result.JSONResult;
import cn.wujiangbo.controller.base.BaseController;
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
 * @author 波波老师(weixin:javabobo0513)
 */
@RestController
@RequestMapping("/sysEmp")
@Api(value = "/sysEmp", tags = {"员工信息表 API接口"})
public class SysEmpController extends BaseController{

    @Autowired
    public SysEmpService sysEmpService;

    /**
     * 新增数据到【员工信息表】
     * @date 2022-09-15
     * @author wujiangbo(weixin:wjb1134135987)
     */
    @PostMapping(value="/save")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body", dataType = "SysEmp", name = "sysEmp", value = "")
    })
    @ApiOperation(value = "新增数据到【员工信息表】", notes = "新增数据到【员工信息表】", httpMethod = "POST")
    public JSONResult save(@RequestBody SysEmp sysEmp){
        sysEmpService.save(sysEmp);
        return JSONResult.success(true);
    }

    /**
     * 修改【员工信息表】表数据
     * @date 2022-09-15
     * @author wujiangbo(weixin:wjb1134135987)
     */
    @PostMapping(value="/update")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body", dataType = "SysEmp", name = "sysEmp", value = "")
    })
    @ApiOperation(value = "修改【员工信息表】表数据", notes = "修改【员工信息表】表数据", httpMethod = "POST")
    public JSONResult update(@RequestBody SysEmp sysEmp){
        sysEmpService.updateById(sysEmp);
        return JSONResult.success(true);
    }

    /**
     * 批量删除【员工信息表】数据
     * @date 2022-09-15
     * @author wujiangbo(weixin:wjb1134135987)
     */
    @PostMapping(value="/batchDelete")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body", dataType = "SysEmpQuery", name = "query", value = "")
    })
    @ApiOperation(value = "批量删除【员工信息表】数据", notes = "批量删除【员工信息表】数据", httpMethod = "POST")
    public JSONResult batchDelete(@RequestBody SysEmpQuery query){
        //批量删除数据库数据
        sysEmpService.removeByIds(Arrays.asList(query.getIds()));
        return JSONResult.success(true);
    }

    /**
     * 单个删除【员工信息表】数据
     * @date 2022-09-15
     * @author wujiangbo(weixin:wjb1134135987)
    */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path", dataType = "long", name = "id", value = "")
    })
    @ApiOperation(value = "单个删除【员工信息表】数据", notes = "单个删除【员工信息表】数据", httpMethod = "DELETE")
    @DeleteMapping("/singleDelete/{id}")
    public JSONResult batchDelete(@PathVariable("id") Long id){
        //单个删除数据库数据
        sysEmpService.removeById(id);
        return JSONResult.success(true);
    }

    /**
    * 根据ID查询【员工信息表】详情数据
    * @date 2022-09-15
    * @author wujiangbo(weixin:wjb1134135987)
    */
    @GetMapping(value = "/{id}")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path", dataType = "long", name = "id", value = "")
    })
    @ApiOperation(value = "根据ID查询【员工信息表】详情数据", notes = "根据ID查询【员工信息表】详情数据", httpMethod = "GET")
    public JSONResult get(@PathVariable("id")Long id){
        return JSONResult.success(sysEmpService.getById(id));
    }

    /**
    * 查询【员工信息表】所有数据（不分页）
    * @date 2022-09-15
    * @author wujiangbo(weixin:wjb1134135987)
    */
    @GetMapping(value = "/list")
    @ApiOperation(value = "查询【员工信息表】所有数据（不分页）", notes = "查询【员工信息表】所有数据（不分页）", httpMethod = "GET")
    public JSONResult list(){
        List<SysEmp> list = sysEmpService.list(null);
        return JSONResult.success(list);
    }

    /**
     * 查询【员工信息表】数据（分页）
     * @param query 查询对象
     * @return PageList 分页对象
     * @date 2022-09-15
     * @author wujiangbo(weixin:wjb1134135987)
     */
    @PostMapping(value = "/pagelist")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body", dataType = "SysEmpQuery", name = "query", value = "查询对象")
    })
    @ApiOperation(value = "查询【员工信息表】数据（分页）", notes = "查询【员工信息表】数据（分页）", httpMethod = "POST")
    public JSONResult pagelist(@RequestBody SysEmpQuery query){
        IPage<SysEmp> page = sysEmpService.selectMyPage(query);
        return JSONResult.success(new PageList<>(page.getTotal(), page.getRecords()));
    }

    /***********************************************************************************
    以上代码是自动生成的
    自己写的代码放在下面
    ***********************************************************************************/
}