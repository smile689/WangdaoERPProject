package com.cskaoyan.service.impl;

import com.cskaoyan.utils.EUDataGridResult;
import com.cskaoyan.bean.Vo.ProcessCountVo;
import com.cskaoyan.bean.ProcessCount;
import com.cskaoyan.mapper.ProcessCountMapper;
import com.cskaoyan.service.ProcessCountCheckService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessCountCheckServiceImp implements ProcessCountCheckService {

    @Autowired
    ProcessCountMapper processCountMapper;

    @Override
    public int deleteByPrimaryKey(String id) {

        int i = processCountMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public EUDataGridResult insert(ProcessCount record) {
        //插入之前先查询这个主键是否有数据
        ProcessCount processCount = processCountMapper.selectByPrimaryKey(record.getpCountCheckId());
        int insert = -1;
        EUDataGridResult result = null;
        if(processCount == null)
        {
            insert = processCountMapper.insert(record);
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
    public int insertSelective(ProcessCount record) {
        int i = processCountMapper.insertSelective(record);
        return i;
    }

    @Override
    public EUDataGridResult selectByPrimaryKey(String Id) {

        EUDataGridResult result = new EUDataGridResult();

        ProcessCount processCount = processCountMapper.selectByPrimaryKey(Id);

        List<ProcessCount> list = new ArrayList<>();

        if(processCount != null)
        {
            list.add(processCount);
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
    public EUDataGridResult updateByPrimaryKeySelective(ProcessCountVo processCountVo) {
        //创建一个result对象
        EUDataGridResult result = new EUDataGridResult();
        int ii = processCountMapper.updateByPrimaryKeySelective(processCountVo);
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
    public int updateByPrimaryKey(ProcessCountVo record) {
        int i = processCountMapper.updateByPrimaryKey(record);
        return i;
    }

    @Override
    public EUDataGridResult getItemList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page,rows);

        //分页对象
        EUDataGridResult result = new EUDataGridResult();

        List<ProcessCountVo> list = processCountMapper.selectAll();


        //将list数据存入result对象
        result.setRows(list);

        //查询页面的数目
        PageInfo<ProcessCountVo> pageInfo = new PageInfo<>(list);
        //将查询到的数目添加到result对象中
        result.setTotal(pageInfo.getTotal());

        //将页面信息返回到控制器
        return result;
    }

    @Override
    public EUDataGridResult deleteByIds(String[] ids) {
        //执行删除操作
        boolean b = processCountMapper.deleteByIds(ids);
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
        List<ProcessCount> list = processCountMapper.selectByOrderId(orderid);
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
