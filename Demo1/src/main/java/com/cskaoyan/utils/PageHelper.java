package com.cskaoyan.utils;

import java.util.List;

/**
 * @author WangGuoming
 * created on 2018/11/10
 */
public class PageHelper<T> {
    private List<T> records;
    private int totalRecordsNum;
    private int totalPageNum;
    private int currentPageNum;
    private int prevPageNum;
    private int nextPageNum;

    public PageHelper() {
    }

    public PageHelper(int totalRecordsNum, int currentPageNum, int perPageNum) {
        this.totalRecordsNum = totalRecordsNum;
        this.totalPageNum = (totalRecordsNum + perPageNum - 1) / perPageNum;
        this.currentPageNum = currentPageNum;
        this.prevPageNum = currentPageNum - 1 < 1 ? currentPageNum : currentPageNum - 1;
        this.nextPageNum = currentPageNum + 1 > this.totalPageNum ? currentPageNum : currentPageNum + 1;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public int getTotalRecordsNum() {
        return totalRecordsNum;
    }

    public void setTotalRecordsNum(int totalRecordsNum) {
        this.totalRecordsNum = totalRecordsNum;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public int getPrevPageNum() {
        return prevPageNum;
    }

    public void setPrevPageNum(int prevPageNum) {
        this.prevPageNum = prevPageNum;
    }

    public int getNextPageNum() {
        return nextPageNum;
    }

    public void setNextPageNum(int nextPageNum) {
        this.nextPageNum = nextPageNum;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalRecordsNum=" + totalRecordsNum +
                ", currentPageNum=" + currentPageNum +
                ", totalPageNum=" + totalPageNum +
                ", prevPageNum=" + prevPageNum +
                ", nextPageNum=" + nextPageNum +
                ", records=" + records +
                '}';
    }
}
