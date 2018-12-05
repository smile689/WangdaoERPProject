package com.cskaoyan.mapper;

import com.cskaoyan.bean.Product;

public interface ProductMapper {
    int insert(Product record);

    int insertSelective(Product record);
}