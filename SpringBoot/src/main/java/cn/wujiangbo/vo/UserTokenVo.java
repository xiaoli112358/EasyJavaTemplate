package cn.wujiangbo.vo;

import lombok.Data;

/**
 * @desc 登录成功之后，返回前端的对象
 * @author wujiangbo(weixin:wjb1134135987)
 */
@Data
public class UserTokenVo {

    private String token;
    private String userName;
    private String avatar;
}
