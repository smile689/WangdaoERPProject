package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Process;
import com.cskaoyan.mapper.ProcessMapper;
import com.cskaoyan.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    ProcessMapper processMapper;
    @Override
    public Process findProcessById(String process_id) {
        return  processMapper.selectByPrimaryKey(process_id);

    }

    @Override
    public int deleteProcessById(String process_id) {
        int i = processMapper.deleteByPrimaryKey(process_id);
        return i;
    }

}
