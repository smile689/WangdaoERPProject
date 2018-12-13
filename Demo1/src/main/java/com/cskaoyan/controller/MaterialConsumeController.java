package com.cskaoyan.controller;

import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.MaterialConsume;
import com.cskaoyan.bean.MaterialReceive;
import com.cskaoyan.bean.Work;
import com.cskaoyan.bean.pojo.PageShowResult;
import com.cskaoyan.service.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: zhoubin
 * @CreateDate: 2018/12/11 23:42
 * @需求:
 * @思路说明:
 */
@Controller
@RequestMapping("/materialConsume")
public class MaterialConsumeController {

    @Autowired
    MaterialConsumeService materialConsumeService;

    //跳转到物料消耗列表
    @RequestMapping("/find")
    public String findMaterialConsumeList (){
        return "materialConsume_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageShowResult showMaterialList (Integer page, Integer rows){
        PageShowResult list = materialConsumeService.getList(page, rows);
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
        return "materialConsume_add";
    }
    //新增物料收入信息
    @ResponseBody
    @RequestMapping("/insert")
    public Map addMaterReceive (MaterialConsume materialConsume,String workId,String materialId){
        //把workid和materialId封装到各自的对象中
        Material material = new Material();
        Work work = new Work();
        material.setMaterialId(materialId);
        work.setWorkId(workId);
        materialConsume.setMaterial(material);
        materialConsume.setWork(work);
        materialConsumeService.insertMaterialReceiveService(materialConsume);
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
        return "materialConsume_edit";
    }

    //进行物料收入编辑
    @ResponseBody
    @RequestMapping("/update_all")
    public Map updateMater (MaterialConsume materialConsume ,String workId,String materialId){
        Material material = new Material();
        Work work = new Work();
        material.setMaterialId(materialId);
        work.setWorkId(workId);
        materialConsume.setMaterial(material);
        materialConsume.setWork(work);
        materialConsumeService.updateMaterialConsumeService(materialConsume);

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
        materialConsumeService.deleteMaterialConsumeService(ids);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("status",200);
        hashMap.put("msg","失败");
        return hashMap;
    }

    //更新备注
    @ResponseBody
    @RequestMapping("/update_note")
    public Map updateMaterConsume (@RequestParam String consumeId, @RequestParam String note ){

        materialConsumeService.updateMaterialConsumeSelective(consumeId,note);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("status",200);
        hashMap.put("msg","失败");
        return hashMap;
    }

    //物料消耗ID模糊搜索
    @ResponseBody
    @RequestMapping("/search_materialConsume_by_consumeId")
    public PageShowResult  serachMaterialReceiveId (@RequestParam String searchValue, @RequestParam Integer page, @RequestParam Integer rows){
        PageShowResult pageShowResult = materialConsumeService.searcMaterialConsume(searchValue,page,rows);
        return pageShowResult;
    }

    //物料消耗里workID模糊搜索
    @ResponseBody
    @RequestMapping("/search_materialConsume_by_workId")
    public PageShowResult  serachMaterialConsumeWorkId(@RequestParam String searchValue,@RequestParam Integer page,@RequestParam Integer rows){
        MaterialConsume materialConsume = new MaterialConsume();
        Work work = new Work();
        work.setWorkId(searchValue);
        materialConsume.setWork(work);
        PageShowResult pageShowResult = materialConsumeService.serachMaterialWorkId(work,page,rows);
        return pageShowResult;
    }

    //物料消耗里materialID模糊搜索
    @ResponseBody
    @RequestMapping("/search_materialConsume_by_materialId")
    public PageShowResult  serachMaterialConsumeMaterialId(@RequestParam String searchValue,@RequestParam Integer page,@RequestParam Integer rows){
        MaterialConsume materialConsume = new MaterialConsume();
        Material material = new Material();
        material.setMaterialId(searchValue);
        materialConsume.setMaterial(material);
        PageShowResult pageShowResult = materialConsumeService.serachMateriaId(material,page,rows);
        return pageShowResult;
    }


}
