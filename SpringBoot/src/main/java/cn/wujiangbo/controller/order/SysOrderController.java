package cn.wujiangbo.controller.order;

import cn.wujiangbo.domain.order.SysOrder;
import cn.wujiangbo.result.PageList;
import cn.wujiangbo.service.order.SysOrderService;
import cn.wujiangbo.query.order.SysOrderQuery;
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
 * @desc 订单表 API接口
 * @author 波波老师(weixin:javabobo0513)
 * @date 2022-11-18
 */
@RestController
@RequestMapping("/sysOrder")
@Api(value = "/sysOrder", tags = {"订单表 API接口"})
public class SysOrderController extends BaseController{

    @Autowired
    public SysOrderService sysOrderService;

    /**
     * 新增数据到【订单表】
     * @date 2022-11-18
     * @author 波波老师(weixin:javabobo0513)
     */
    @PostMapping(value="/save")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body", dataType = "SysOrder", name = "sysOrder", value = "")
    })
    @ApiOperation(value = "新增数据到【订单表】", notes = "新增数据到【订单表】", httpMethod = "POST")
    public JSONResult save(@RequestBody SysOrder sysOrder){
        sysOrderService.save(sysOrder);
        return JSONResult.success(true);
    }

    /**
     * 修改【订单表】表数据
     * @date 2022-11-18
     * @author 波波老师(weixin:javabobo0513)
     */
    @PostMapping(value="/update")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body", dataType = "SysOrder", name = "sysOrder", value = "")
    })
    @ApiOperation(value = "修改【订单表】表数据", notes = "修改【订单表】表数据", httpMethod = "POST")
    public JSONResult update(@RequestBody SysOrder sysOrder){
        sysOrderService.updateById(sysOrder);
        return JSONResult.success(true);
    }

    /**
     * 批量删除【订单表】数据
     * @date 2022-11-18
     * @author 波波老师(weixin:javabobo0513)
     */
    @PostMapping(value="/batchDelete")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body", dataType = "SysOrderQuery", name = "query", value = "")
    })
    @ApiOperation(value = "批量删除【订单表】数据", notes = "批量删除【订单表】数据", httpMethod = "POST")
    public JSONResult batchDelete(@RequestBody SysOrderQuery query){
        //批量删除数据库数据
        sysOrderService.removeByIds(Arrays.asList(query.getIds()));
        return JSONResult.success(true);
    }

    /**
     * 单个删除【订单表】数据
     * @date 2022-11-18
     * @author 波波老师(weixin:javabobo0513)
    */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path", dataType = "long", name = "id", value = "")
    })
    @ApiOperation(value = "单个删除【订单表】数据", notes = "单个删除【订单表】数据", httpMethod = "DELETE")
    @DeleteMapping("/singleDelete/{id}")
    public JSONResult batchDelete(@PathVariable("id") Long id){
        //单个删除数据库数据
        sysOrderService.removeById(id);
        return JSONResult.success(true);
    }

    /**
    * 根据ID查询【订单表】详情数据
    * @date 2022-11-18
    * @author 波波老师(weixin:javabobo0513)
    */
    @GetMapping(value = "/{id}")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path", dataType = "long", name = "id", value = "")
    })
    @ApiOperation(value = "根据ID查询【订单表】详情数据", notes = "根据ID查询【订单表】详情数据", httpMethod = "GET")
    public JSONResult get(@PathVariable("id")Long id){
        return JSONResult.success(sysOrderService.getById(id));
    }

    /**
    * 查询【订单表】所有数据（不分页）
    * @date 2022-11-18
    * @author 波波老师(weixin:javabobo0513)
    */
    @GetMapping(value = "/list")
    @ApiOperation(value = "查询【订单表】所有数据（不分页）", notes = "查询【订单表】所有数据（不分页）", httpMethod = "GET")
    public JSONResult list(){
        List<SysOrder> list = sysOrderService.list(null);
        return JSONResult.success(list);
    }

    /**
     * 查询【订单表】数据（分页）
     * @param query 查询对象
     * @return PageList 分页对象
     * @date 2022-11-18
     * @author 波波老师(weixin:javabobo0513)
     */
    @PostMapping(value = "/pagelist")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body", dataType = "SysOrderQuery", name = "query", value = "查询对象")
    })
    @ApiOperation(value = "查询【订单表】数据（分页）", notes = "查询【订单表】数据（分页）", httpMethod = "POST")
    public JSONResult pagelist(@RequestBody SysOrderQuery query){
        IPage<SysOrder> page = sysOrderService.selectMyPage(query);
        return JSONResult.success(new PageList<>(page.getTotal(), page.getRecords()));
    }

    /***********************************************************************************
    以上代码是自动生成的
    自己写的代码放在下面
    ***********************************************************************************/
}