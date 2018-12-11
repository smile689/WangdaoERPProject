package com.cskaoyan.controller;

import com.cskaoyan.bean.Vo.FinalCountVo;
import com.cskaoyan.bean.FinalCount;
import com.cskaoyan.service.FinalCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cskaoyan.Utils.EUDataGridResult;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/f_count_check")
public class FinalCountCheckController {

    @Autowired
    //将 成品计数的对象  注入
    FinalCountCheckService finalCountCheckService;

//  ************************增加操作*************************
    //由home.jsp 点击 转向详情页
    @RequestMapping("/find")
    public String tofcountcheck()
    {
        return "/f_count_check_list";
    }

    //查询分页信息处理
    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page,Integer rows)
    {
        EUDataGridResult itemList = finalCountCheckService.getItemList(page, rows);
        return  itemList;
    }




    //在窗口打开质量计数的界面
    @RequestMapping("/add")
    public String toOpenAdd()
    {
        return "/f_count_check_add";
    }

    //新增产品质量计数
    @RequestMapping("/insert")
    @ResponseBody
    public EUDataGridResult toAddFCount(FinalCountVo finalCountVo)
    {
        //创建一个result对象

        EUDataGridResult result = new EUDataGridResult();
        //查询该成品计数质检编号下在数据库中存在
        FinalCount finalCount = finalCountCheckService.selectByPrimaryKey(finalCountVo.getfCountCheckId());
        //如果存在， 则添加返回的数据，提示用户
        if(finalCount != null )
            result.setMsg("该成品计数质检编号已经存在，请更换！");

        //插入产品计数质检
        int insert1 = finalCountCheckService.insert(finalCountVo);

        //如果插入成功  则在返回的信息中添加状态
        if(insert1 == 1)
        {
            result.setStatus(200);
        }

        return result;
    }


//  *********************************编辑页面*****************************




    //在窗口打开质量计数的界面
    @RequestMapping("/edit")
    public String toOpenEdit()
    {
        return "/f_count_check_edit";
    }

    //新窗口打开编辑页面
    @RequestMapping("/update_all")
    @ResponseBody
    public EUDataGridResult EditFCount(FinalCountVo finalCountVo)
    {
        //创建一个result对象
        EUDataGridResult result = new EUDataGridResult();

        //更新产品计数质检
        int i = finalCountCheckService.updateByPrimaryKeySelective(finalCountVo);

        //如果更新成功  则在返回的信息中添加状态
        if(i == 1)
        {
            result.setStatus(200);
        }

        return result;
    }



    //****************************删除操作************************

    //执行删除的操作
    @RequestMapping("/delete_batch")
    @ResponseBody
    public EUDataGridResult toDoDelete(String  ids)
    {
        String[] idss = ids.split(",");

        //EUDataGridResult result = new EUDataGridResult();
        //int i = finalCountCheckService.deleteByPrimaryKey(ids);
        EUDataGridResult result = finalCountCheckService.deleteByIds(idss);

        if(result != null)
            return result;

        return result;
    }


//    *************************搜索功能实现********************

    //通过成品id 查询
    @RequestMapping("/search_fCountCheck_by_fCountCheckId")
    @ResponseBody
    public EUDataGridResult toSearchByFcheckId(int searchValue, int page, int rows)
    {
        //System.out.println("searchValue:"+searchValue +" page:"+page+" rows:"+rows);
        EUDataGridResult result = new EUDataGridResult();
        FinalCount finalCount = finalCountCheckService.selectByPrimaryKey(Integer.toString(searchValue));

        if(finalCount != null)
        {
            List list = new ArrayList();
            list.add(finalCount);
            result.setRows(list);
            result.setTotal(1);
            result.setMsg("OK");
            result.setStatus(200);
        }
        else
        {
            result.setStatus(500);
            result.setMsg("未查询到数据");
        }

        return result;

    }



    //通过订单编号查询
    @RequestMapping("/search_fCountCheck_by_orderId")
    @ResponseBody
    public EUDataGridResult toSearchByOrderId(String  searchValue, int page, int rows)
    {
        EUDataGridResult result = finalCountCheckService.selectByOrderId(searchValue);
        if(result != null)
            return result;
        else
            return null;

    }





}
