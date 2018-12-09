package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Process;
import com.cskaoyan.mapper.ProcessMapper;
import com.cskaoyan.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    ProcessMapper processMapper;

    @Override
    public List<Process> findAll() {
        return processMapper.selectAll();
    }

    @Override
    public Process findProcessById(String processId) {
        return processMapper.selectByPrimaryKey(processId);
    }

    @Override
    public boolean updateProcess(Process process) {
        return processMapper.updateByPrimaryKey(process)==1;
    }
}
