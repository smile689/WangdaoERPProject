package com.cskaoyan.service.impl;

import com.cskaoyan.utils.EUDataGridResult;
import com.cskaoyan.bean.vo.FinalMeasuretVo;
import com.cskaoyan.bean.FinalMeasuret;
import com.cskaoyan.mapper.FinalMeasuretMapper;
import com.cskaoyan.service.FinalMeasuretService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FinalMeasuretServiceImp implements FinalMeasuretService {

    @Autowired
    FinalMeasuretMapper finalMeasuretMapper;

    @Override
    public int deleteByPrimaryKey(String fMeasureCheckId) {
        int i = finalMeasuretMapper.deleteByPrimaryKey(fMeasureCheckId);
        return i;
    }

    @Override
    public EUDataGridResult insert(FinalMeasuret record) {
        //插入之前先查询这个主键是否有数据
        FinalMeasuret finalMeasuret = finalMeasuretMapper.selectByPrimaryKey(record.getfMeasureCheckId());
        int insert = -1;
        EUDataGridResult result = null;
        if(finalMeasuret == null)
        {
             insert = finalMeasuretMapper.insert(record);
        }
        if(insert == 1)
        {
           result = new EUDataGridResult();
           result.setMsg("OK");
           result.setStatus(200);
        }
        else
        {
            result.setStatus(500);
            result.setMsg("NO");
        }
        return result;
    }

    @Override
    public int insertSelective(FinalMeasuret record) {
        int i = finalMeasuretMapper.insertSelective(record);
        return i;
    }

    @Override
    public EUDataGridResult selectByPrimaryKey(String fMeasureCheckId) {

        EUDataGridResult result = new EUDataGridResult();
        FinalMeasuret finalMeasuret = finalMeasuretMapper.selectByPrimaryKey(fMeasureCheckId);

        List<FinalMeasuret> list = new ArrayList<>();
        if(result != null)
        {
            list.add(finalMeasuret);
            result.setStatus(200);
            result.setRows(list);
            result.setTotal(1);
        }

        return result;
    }


    @Override
    public EUDataGridResult updateByPrimaryKeySelective(FinalMeasuretVo finalMeasuretVo) {
        //创建一个result对象
        EUDataGridResult result = new EUDataGridResult();
        int ii = finalMeasuretMapper.updateByPrimaryKeySelective(finalMeasuretVo);
        if (ii == 1)
        {
            result.setMsg("OK");
            result.setStatus(200);
        }
        else
        {
            result.setStatus(500);
            result.setMsg("NO");
        }

        return result;
    }

    @Override
    public int updateByPrimaryKey(FinalMeasuret record) {
        int i = finalMeasuretMapper.updateByPrimaryKey(record);
        return i;
    }

    @Override
    public EUDataGridResult getItemList(int page, int rows) {

        //分页处理
        PageHelper.startPage(page,rows);

        //分页对象
        EUDataGridResult result = new EUDataGridResult();

        List<FinalMeasuretVo> list = finalMeasuretMapper.selectAll();


        //将list数据存入result对象
        result.setRows(list);

        //查询页面的数目
        PageInfo<FinalMeasuretVo> pageInfo = new PageInfo<>(list);
        //将查询到的数目添加到result对象中
        result.setTotal(pageInfo.getTotal());

        //将页面信息返回到控制器
        return result;
    }

    @Override
    public List<FinalMeasuretVo> selectAll() {
        List<FinalMeasuretVo> list  = finalMeasuretMapper.selectAll();

        return list;
    }

    @Override
    public EUDataGridResult deleteByIds(String[] ids) {
        //执行删除操作
        boolean b = finalMeasuretMapper.deleteByIds(ids);
        EUDataGridResult result = new EUDataGridResult();

        //判断是否删除成功
        if(b)
        {
            result.setMsg("OK");
            result.setStatus(200);
        }
        else
        {
            result.setStatus(500);
            result.setMsg("NO");
        }

        return  result;
    }

    @Override
    public EUDataGridResult selectByOrderId(String orderid) {
         EUDataGridResult result = new EUDataGridResult();
        List<FinalMeasuretVo> list = finalMeasuretMapper.selectByOrderId(orderid);
        if(list.size() > 0)
        {
            result.setTotal(list.size());
            result.setRows(list);
            result.setStatus(200);
            result.setMsg("OK");
        }
        else
        {
            result.setMsg("NO");
            result.setStatus(500);
        }

        return result;
    }
}
