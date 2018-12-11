package com.cskaoyan.utils;

import java.util.List;

//封装查询信息
public class JsonFindRet<T> {

    private Long total;

    private List<T> rows;

    @Override
    public String toString() {
        return "JsonFindRet{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
