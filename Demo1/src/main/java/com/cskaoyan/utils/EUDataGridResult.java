package com.cskaoyan.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangGuoming
 * created on 2018/12/7
 *
 * status状态码：
 * 200:表示成功
 * 500:表示错误,错误信息在msg字段中
 * 501:bean验证错误,不管多少个错误都以map形式返回
 * 555:异常抛出信息
 */
public class EUDataGridResult {
    private long total;
    private List<?> rows;
    private String msg;
    private int status;

    public EUDataGridResult() {
    }

    public EUDataGridResult(long total, List<?> rows, String msg, int status) {
        this.total = total;
        this.rows = rows;
        this.msg = msg;
        this.status = status;
    }

    public EUDataGridResult(BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            List<String> strings = new ArrayList<>();
            this.setStatus(500);
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (int i = 0; i < fieldErrors.size(); i++) {
                String defaultMessage = fieldErrors.get(i).getDefaultMessage();
                strings.add("<br/><br/>error" + i +  ": " + defaultMessage);
            }
            strings.add("</br></br>");
            this.setMsg("errorMessage: " + strings.toString());
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public List<?> getRows() {
        return rows;
    }
    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
