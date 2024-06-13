package com.morning.framework.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    // 响应码，通常使用HTTP状态码或者自定义的响应码
    private int code;

    // 响应消息，描述请求的处理结果
    private String message;

    // 响应数据，通常是具体的业务数据
    private T data;

    // 构造一个成功的响应
    public static <T> Result<T> success(T data) {
        Result<T> response = new Result<>();
        response.setCode(200); // 假设200表示成功
        response.setMessage("操作成功");
        response.setData(data);
        return response;
    }

    // 构造一个成功的响应，但不包含具体数据
    public static <T> Result<T> success() {
        return success(null);
    }

    // 构造一个带自定义消息的成功响应
    public static <T> Result<T> success(T data, String message) {
        Result<T> response = success(data);
        response.setMessage(message);
        return response;
    }

    // 构造一个失败的响应
    public static <T> Result<T> fail(int code, String message) {
        Result<T> response = new Result<>();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
}