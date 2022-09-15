package cn.wujiangbo.interceptor;

import cn.wujiangbo.constants.ErrorCode;
import cn.wujiangbo.constants.SystemConstants;
import cn.wujiangbo.exception.MyException;
import cn.wujiangbo.util.MyTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author wujiangbo
 * @description 校验登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    //前置拦截
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)){
            //不是请求方法，则直接放行
            return true;
        }
        //1、从请求头中获取token
        String token = request.getHeader("token");
        if(!MyTools.hasLength(token)){
            throw new MyException(ErrorCode.ERROR_CODE_1002.getMessage());
        }

        //根据token从Redis中获取到用户信息
        String userInfo = (String)redisTemplate.opsForValue().get(token);
        if(MyTools.hasLength(userInfo)){
            //重新设置超时时间
            redisTemplate.opsForValue().set(token, userInfo, SystemConstants.LOGIN_TIME_OUT, TimeUnit.MINUTES);
            //放行
            return true;
        }else{
            //Redis中拿不到用户信息，抛异常
            throw new MyException(ErrorCode.ERROR_CODE_1002.getMessage());
        }
    }

}