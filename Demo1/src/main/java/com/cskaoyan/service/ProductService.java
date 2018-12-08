package com.cskaoyan.service;

import com.cskaoyan.bean.Product;
import com.cskaoyan.utils.JsonFindRet;

public interface ProductService {

    Product findProductById(String productId);

    JsonFindRet<Product> findProducts(Product product, Integer page, Integer rows);

    boolean addProduct(Product product);

    boolean updateProduct(Product product);

    boolean deleteProduct(String ids);

    boolean updateNote(Product product);
}
