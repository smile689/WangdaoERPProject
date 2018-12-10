package com.cskaoyan.controller.JsonResult;

import java.util.List;

/**
 * 分页工具
 * 使用mybatis分页插件及eazyui datagrid的数据容器.
 *
 * eazyui datagrid 需要接受总数据条数 total 和 总数据 rows 才能正常在前台显示出数据.
 *
 * */
public class EUDataGridResult {

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
