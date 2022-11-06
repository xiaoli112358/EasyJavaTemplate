package cn.wujiangbo.annotation;

import java.lang.annotation.*;

/**
 * 用于防刷限流的注解
 *      默认是5秒内只能调用一次
 * @author 波波老师(weixin:javabobo0513)
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimit {
    
    /** 限流的key */
    String key() default "limit:";

    /** 周期,单位是秒 */
    int cycle() default 5;

    /** 请求次数 */
    int count() default 1;

    /** 默认提示信息 */
    String msg() default "请勿重复点击";
}