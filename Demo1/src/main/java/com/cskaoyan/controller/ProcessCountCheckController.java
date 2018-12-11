package com.cskaoyan.controller;

import com.cskaoyan.utils.EUDataGridResult;
import com.cskaoyan.bean.Vo.ProcessCountVo;
import com.cskaoyan.service.ProcessCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/p_count_check")
public class ProcessCountCheckController {

    @Autowired
    ProcessCountCheckService processCountCheckService;


    //由home.jsp 点击 转向详情页
    @RequestMapping("/find")
    public String toPMeasurecheck()
    {
        return "/p_count_check_list";
    }

    //查询分页信息处理
    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page, Integer rows)
    {
        EUDataGridResult result = processCountCheckService.getItemList(page, rows);
        if(result != null)
        {
            return  result;
        }
        else
        {
            return null;
        }
    }


    //在窗口打开质量计数的界面
    @RequestMapping("/add")
    public String toOpenAdd()
    {
        return "/p_count_check_add";
    }

    //新增产品质量计数
    @RequestMapping("/insert")
    @ResponseBody
    public EUDataGridResult toAddPCount(ProcessCountVo processCountVo)
    {
        EUDataGridResult insert = processCountCheckService.insert(processCountVo);
        return insert;
    }


//  *********************************编辑页面*****************************




    //在窗口打开质量计数的界面
    @RequestMapping("/edit")
    public String toOpenEdit()
    {
        return "/p_count_check_edit";
    }

    //新窗口打开编辑页面
    @RequestMapping("/update_all")
    @ResponseBody
    public EUDataGridResult EditPCount(ProcessCountVo processCountVo)
    {

        //更新产品计数质检
        EUDataGridResult result = processCountCheckService.updateByPrimaryKeySelective(processCountVo);

        //如果更新成功  则在返回的信息中添加状态
        if(result != null)
        {
            return  result;
        }
        else
        {
            return null;
        }


    }

    //**********************删除界面********************
    //执行删除的操作
    @RequestMapping("/delete_batch")
    @ResponseBody
    public EUDataGridResult toDoDelete(String  ids)
    {
        String[] idss = ids.split(",");

        EUDataGridResult result = processCountCheckService.deleteByIds(idss);

        if(result != null)
            return result;

        return result;
    }

//    *************************搜索功能实现********************

    //通过成品id 查询
    @RequestMapping("/search_pCountCheck_by_pCountCheckId")
    @ResponseBody
    public EUDataGridResult toSearchByPCountcheckId(int searchValue, int page, int rows)
    {

        EUDataGridResult result = processCountCheckService.selectByPrimaryKey(Integer.toString(searchValue));
        if(result != null)
        {
            return result;
        }
        else
        {
            return null;
        }

    }




}
