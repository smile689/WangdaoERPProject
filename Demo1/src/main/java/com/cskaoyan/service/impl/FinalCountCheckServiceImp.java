package com.cskaoyan.service.impl;

import com.cskaoyan.utils.EUDataGridResult;
import com.cskaoyan.bean.FinalCount;
import com.cskaoyan.bean.vo.FinalCountVo;
import com.cskaoyan.mapper.FinalCountMapper;
import com.cskaoyan.service.FinalCountCheckService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalCountCheckServiceImp implements FinalCountCheckService {

    //注入mapper接口
    @Autowired
    FinalCountMapper finalCountMapper;


    //得到分页数据
    @Override
    public EUDataGridResult getItemList(int page, int rows) {

        //分页处理
        PageHelper.startPage(page,rows);

        //分页对象
        EUDataGridResult result = new EUDataGridResult();

        List<FinalCountVo> list = finalCountMapper.selectAll();

        //将list数据存入result对象
        result.setRows(list);

        //查询页面的数目
        PageInfo<FinalCountVo> pageInfo = new PageInfo<>(list);
        //将查询到的数目添加到result对象中
        result.setTotal(pageInfo.getTotal());

        //将页面信息返回到控制器
        return result;
    }

    @Override
    public int deleteByPrimaryKey(String fCountCheckId) {

        int i = finalCountMapper.deleteByPrimaryKey(fCountCheckId);
        return i;
    }

    @Override
    public int insert(FinalCount record) {
        int insert = finalCountMapper.insert(record);
        return insert;
    }

    @Override
    public int insertSelective(FinalCount record) {
        int i = finalCountMapper.insertSelective(record);
        return i;
    }

    @Override
    public FinalCount selectByPrimaryKey(String fCountCheckId) {
        FinalCount finalCount = finalCountMapper.selectByPrimaryKey(fCountCheckId);

        return finalCount;
    }

    @Override
    public int updateByPrimaryKeySelective(FinalCount record) {

        int i = finalCountMapper.updateByPrimaryKeySelective(record);

        return i;
    }

    @Override
    public int updateByPrimaryKey(FinalCount record) {
        int i = finalCountMapper.updateByPrimaryKey(record);
        return i;
    }

    @Override
    public List<FinalCountVo> selectAll() {
        List<FinalCountVo> list =  finalCountMapper.selectAll();
        return list;

    }

    @Override
    public EUDataGridResult selectByOrderId(String orderid) {
        //声明一个返回结果对象
        EUDataGridResult result = new EUDataGridResult();
        List<FinalCountVo> list = finalCountMapper.selectByOrderId(orderid);
        if(list.size() > 0)
        {
            result.setMsg("OK");
            result.setStatus(200);
            result.setTotal(list.size());
            result.setRows(list);
        }
        else
        {
            result.setStatus(500);
            result.setMsg("NO");
        }
        return result;
    }

    @Override
    public EUDataGridResult deleteByIds(String[] ids) {

        //执行删除操作
        boolean b = finalCountMapper.deleteByIds(ids);
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


}
