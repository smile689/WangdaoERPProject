package com.cskaoyan.controller.JsonResult;

import java.util.HashMap;
import java.util.Map;

public class TestResult {
    public static void main(String[] args){
        /**
         * 将对象转化为json字符串
         *
         * */
        Result result = new Result();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("username","wangtianyuan");
        resultMap.put("password","123456");
        resultMap.put("accountEmail","1129988388@qq.com");
        result.setData(resultMap);
        result.setMsg("查询成功！");
        result.setStatus(1);

        System.out.println(Result.ObjectToJson(result));
    }
}
