package com.cskaoyan.service.impl;

import com.cskaoyan.utils.EUDataGridResult;
import com.cskaoyan.bean.vo.ProcessMeasuretVo;
import com.cskaoyan.bean.ProcessMeasure;
import com.cskaoyan.mapper.ProcessMeasureMapper;
import com.cskaoyan.service.ProcessMeasuretService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessMeasuretServiceImp implements ProcessMeasuretService {

    //注入mapper对象
    @Autowired
    ProcessMeasureMapper processMeasureMapper;

    @Override
    public int deleteByPrimaryKey(String id) {

        int i = processMeasureMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public EUDataGridResult insert(ProcessMeasuretVo record) {
        //插入之前先查询这个主键是否有数据
        ProcessMeasure processMeasure = processMeasureMapper.selectByPrimaryKey(record.getpMeasureCheckId());
        int insert = -1;
        EUDataGridResult result = null;
        if(processMeasure == null)
        {
            insert = processMeasureMapper.insert(record);
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
    public int insertSelective(ProcessMeasuretVo record) {
        int i = processMeasureMapper.insertSelective(record);
        return i;
    }

    @Override
    public EUDataGridResult selectByPrimaryKey(String Id) {

        EUDataGridResult result = new EUDataGridResult();

        ProcessMeasure processMeasure = processMeasureMapper.selectByPrimaryKey(Id);

        List<ProcessMeasure> list = new ArrayList<>();

        if(processMeasure != null)
        {
            list.add(processMeasure);
            result.setStatus(200);
            result.setRows(list);
            result.setTotal(1);
        }
        else
        {
            result.setStatus(500);
            result.setMsg("NO");
        }

        return result;
    }

    @Override
    public EUDataGridResult updateByPrimaryKeySelective(ProcessMeasuretVo processCountVo) {
        //创建一个result对象
        EUDataGridResult result = new EUDataGridResult();
        int ii = processMeasureMapper.updateByPrimaryKeySelective(processCountVo);
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
    public int updateByPrimaryKey(ProcessMeasuretVo record) {
        int i = processMeasureMapper.updateByPrimaryKey(record);
        return i;
    }

    @Override
    public EUDataGridResult getItemList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page,rows);

        //分页对象
        EUDataGridResult result = new EUDataGridResult();

        List<ProcessMeasuretVo> list = processMeasureMapper.selectAll();


        //将list数据存入result对象
        result.setRows(list);

        //查询页面的数目
        PageInfo<ProcessMeasuretVo> pageInfo = new PageInfo<>(list);
        //将查询到的数目添加到result对象中
        result.setTotal(pageInfo.getTotal());

        //将页面信息返回到控制器
        return result;
    }

    @Override
    public EUDataGridResult deleteByIds(String[] ids) {
        //执行删除操作
        boolean b = processMeasureMapper.deleteByIds(ids);
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
        List<ProcessMeasure> list = processMeasureMapper.selectByOrderId(orderid);
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
