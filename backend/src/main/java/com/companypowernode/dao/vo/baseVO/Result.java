package com.companypowernode.dao.vo.baseVO;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result<T> {
    private Integer code;//结果代码
    private String msg;//错误信息
    private T data; //返回数据
    private Map map= new HashMap();//返回动态数据

    public static <T>Result<T> success(T object){
        Result<T> r = new Result<T>();
        r.data=object;
        r.code=200;
        r.msg = "success";
        return r;
    }
    public static <T>Result<T> error(String msg){
        Result<T> r = new Result<T>();
        r.code=500;
        r.msg=msg;
        return r;
    }
    public Result<T> add(String key,Object value){
        this.map.put(key,value);
        return this;
    }
}
