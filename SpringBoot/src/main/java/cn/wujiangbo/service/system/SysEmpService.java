package cn.wujiangbo.service.system;

import cn.wujiangbo.domain.system.SysEmp;
import cn.wujiangbo.mapper.system.SysEmpMapper;
import cn.wujiangbo.query.system.SysEmpQuery;
import cn.wujiangbo.util.MyTools;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 员工信息表 服务实现类
 * </p>
 *
 * @author 波波老师(weixin:javabobo0513)
 */
@Service
@Slf4j
@Transactional
public class SysEmpService extends ServiceImpl<SysEmpMapper, SysEmp>{

    //查询分页列表数据
    public IPage<SysEmp> selectMyPage(SysEmpQuery query) {
        QueryWrapper<SysEmp> wrapper = new QueryWrapper<>();
        if (MyTools.hasLength(query.getKeyword())) {
            wrapper.and(i -> i.like("id", query.getKeyword()));
        }
        //排序
        wrapper.orderByDesc("id");
        IPage<SysEmp> page = new Page<>(query.getCurrent(), query.getSize());
        return super.page(page, wrapper);
    }
}