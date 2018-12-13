package com.cskaoyan.controller;

import com.cskaoyan.service.FinalCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class MaterialControllerPowerController {

    //******************************成品计数的权限管理****************
    @Autowired
    //将 成品计数的对象  注入
     FinalCountCheckService finalCountCheckService;

    //转向增加质量计数的窗口  权限判断
    @RequestMapping("/fCountCheck/add_judge")
    @ResponseBody
    public Map toShowCountAddJudge()
    {
        return null;
    }

    //编辑权限管理的界面  暂时先通过处理
    @RequestMapping("/fCountCheck/edit_judge")
    @ResponseBody
    public Map editCountShowJudge()
    {
        return null;
    }

    //删除权限的界面  暂时先通过处理
    @RequestMapping("/fCountCheck/delete_judge")
    @ResponseBody
    public Map deleteCountShowJudge()
    {
        return null;
    }




    //**********************成品计量的权限管理****************

    //转向增加质量计数的窗口  权限判断
    @RequestMapping("/fMeasureCheck/add_judge")
    @ResponseBody
    public Map toShowMeasureAddJudge()
    {
        return null;
    }

    //编辑权限管理的界面  暂时先通过处理
    @RequestMapping("/fMeasureCheck/edit_judge")
    @ResponseBody
    public Map editMeasureShowJudge()
    {
        return null;
    }

    //删除权限的界面  暂时先通过处理
    @RequestMapping("/fMeasureCheck/delete_judge")
    @ResponseBody
    public Map deleteMeasureShowJudge()
    {
        return null;
    }


//    ***********************工序计数权限管理*******************



    @RequestMapping("/pCountCheck/add_judge")
    @ResponseBody
    public Map toShowPCountAddJudge()
    {
        return null;
    }

    //编辑权限管理的界面  暂时先通过处理
    @RequestMapping("/pCountCheck/edit_judge")
    @ResponseBody
    public Map editPCountShowJudge()
    {
        return null;
    }

    //删除权限的界面  暂时先通过处理
    @RequestMapping("/pCountCheck/delete_judge")
    @ResponseBody
    public Map deletePCountShowJudge()
    {
        return null;
    }



    @RequestMapping("/pMeasureCheck/add_judge")
    @ResponseBody
    public Map toShowPMeasureAddJudge()
    {
        return null;
    }

    //编辑权限管理的界面  暂时先通过处理
    @RequestMapping("/pMeasureCheck/edit_judge")
    @ResponseBody
    public Map editPMeasureShowJudge()
    {
        return null;
    }

    //删除权限的界面  暂时先通过处理
    @RequestMapping("/pMeasureCheck/delete_judge")
    @ResponseBody
    public Map deletePMeasureShowJudge()
    {
        return null;
    }



    @RequestMapping("/unqualify/add_judge")
    @ResponseBody
    public Map toShowUnqualifyAddJudge()
    {
        return null;
    }

    //编辑权限管理的界面  暂时先通过处理
    @RequestMapping("/unqualify/edit_judge")
    @ResponseBody
    public Map editUnqualifyShowJudge()
    {
        return null;
    }

    //删除权限的界面  暂时先通过处理
    @RequestMapping("/unqualify/delete_judge")
    @ResponseBody
    public Map deleteUnqualifyShowJudge()
    {
        return null;
    }

}
