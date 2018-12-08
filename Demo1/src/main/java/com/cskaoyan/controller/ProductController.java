package com.cskaoyan.controller;

import com.cskaoyan.bean.Product;
import com.cskaoyan.service.ProductService;
import com.cskaoyan.utils.JsonChangeRet;
import com.cskaoyan.utils.JsonFindRet;
import com.cskaoyan.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    //点击对应标签后跳转到list的jsp
    @RequestMapping("/find")
    public String findProductListJsp(){
        return "product_list";
    }

    @ResponseBody
    @RequestMapping("/get/{productId}")
    public Product getProductById(@PathVariable String productId){
        return productService.findProductById(productId);
    }

    //list.jsp发来的异步请求
    @ResponseBody
    @RequestMapping("/list")
    public JsonFindRet<Product> findCustoms(Integer page, Integer rows){
        Product product=new Product();
        JsonFindRet<Product> products = productService.findProducts(product, page, rows);
        System.out.println(products);
        return products;
    }


    //多条件查询
    @ResponseBody
    @RequestMapping("/search_product_by_productId")
    public JsonFindRet<Product> searchProductByProductId(String searchValue, Integer page, Integer rows){
        Product product=new Product();
        product.setProductId(searchValue);
        JsonFindRet<Product> products = productService.findProducts(product, page, rows);
        return products;
    }

    @ResponseBody
    @RequestMapping("/search_product_by_productName")
    public JsonFindRet<Product> searchProductByProductName(String searchValue, Integer page, Integer rows){
        Product product=new Product();
        product.setProductName(searchValue);
        JsonFindRet<Product> products = productService.findProducts(product, page, rows);
        return products;
    }

    @ResponseBody
    @RequestMapping("/search_product_by_productType")
    public JsonFindRet<Product> searchProductByProductType(String searchValue, Integer page, Integer rows){
        Product product=new Product();
        product.setProductType(searchValue);
        JsonFindRet<Product> products = productService.findProducts(product, page, rows);
        return products;
    }

    //修改权限检查
    @ResponseBody
    @RequestMapping(path = {"/add_judge", "/edit_judge", "/delete_judge"})
    public Map productJudge(){
        return null;
    }

//增加产品
    //打开添加信息窗口
    @RequestMapping("/add")
    public String findProductAddJsp(){
        return "product_add";
    }

    //处理信息添加，文件异步上传
    @ResponseBody
    @RequestMapping("/insert")
    public JsonChangeRet addProduct(@Valid Product product, BindingResult bindingResult){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        String errorMsg = ValidateUtil.handleError(bindingResult);
        if (errorMsg!=null&&!(errorMsg.trim().isEmpty())) {
            jsonChangeRet.setMsg(errorMsg);
            return jsonChangeRet;
        }
        if(productService.addProduct(product)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;
    }

    //修改
    @RequestMapping("/edit")
    public String findProductEditJsp(){
        return "product_edit";
    }

    //处理信息编辑，参数校验
    @ResponseBody
    @RequestMapping("/update_all")
    public JsonChangeRet updateProduct(@Valid Product product, BindingResult bindingResult){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        String errorMsg = ValidateUtil.handleError(bindingResult);
        if (errorMsg!=null&&!(errorMsg.trim().isEmpty())) {
            jsonChangeRet.setMsg(errorMsg);
            return jsonChangeRet;
        }
        if(productService.updateProduct(product)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;
    }

    //修改note，传来id和note
    @ResponseBody
    @RequestMapping("/update_note")
    public JsonChangeRet updateNode(Product product){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        if(productService.updateNote(product)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;
    }

    //删除
    @ResponseBody
    @RequestMapping("/delete_batch")
    public JsonChangeRet deleteProduct(String ids){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        boolean isDeleteAll = productService.deleteProduct(ids);
        if(isDeleteAll){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;
    }

}
