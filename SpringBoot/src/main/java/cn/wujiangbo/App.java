package cn.wujiangbo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @desc：系统启动类
 * @author：wujiangbo(weixin:wjb1134135987)
 */
@SpringBootApplication
@Slf4j
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        log.info("**************************************");
        log.info("**************系统启动成功*************");
        log.info("**************************************");
    }
}