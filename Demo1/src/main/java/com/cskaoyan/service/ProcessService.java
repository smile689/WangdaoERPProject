package com.cskaoyan.service;

import com.cskaoyan.bean.Process;

import java.util.ArrayList;

public interface ProcessService {
     Process findProcessById(String process_id);

    int deleteProcessById(String process_id);
}
