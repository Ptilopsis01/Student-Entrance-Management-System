package com.example.demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    public static final int SUCCESS = 0;
    public static final int FAIL = 1;
    private Integer code;   // 为各种状态进行编码
    private String  msg;    // 详细信息
    private T data;         // 返回的数据
    public static Response<String> error(String msg) {
        return new Response<>(FAIL, msg, null);
    }
}
