package com.example.hrnagemet.common;

import lombok.Data;

/**
 * @author notfl
 * @date 2025/12/21 15:50
 */
@Data
public class Result<T> {
    private String code;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setCode("200");
        result.setMsg("操作成功");
        result.setData(data);
        return result;
    }

    public static Result<Void> success(){
        return success(null);
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.setCode("500");
        result.setMsg(msg);
        return result;
    }

}
