package cn.wujiangbo.controller.system;

import cn.wujiangbo.domain.system.SysUser;
import cn.wujiangbo.result.PageList;
import cn.wujiangbo.service.system.SysUserService;
import cn.wujiangbo.query.system.SysUserQuery;
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
 * @desc 用户信息表 API接口
 * @author wujiangbo(weixin:wjb1134135987)
 * @date 2022-09-15
 */
@RestController
@RequestMapping("/sysUser")
@Api(value = "/sysUser", tags = {"用户信息表 API接口"})
public class SysUserController extends BaseController{

    @Autowired
    public SysUserService sysUserService;

    /**
     * 新增数据到【用户信息表】
     * @date 2022-09-15
     * @author wujiangbo(weixin:wjb1134135987)
     */
    @PostMapping(value="/save")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body", dataType = "SysUser", name = "sysUser", value = "")
    })
    @ApiOperation(value = "新增数据到【用户信息表】", notes = "新增数据到【用户信息表】", httpMethod = "POST")
    public JSONResult save(@RequestBody SysUser sysUser){
        sysUserService.save(sysUser);
        return JSONResult.success(true);
    }

    /**
     * 修改【用户信息表】表数据
     * @date 2022-09-15
     * @author wujiangbo(weixin:wjb1134135987)
     */
    @PostMapping(value="/update")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body", dataType = "SysUser", name = "sysUser", value = "")
    })
    @ApiOperation(value = "修改【用户信息表】表数据", notes = "修改【用户信息表】表数据", httpMethod = "POST")
    public JSONResult update(@RequestBody SysUser sysUser){
        sysUserService.updateById(sysUser);
        return JSONResult.success(true);
    }

    /**
     * 批量删除【用户信息表】数据
     * @date 2022-09-15
     * @author wujiangbo(weixin:wjb1134135987)
     */
    @PostMapping(value="/batchDelete")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body", dataType = "SysUserQuery", name = "query", value = "")
    })
    @ApiOperation(value = "批量删除【用户信息表】数据", notes = "批量删除【用户信息表】数据", httpMethod = "POST")
    public JSONResult batchDelete(@RequestBody SysUserQuery query){
        //批量删除数据库数据
        sysUserService.removeByIds(Arrays.asList(query.getIds()));
        return JSONResult.success(true);
    }

    /**
     * 单个删除【用户信息表】数据
     * @date 2022-09-15
     * @author wujiangbo(weixin:wjb1134135987)
    */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path", dataType = "long", name = "id", value = "")
    })
    @ApiOperation(value = "单个删除【用户信息表】数据", notes = "单个删除【用户信息表】数据", httpMethod = "DELETE")
    @DeleteMapping("/singleDelete/{id}")
    public JSONResult batchDelete(@PathVariable("id") Long id){
        //单个删除数据库数据
        sysUserService.removeById(id);
        return JSONResult.success(true);
    }

    /**
    * 根据ID查询【用户信息表】详情数据
    * @date 2022-09-15
    * @author wujiangbo(weixin:wjb1134135987)
    */
    @GetMapping(value = "/{id}")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path", dataType = "long", name = "id", value = "")
    })
    @ApiOperation(value = "根据ID查询【用户信息表】详情数据", notes = "根据ID查询【用户信息表】详情数据", httpMethod = "GET")
    public JSONResult get(@PathVariable("id")Long id){
        return JSONResult.success(sysUserService.getById(id));
    }

    /**
    * 查询【用户信息表】所有数据（不分页）
    * @date 2022-09-15
    * @author wujiangbo(weixin:wjb1134135987)
    */
    @GetMapping(value = "/list")
    @ApiOperation(value = "查询【用户信息表】所有数据（不分页）", notes = "查询【用户信息表】所有数据（不分页）", httpMethod = "GET")
    public JSONResult list(){
        List<SysUser> list = sysUserService.list(null);
        return JSONResult.success(list);
    }

    /**
     * 查询【用户信息表】数据（分页）
     * @param query 查询对象
     * @return PageList 分页对象
     * @date 2022-09-15
     * @author wujiangbo(weixin:wjb1134135987)
     */
    @PostMapping(value = "/pagelist")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body", dataType = "SysUserQuery", name = "query", value = "查询对象")
    })
    @ApiOperation(value = "查询【用户信息表】数据（分页）", notes = "查询【用户信息表】数据（分页）", httpMethod = "POST")
    public JSONResult pagelist(@RequestBody SysUserQuery query){
        IPage<SysUser> page = sysUserService.selectMyPage(query);
        return JSONResult.success(new PageList<>(page.getTotal(), page.getRecords()));
    }

    /***********************************************************************************
    以上代码是自动生成的
    自己写的代码放在下面
    ***********************************************************************************/
}