package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Work;
import com.cskaoyan.mapper.WorkMapper;
import com.cskaoyan.service.WorkService;
import com.cskaoyan.utils.JsonFindRet;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    WorkMapper workMapper;


    @Transactional(readOnly = true)
    @Override
    public Work findWorkById(String workId) {
        return workMapper.selectByPrimaryKey(workId);
    }

    @Transactional(readOnly = true)
    @Override
    public JsonFindRet<Work> findWorks(Work work, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Work> workList = workMapper.selectByPage(work);
        PageInfo<Work> workPageInfo=new PageInfo<>(workList);
        JsonFindRet<Work> jsonFindRet=new JsonFindRet<>();
        jsonFindRet.setTotal(workPageInfo.getTotal());
        jsonFindRet.setRows(workList);
        return jsonFindRet;
    }

    @Transactional
    @Override
    public boolean addWork(Work work) {
        return workMapper.insert(work)==1;
    }

    @Transactional
    @Override
    public boolean updateWork(Work work) {
        return workMapper.updateByPrimaryKey(work)==1;
    }

    @Transactional
    @Override
    public boolean deleteWork(String ids) {
        String[] split = ids.split(",");
        for (String id:split) {
            if(workMapper.deleteByPrimaryKey(id)!=1){
                return false;
            }
        }
         return true;
    }

    @Override
    public List<Work> findAll() {
        return workMapper.selectAll();
    }
}
