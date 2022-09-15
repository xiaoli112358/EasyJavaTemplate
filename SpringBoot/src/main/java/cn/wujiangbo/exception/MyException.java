package cn.wujiangbo.exception;

import cn.wujiangbo.constants.ErrorCode;
import lombok.Data;

/**
 * 自定义异常类
 */
@Data
public class MyException extends RuntimeException {

    private String code;
    private String message;

    public MyException(String message){
        this.message = message;
    }

    public MyException(ErrorCode errorCode){
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}