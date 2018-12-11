package com.cskaoyan.controller;

import com.cskaoyan.Utils.EUDataGridResult;
import com.cskaoyan.bean.Vo.UnqualifyApplyVo;
import com.cskaoyan.service.UnqualifyApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/unqualify")
public class UnqualifyApplyController {


    @Autowired
    UnqualifyApplyService unqualifyApplyService;

    //由home.jsp 点击 转向详情页
    @RequestMapping("/find")
    public String toUnQualifyApplycheck()
    {
        return "/unqualify_list";
    }

    //查询分页信息处理
    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page, Integer rows)
    {
        EUDataGridResult result = unqualifyApplyService.getItemList(page, rows);
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
        return "/unqualify_add";
    }

    //新增产品质量计数
    @RequestMapping("/insert")
    @ResponseBody
    public EUDataGridResult toAddPCount(UnqualifyApplyVo unqualifyApplyVo)
    {
        EUDataGridResult insert = unqualifyApplyService.insert(unqualifyApplyVo);
        return insert;
    }


//  *********************************编辑页面*****************************




    //在窗口打开质量计数的界面
    @RequestMapping("/edit")
    public String toOpenEdit()
    {
        return "/unqualify_edit";
    }

    //新窗口打开编辑页面
    @RequestMapping("/update_all")
    @ResponseBody
    public EUDataGridResult EditUnQualifyApply(UnqualifyApplyVo unqualifyApplyVo)
    {

        //更新产品计数质检
        EUDataGridResult result = unqualifyApplyService.updateByPrimaryKeySelective(unqualifyApplyVo);

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

        EUDataGridResult result = unqualifyApplyService.deleteByIds(idss);

        if(result != null)
            return result;

        return result;
    }

//    *************************搜索功能实现********************

    //通过成品id 查询
    @RequestMapping("/search_unqualify_by_unqualifyId")
    @ResponseBody
    public EUDataGridResult toSearchByUnqualifyId(String searchValue, int page, int rows)
    {

        EUDataGridResult result = unqualifyApplyService.selectByPrimaryKey(searchValue);
        if(result != null)
        {
            return result;
        }
        else
        {
            return null;
        }

    }


    //通过订单编号查询
    @RequestMapping("/search_unqualify_by_productName")
    @ResponseBody
    public EUDataGridResult toSearchByProductName(String  searchValue, int page, int rows)
    {
        EUDataGridResult result = unqualifyApplyService.selectByProductName(searchValue);

        if(result != null)
            return result;
        else
            return null;
    }

}
