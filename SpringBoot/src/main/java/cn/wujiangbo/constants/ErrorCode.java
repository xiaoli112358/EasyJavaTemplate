package cn.wujiangbo.constants;

/**
 * 系统错误码
 * @author wujiangbo(weixin:wjb1134135987)
 */
public enum ErrorCode {

    SYSTEM_SUCCESS("0000", "操作成功！"),

    ERROR_CODE_1001("1001", "操作失败，请稍候再试！"),
    ERROR_CODE_1002("1002", "认证状态失效，请重新登录！"),
    ERROR_CODE_1003("1003", "登录账号不能为空！"),
    ERROR_CODE_1004("1004", "登录密码不能为空！"),
    ERROR_CODE_1005("1005", "登录账号不存在！"),
    ERROR_CODE_1006("1006", "登录账号存在多个！"),
    ERROR_CODE_1007("1007", "登录密码错误！"),


    SYSTEM_ERROR("9999", "系统发生异常，请稍后再试！");

    //错误码
    private String code;

    //错误信息
    private String message;

    ErrorCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }
}
