package com.cskaoyan.controller;

import com.cskaoyan.bean.Corder;
import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.Product;
import com.cskaoyan.service.CorderService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class CorderController {

    @Autowired
    CorderService corderService;

    //点击对应标签后跳转到list的jsp
    @RequestMapping("/find")
    public String findOrderListJsp(){
        return "order_list";
    }

    @ResponseBody
    @RequestMapping("/list")
    public JsonFindRet<Corder> findCustoms(Integer page, Integer rows){
        Corder corder=new Corder();
        JsonFindRet<Corder> orders = corderService.findOrders(corder, page, rows);
        return orders;
    }

    //多条件查询
    @ResponseBody
    @RequestMapping("/search_order_by_orderId")
    public JsonFindRet<Corder> searchCustomByOrderId(String searchValue,Integer page, Integer rows){
        Corder corder=new Corder();
        corder.setOrderId(searchValue);
        JsonFindRet<Corder> orders = corderService.findOrders(corder, page, rows);
        return orders;
    }

    @ResponseBody
    @RequestMapping("/search_order_by_orderCustom")
    public JsonFindRet<Corder> searchCustomByCustomName(String searchValue,Integer page, Integer rows){
        Custom custom=new Custom();
        custom.setCustomName(searchValue);
        Corder corder=new Corder();
        corder.setCustom(custom);
        JsonFindRet<Corder> orders = corderService.findOrders(corder, page, rows);
        return orders;
    }

    @ResponseBody
    @RequestMapping("/search_order_by_orderProduct")
    public JsonFindRet<Corder> searchCustomByProductName(String searchValue,Integer page, Integer rows){
        Product product=new Product();
        product.setProductName(searchValue);
        Corder corder=new Corder();
        corder.setProduct(product);
        JsonFindRet<Corder> orders = corderService.findOrders(corder, page, rows);
        return orders;
    }

    //找到所有订单
    @ResponseBody
    @RequestMapping("/get_data")
    public List<Corder> findAllOrder(){
        return corderService.findAll();
    }

    //根据id找订单
    @ResponseBody
    @RequestMapping("/get/{orderId}")
    public Corder getOrderById(@PathVariable String orderId){
        return corderService.findOrderById(orderId);
    }

    //判断修改权限
    @ResponseBody
    @RequestMapping(path = {"/add_judge","/edit_judge","/delete_judge"})
    public Map orderJudge(){
        return null;
    }

    //打开添加信息窗口
    @RequestMapping("/add")
    public String findOrderAddJsp(){
        return "order_add";
    }

    //处理添加
    //处理添加的信息，参数校验
    @ResponseBody
    @RequestMapping("/insert")
    public JsonChangeRet addOrder(@Valid Corder corder, BindingResult bindingResult, Custom custom, Product product){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        String errorMsg = ValidateUtil.handleError(bindingResult);
        if (errorMsg!=null&&!(errorMsg.trim().isEmpty())) {
            jsonChangeRet.setMsg(errorMsg);
            return jsonChangeRet;
        }
        corder.setProduct(product);
        corder.setCustom(custom);
        if(corderService.addOrder(corder)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;
    }

    //打开编辑信息窗口
    @RequestMapping("/edit")
    public String findOrderEditJsp(){
        return "order_edit";
    }

    //处理信息编辑，参数校验
    @ResponseBody
    @RequestMapping("/update_all")
    public JsonChangeRet updateOrder(@Valid Corder corder, BindingResult bindingResult, Custom custom, Product product){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        String errorMsg = ValidateUtil.handleError(bindingResult);
        if (errorMsg!=null&&!(errorMsg.trim().isEmpty())) {
            jsonChangeRet.setMsg(errorMsg);
            return jsonChangeRet;
        }
        corder.setProduct(product);
        corder.setCustom(custom);
        if(corderService.updateOrder(corder)){
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
    public JsonChangeRet updateNode(Corder corder){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        if(corderService.updateNote(corder)){
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
    public JsonChangeRet deleteOrder(String ids){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        boolean isDeleteAll = corderService.deleteOrder(ids);
        if(isDeleteAll){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;
    }

}
