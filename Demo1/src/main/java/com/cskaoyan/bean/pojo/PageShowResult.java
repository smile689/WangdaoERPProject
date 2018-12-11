package com.cskaoyan.bean.pojo;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zhoubin
 * @CreateDate: 2018/12/7 11:35
 * @需求:
 * @思路说明:
 */
public class PageShowResult {
    private long total;
    private List<?> rows;

    public PageShowResult() {
    }

    public PageShowResult(long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
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
