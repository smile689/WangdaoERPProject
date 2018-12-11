package com.cskaoyan.utils;

import java.util.List;

/**
 * @author WangGuoming
 * created on 2018/12/7
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
