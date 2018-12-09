package com.cskaoyan.service;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.utils.JsonFindRet;

import java.util.List;

public interface ManufactureService {

    Manufacture findManufactureById(String manufactureSn);

    JsonFindRet<Manufacture> findManufactures(Manufacture manufacture, Integer page, Integer rows);

    boolean addManufacture(Manufacture manufacture);

    boolean updateManufacture(Manufacture manufacture);

    boolean deleteManufacture(String ids);

    List<Manufacture> findAll();
}
