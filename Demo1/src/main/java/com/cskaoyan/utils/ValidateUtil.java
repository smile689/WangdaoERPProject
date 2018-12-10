package com.cskaoyan.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

//处理hibernate validate的错误信息
public class ValidateUtil {

    public static String handleError(BindingResult bindingResult) {
        StringBuilder sb=new StringBuilder();
        if(bindingResult.hasFieldErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError: fieldErrors) {
                System.out.println("fieldError.getField():" + fieldError.getField());
                System.out.println("fieldError.getDefaultMessage():" + fieldError.getDefaultMessage());
                sb.append(fieldError.getDefaultMessage()+",");
            }
        }
        return sb.toString();
    }
}
