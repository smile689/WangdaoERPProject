package com.cskaoyan.service;

import com.cskaoyan.bean.pojo.PageShowResult;

/**
 * @Description: java类作用描述
 * @Author: zhoubin
 * @CreateDate: 2018/12/11 22:12
 * @需求:
 * @思路说明:
 */
public interface MaterialConsumeService {
    PageShowResult getList(Integer page, Integer rows);
}
