package com.cskaoyan.service;

import com.cskaoyan.bean.Process;

import java.util.List;

public interface ProcessService {

    List<Process> findAll();

    Process findProcessById(String processId);

    boolean updateProcess(Process process);
}
