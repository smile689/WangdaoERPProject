package com.cskaoyan.controller;

import com.cskaoyan.utils.EUDataGridResult;
import com.cskaoyan.bean.vo.FinalMeasuretVo;
import com.cskaoyan.bean.FinalMeasuret;
import com.cskaoyan.service.FinalMeasuretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/measure")
public class FinalMeasuretController {

    @Autowired
    FinalMeasuretService finalMeasuretService;



    //由home.jsp 点击 转向详情页
    @RequestMapping("/find")
    public String toFMeasurecheck()
    {
        return "/measurement_list";
    }

    //查询分页信息处理
    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page, Integer rows)
    {
        EUDataGridResult result = finalMeasuretService.getItemList(page, rows);
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
        return "/measurement_add";
    }

    //新增产品质量计数
    @RequestMapping("/insert")
    @ResponseBody
    public EUDataGridResult toAddFCount(FinalMeasuret finalMeasuret)
    {
        EUDataGridResult insert = finalMeasuretService.insert(finalMeasuret);
        return insert;
    }


//  *********************************编辑页面*****************************




    //在窗口打开质量计数的界面
    @RequestMapping("/edit")
    public String toOpenEdit()
    {
        return "/measurement_edit";
    }

    //新窗口打开编辑页面
    @RequestMapping("/update_all")
    @ResponseBody
    public EUDataGridResult EditFMeasuret(FinalMeasuretVo finalMeasuretVo)
    {

        //更新产品计数质检
        EUDataGridResult result = finalMeasuretService.updateByPrimaryKeySelective(finalMeasuretVo);

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

        EUDataGridResult result = finalMeasuretService.deleteByIds(idss);

        if(result != null)
            return result;

        return result;
    }

//    *************************搜索功能实现********************

    //通过成品id 查询
    @RequestMapping("/search_fMeasureCheck_by_fMeasureCheckId")
    @ResponseBody
    public EUDataGridResult toSearchByFcheckId(int searchValue, int page, int rows)
    {

        EUDataGridResult result = finalMeasuretService.selectByPrimaryKey(Integer.toString(searchValue));
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
    @RequestMapping("/search_fMeasureCheck_by_orderId")
    @ResponseBody
    public EUDataGridResult toSearchByOrderId(String  searchValue, int page, int rows)
    {
        EUDataGridResult result = finalMeasuretService.selectByOrderId(searchValue);

        if(result != null)
            return result;
        else
            return null;
    }

}
