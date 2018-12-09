package com.cskaoyan.mapper;

import com.cskaoyan.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int insert(Product record);

    Product selectByPrimaryKey(String productId);

    List<Product> selectByPage(@Param("product")Product product);

    int deleteByPrimaryKey(String productId);

    int updateByPrimaryKey(Product record);

    List<Product> selectAll();
}