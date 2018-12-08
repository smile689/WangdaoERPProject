package com.cskaoyan.utils;

//添加信息的数据返回形式
public class JsonChangeRet {
    int status;
    String msg;
    String data;

    @Override
    public String toString() {
        return "JsonAddRet{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
