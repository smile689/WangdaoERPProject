package com.cskaoyan.service;

import com.cskaoyan.bean.Technology;

import java.util.List;

public interface TechnologyService {

    Technology findTechnologyById(String technologyId);

    boolean updateTechnology(Technology technology);

    List<Technology> findAll();
}
