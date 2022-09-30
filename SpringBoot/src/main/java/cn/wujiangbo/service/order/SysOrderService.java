package cn.wujiangbo.service.order;

import cn.wujiangbo.domain.order.SysOrder;
import cn.wujiangbo.mapper.order.SysOrderMapper;
import cn.wujiangbo.query.order.SysOrderQuery;
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
 *  服务实现类
 * </p>
 *
 * @author wujiangbo(weixin:wjb1134135987)
 * @since 2022-09-30
 */
@Service
@Slf4j
@Transactional
public class SysOrderService extends ServiceImpl<SysOrderMapper, SysOrder>{

    //查询分页列表数据
    public IPage<SysOrder> selectMyPage(SysOrderQuery query) {
        QueryWrapper<SysOrder> wrapper = new QueryWrapper<>();
        if (MyTools.hasLength(query.getKeyword())) {
            wrapper.and(i -> i.like("id", query.getKeyword()));
        }
        //排序
        wrapper.orderByDesc("id");
        IPage<SysOrder> page = new Page<>(query.getCurrent(), query.getSize());
        return super.page(page, wrapper);
    }
}