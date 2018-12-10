package com.cskaoyan.bean.pojo;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 200:表示成功
 * 500:表示错误,错误信息在msg字段中
 * 501:bean验证错误,不管多少个错误都以map形式返回
 * 555:异常抛出信息
 */
public class JsonResult {
    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();
    // 响应业务状态
    private Integer status;
    // 响应消息
    private String msg;
    // 响应中的数据
    private Object data;



}