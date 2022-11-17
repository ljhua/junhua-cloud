package me.junhua.common.exception;

import lombok.Getter;
import lombok.Setter;
import me.junhua.common.enums.ResultCodeEnum;

/**
 * 系统异常
 */
@Setter
@Getter
public class SystemException extends RuntimeException {

    /**
     * 异常编码
     */
    private int code;
    /**
     * 异常描述
     */
    private String msg;

    public SystemException() {
        this.code = ResultCodeEnum.FAILED.getCode();
        this.msg = ResultCodeEnum.FAILED.getMsg();
    }

    public SystemException(String msg) {
        this.code = ResultCodeEnum.FAILED.getCode();
        this.msg = msg;
    }

    public SystemException(Throwable cause) {
        super(cause);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
