package cn.wujiangbo.config.mp;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: MyBatiesPlus配置类
 * @author wujiangbo(weixin:wjb1134135987)
 */
@Configuration
@MapperScan("cn.wujiangbo.mapper")
public class MyBatiesPlusConfiguration {

    /*
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
