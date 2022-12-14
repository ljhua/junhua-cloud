package me.junhua.common.result;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.junhua.common.enums.ResultCodeEnum;

@NoArgsConstructor
@Data
public class Result<T> {

    private boolean success;
    private int code;
    private String msg;
    private T data;

    private Result(int code, T data, String msg) {
        this.success = ResultCodeEnum.SUCCESS.getCode() == code;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Result(ResultCodeEnum resultCodeEnum) {
        this(resultCodeEnum.getCode(), null, resultCodeEnum.getMsg());
    }

    private Result(ResultCodeEnum resultCodeEnum, String msg) {
        this(resultCodeEnum.getCode(), null, msg);
    }

    private Result(ResultCodeEnum resultCodeEnum, T data) {
        this(resultCodeEnum.getCode(), data, resultCodeEnum.getMsg());
    }

    private Result(ResultCodeEnum resultCodeEnum, T data, String msg) {
        this(resultCodeEnum.getCode(), data, msg);
    }

    public static <T> Result<T> data(T data) {
        return data(data, ResultCodeEnum.SUCCESS.getMsg());
    }

    public static <T> Result<T> data(T data, String msg) {
        return data(ResultCodeEnum.SUCCESS.getCode(), data, msg);
    }

    public static <T> Result<T> data(int code, T data, String msg) {
        return new Result<>(code, data, msg);
    }

    public static <T> Result<T> success() {
        return new Result<>(ResultCodeEnum.SUCCESS);
    }

    public static <T> Result<T> success(String msg) {
        return new Result<T>(ResultCodeEnum.SUCCESS, msg);
    }

    public static <T> Result<T> success(ResultCodeEnum resultCodeEnum) {
        return new Result<T>(resultCodeEnum);
    }

    public static <T> Result<T> success(ResultCodeEnum resultCodeEnum, String msg) {
        return new Result<T>(resultCodeEnum, msg);
    }

    public static <T> Result<T> error() {
        return new Result<>(ResultCodeEnum.ERROR, ResultCodeEnum.ERROR.getMsg());
    }

    public static <T> Result<T> error(String msg) {
        return new Result<>(ResultCodeEnum.ERROR, msg);
    }

    public static <T> Result<T> error(int code, String msg) {
        return new Result<>(code, null, msg);
    }

    public static <T> Result<T> error(ResultCodeEnum resultCodeEnum) {
        return new Result<>(resultCodeEnum);
    }

    public static <T> Result<T> error(ResultCodeEnum resultCodeEnum, String msg) {
        return new Result<>(resultCodeEnum, msg);
    }

    public static <T> Result<Object> result(boolean flag) {
        return flag ? Result.success("????????????") : Result.error("????????????");
    }
}

