package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Product;
import com.cskaoyan.mapper.ProductMapper;
import com.cskaoyan.service.ProductService;
import com.cskaoyan.utils.JsonFindRet;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Transactional(readOnly = true)
    @Override
    public Product findProductById(String productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Transactional(readOnly = true)
    @Override
    public JsonFindRet<Product> findProducts(Product product, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Product> productList = productMapper.selectByPage(product);
        PageInfo<Product> customPageInfo=new PageInfo<>(productList);
        System.out.println("pageInfo="+customPageInfo);
        System.out.println(productList);
        JsonFindRet<Product> jsonFindRet=new JsonFindRet<>();
        jsonFindRet.setTotal(customPageInfo.getTotal());
        jsonFindRet.setRows(productList);
        return jsonFindRet;
    }

    @Transactional
    @Override
    public boolean addProduct(Product product) {
        return productMapper.insert(product)==1;
    }

    @Transactional
    @Override
    public boolean updateProduct(Product product) {
        return productMapper.updateByPrimaryKey(product)==1;
    }

    @Transactional
    @Override
    public boolean deleteProduct(String ids) {
        String[] idList = ids.split(",");
        for (String idToDelete: idList) {
            if(productMapper.deleteByPrimaryKey(idToDelete)!=1){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean updateNote(Product product) {
        Product productToUpdateNote = productMapper.selectByPrimaryKey(product.getProductId());
        productToUpdateNote.setNote(product.getNote());
        return productMapper.updateByPrimaryKey(productToUpdateNote)==1;
    }

    @Override
    public List<Product> findAll() {
        return productMapper.selectAll();
    }
}
