package com.cskaoyan.controller;

import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.pojo.PageShowResult;
import com.cskaoyan.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: zhoubin
 * @CreateDate: 2018/12/6 16:54
 * @需求:
 * @思路说明:
 */
@Controller
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    MaterialService materialService;

    //跳转到物料列表
    @RequestMapping("/find")
    public String findMaterialList (){
        return "material_list";
    }
    /**
     *
     * @param page 页数
     * @param rows 每一页的数量
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public PageShowResult showMaterialList (Integer page,Integer rows){
        PageShowResult list = materialService.getList(page, rows);
        return list;
    }

    @ResponseBody
    @RequestMapping("/add_judge")
    public Map addShow(){
        return null;
    }
    @RequestMapping("/add")
    public String addMaterPage (){
       return "material_add";
    }

    /**
     * 新增物料方法
     * @param material
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public Map addMater (Material material){
        materialService.insertMaterialService(material);
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
        return "material_edit";
    }

//进行物料编辑
    @ResponseBody
    @RequestMapping("/update_all")
    public Map updateMater (Material material){

        materialService.updateMaterialService(material);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("status",200);
        hashMap.put("msg","失败");
        return hashMap;
    }
//更新备注
    @ResponseBody
    @RequestMapping("/update_note")
    public Map updateMater (@RequestParam String materialId, @RequestParam String note ){

        materialService.updateMaterialServiceSelective(materialId,note);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("status",200);
        hashMap.put("msg","失败");
        return hashMap;
    }

//删除物料信息
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map deleteShow(){
        return null;
    }
    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map deleteMaterPage (String[] ids){
        materialService.deleteMaterialService(ids);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("status",200);
        hashMap.put("msg","失败");
        return hashMap;
    }
//物料ID模糊搜索
    @ResponseBody
    @RequestMapping("/search_material_by_materialId")
    public PageShowResult serachMaterialId (@RequestParam String searchValue, @RequestParam Integer page, @RequestParam Integer rows){
        PageShowResult pageShowResult = materialService.searcMaterial(searchValue,page,rows);
        return pageShowResult;
    }
//物料类型模糊搜索
    @ResponseBody
    @RequestMapping("/search_material_by_materialType")
    public PageShowResult  serachMaterialtype(@RequestParam String searchValue,@RequestParam Integer page,@RequestParam Integer rows){
        PageShowResult pageShowResult = materialService.searcMaterialtype(searchValue,page,rows);
        return pageShowResult;
    }

    //物料收入页面中新增物料页面获取物料ID
    @ResponseBody
    @RequestMapping("/get_data")
    public List<Material> getdata(){
       List<Material> materials= materialService.getMaterial();
       return materials;
    }

    //物料收入列表中点击物料ID查看物料信息
    @ResponseBody
    @RequestMapping(value = "/get/{materialId}")
    public Material getMaterialinfo(@PathVariable("materialId") String materialId){
        Material material = materialService.selectByMaterialId(materialId);
        return material;
    }
}
