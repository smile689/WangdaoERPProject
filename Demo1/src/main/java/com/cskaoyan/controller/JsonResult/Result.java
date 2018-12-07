package com.cskaoyan.controller.JsonResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * 定义相应结果
 *
 * */
public class Result {

    /**
     * 对象
     * */
    private static final ObjectMapper mapper = new ObjectMapper();
/**
 * 响应状态
 *
 * */
    private Integer status;
    private  String msg;
    private Object data;

    public static ObjectMapper getMapper() {
        return mapper;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result(Integer status, String msg, Object data) {

        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    public Result() {

    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * 将json字符串转化为对象
     *
     * */

    public static <T> T jsonToPojo(String jsonData,Class<?> beanType){

        try {
            if (beanType == null) {

                return (T) mapper.readValue(jsonData, beanType);
            }

        }catch (IOException e) {
                e.printStackTrace();
            }
            return null;

    }
 /**
 * 将对象转化为json字符串
 *
 * */
public  static String ObjectToJson(Object data){

    try {
        return mapper.writeValueAsString(data);
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    }
    return null;
}

/**
 * 将json字符串数据转化为pojo对象list
 *
 * */

public  static <T> List<T> jsonToList(String jsondata,Class<T>beanType){
    JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, beanType);

    try {
        return mapper.readValue(jsondata,javaType);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;


}


}
