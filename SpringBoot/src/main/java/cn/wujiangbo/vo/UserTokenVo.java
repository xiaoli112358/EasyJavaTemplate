package cn.wujiangbo.vo;

import lombok.Data;

/**
 * @author wujiangbo
 * @description 登录成功之后，返回前端的对象
 */
@Data
public class UserTokenVo {

    private String token;
    private String userName;
    private String avatar;
}
