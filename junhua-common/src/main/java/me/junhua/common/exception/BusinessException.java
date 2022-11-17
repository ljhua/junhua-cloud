package me.junhua.common.exception;

import lombok.Getter;
import lombok.Setter;
import me.junhua.common.enums.ResultCodeEnum;

/**
 * 业务异常
 */
@Setter
@Getter
public class BusinessException extends RuntimeException {

    /**
     * 异常编码
     */
    private int code;
    /**
     * 异常描述
     */
    private String msg;

    public BusinessException() {
        this.code = ResultCodeEnum.FAILED.getCode();
        this.msg = ResultCodeEnum.FAILED.getMsg();
    }

    public BusinessException(String msg) {
        this.code = ResultCodeEnum.FAILED.getCode();
        this.msg = msg;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
