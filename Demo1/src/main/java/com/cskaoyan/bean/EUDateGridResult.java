package com.cskaoyan.bean;



import java.util.List;


public class EUDateGridResult {


    private long total;
    private List<?> rows;

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
