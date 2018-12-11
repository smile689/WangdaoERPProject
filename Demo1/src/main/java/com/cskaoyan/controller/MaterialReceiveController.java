package com.cskaoyan.controller;

import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.MaterialReceive;
import com.cskaoyan.pojo.PageShowResult;
import com.cskaoyan.service.MaterialReceiveService;
import com.cskaoyan.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: zhoubin
 * @CreateDate: 2018/12/10 20:31
 * @需求:
 * @思路说明:
 */
@Controller
@RequestMapping("/materialReceive")
public class MaterialReceiveController {

    @Autowired
    MaterialReceiveService materialReceiveService;

    //跳转到物料列表
    @RequestMapping("/find")
    public String findMaterialReceiveList (){
        return "materialReceive_list";
    }
    /**
     *查询物料收入列表
     * @param page 页数
     * @param rows 每一页的数量
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public PageShowResult showMaterialList (Integer page, Integer rows){
        PageShowResult list = materialReceiveService.getList(page, rows);
        return list;
    }

    //跳转到新增页面
    @ResponseBody
    @RequestMapping("/add_judge")
    public Map addShow(){
        return null;
    }
    @RequestMapping("/add")
    public String addMaterReceivePage (){
        return "materialReceive_add";
    }
    //新增物料收入信息
    @ResponseBody
    @RequestMapping("/insert")
    public Map addMaterReceive (MaterialReceive materialReceive, String materialId){
        materialReceiveService.insertMaterialReceiveService(materialReceive,materialId);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("status",200);
        hashMap.put("msg","失败");
        return hashMap;
    }

    //跳转到物料编辑页面
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map editShow(){
        return null;
    }
    @RequestMapping("/edit")
    public String editMaterPage (){
        return "materialReceive_edit";
    }

    //进行物料收入编辑
    @ResponseBody
    @RequestMapping("/update_all")
    public Map updateMater (MaterialReceive materialReceive ,String materialId){

        materialReceiveService.updateMaterialReceiveService(materialReceive,materialId);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("status",200);
        hashMap.put("msg","失败");
        return hashMap;
    }

    //删除物料收入信息
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map deleteShow(){
        return null;
    }
    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map deleteMaterPage (String[] ids){
        materialReceiveService.deleteMaterialReceiveService(ids);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("status",200);
        hashMap.put("msg","失败");
        return hashMap;
    }

    //物料收入ID模糊搜索
    @ResponseBody
    @RequestMapping("/search_materialReceive_by_receiveId")
    public PageShowResult  serachMaterialReceiveId (@RequestParam String searchValue, @RequestParam Integer page, @RequestParam Integer rows){
        PageShowResult pageShowResult = materialReceiveService.searcMaterialReveice(searchValue,page,rows);
        return pageShowResult;
    }
   //物料收入里物料ID模糊搜索
    @ResponseBody
    @RequestMapping("/search_materialReceive_by_materialId")
    public PageShowResult  serachMaterialReceive(@RequestParam String searchValue,@RequestParam Integer page,@RequestParam Integer rows){
        MaterialReceive materialReceive = new MaterialReceive();
        Material material = new Material();
        material.setMaterialId(searchValue);
        materialReceive.setMaterial(material);
        PageShowResult pageShowResult = materialReceiveService.serachMaterialReceiveMaterialId(material,page,rows);
        return pageShowResult;
    }
    //更新备注
    @ResponseBody
    @RequestMapping("/update_note")
    public Map updateMaterReceive (@RequestParam String receiveId, @RequestParam String note ){

        materialReceiveService.updateMaterialReceiveSelective(receiveId,note);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("status",200);
        hashMap.put("msg","失败");
        return hashMap;
    }
}
