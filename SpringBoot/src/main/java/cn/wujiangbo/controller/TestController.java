package cn.wujiangbo.controller;

import cn.wujiangbo.annotation.RateLimit;
import cn.wujiangbo.result.JSONResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>描述</p>
 *
 * @author 波波老师(weixin:javabobo0513)
 */
@RestController
@RequestMapping("/test")
public class TestController {

    //cycle秒内只能访问count次
    @RateLimit(key= "testLimit:", count = 2, cycle = 2, msg = "同志，不要请求这么快，好吗")
    @GetMapping("/test001")
    public JSONResult rate() {
        System.out.println("成功发送一条短信");
        return JSONResult.success("成功发送一条短信");
    }
}