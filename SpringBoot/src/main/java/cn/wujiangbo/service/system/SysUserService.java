package cn.wujiangbo.service.system;

import cn.wujiangbo.domain.system.SysUser;
import cn.wujiangbo.mapper.system.SysUserMapper;
import cn.wujiangbo.query.system.SysUserQuery;
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
 * 用户信息表 服务实现类
 * </p>
 *
 * @author 波波老师(weixin:javabobo0513)
 */
@Service
@Slf4j
@Transactional
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser>{

    //查询分页列表数据
    public IPage<SysUser> selectMyPage(SysUserQuery query) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        if (MyTools.hasLength(query.getKeyword())) {
            wrapper.and(i -> i.like("id", query.getKeyword()));
        }
        //排序
        wrapper.orderByDesc("create_time").orderByDesc("id");
        IPage<SysUser> page = new Page<>(query.getCurrent(), query.getSize());
        return super.page(page, wrapper);
    }
}