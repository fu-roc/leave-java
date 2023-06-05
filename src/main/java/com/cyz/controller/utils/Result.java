package com.cyz.controller.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result success(Object data) {
        return new Result(200,"成功访问",data);
    }

    public static Result error(String msg) {
        return new Result(400,msg);
    }

}
