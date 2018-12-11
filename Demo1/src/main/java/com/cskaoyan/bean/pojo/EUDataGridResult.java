package com.cskaoyan.bean.pojo;

import java.util.List;

public class EUDataGridResult {

    private long total;

    private List<?> rows;

    @Override
    public String toString() {
        return "EUDataGridResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
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
