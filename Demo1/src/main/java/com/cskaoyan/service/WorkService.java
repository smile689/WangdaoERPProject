package com.cskaoyan.service;

import com.cskaoyan.bean.Work;
import com.cskaoyan.utils.JsonFindRet;

import java.util.List;

public interface WorkService {

    Work findWorkById(String workId);

    JsonFindRet<Work> findWorks(Work work, Integer page, Integer rows);

    boolean addWork(Work work);

    boolean updateWork(Work work);

    boolean deleteWork(String ids);

    List<Work> findAll();
}
