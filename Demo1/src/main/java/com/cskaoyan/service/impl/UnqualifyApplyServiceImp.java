package com.cskaoyan.service.impl;

import com.cskaoyan.utils.EUDataGridResult;
import com.cskaoyan.bean.vo.UnqualifyApplyVo;
import com.cskaoyan.bean.UnqualityApply;
import com.cskaoyan.mapper.UnqualityApplyMapper;
import com.cskaoyan.service.UnqualifyApplyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnqualifyApplyServiceImp implements UnqualifyApplyService {

    @Autowired
    UnqualityApplyMapper unqualityApplyMapper;

    @Override
    public int deleteByPrimaryKey(String id) {

        int i = unqualityApplyMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public EUDataGridResult insert(UnqualifyApplyVo record) {
        //插入之前先查询这个主键是否有数据
        UnqualityApply unqualityApply = unqualityApplyMapper.selectByPrimaryKey(record.getUnqualifyApplyId());
        int insert = -1;
        EUDataGridResult result = null;
        if(unqualityApply == null)
        {
            insert = unqualityApplyMapper.insert(record);
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
    public int insertSelective(UnqualifyApplyVo record) {
        int i = unqualityApplyMapper.insertSelective(record);
        return i;
    }

    @Override
    public EUDataGridResult selectByPrimaryKey(String Id) {

        EUDataGridResult result = new EUDataGridResult();

        UnqualityApply unqualityApply = unqualityApplyMapper.selectByPrimaryKey(Id);

        List<UnqualityApply> list = new ArrayList<>();

        if(unqualityApply != null)
        {
            list.add(unqualityApply);
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
    public EUDataGridResult updateByPrimaryKeySelective(UnqualifyApplyVo unqualifyApplyVo) {
        //创建一个result对象
        EUDataGridResult result = new EUDataGridResult();
        int ii = unqualityApplyMapper.updateByPrimaryKeySelective(unqualifyApplyVo);
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
    public int updateByPrimaryKey(UnqualifyApplyVo unqualifyApplyVo) {
        int i = unqualityApplyMapper.updateByPrimaryKey(unqualifyApplyVo);
        return i;
    }

    @Override
    public EUDataGridResult getItemList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page,rows);

        //分页对象
        EUDataGridResult result = new EUDataGridResult();

        List<UnqualifyApplyVo> list = unqualityApplyMapper.selectAll();


        //将list数据存入result对象
        result.setRows(list);

        //查询页面的数目
        PageInfo<UnqualifyApplyVo> pageInfo = new PageInfo<>(list);
        //将查询到的数目添加到result对象中
        result.setTotal(pageInfo.getTotal());

        //将页面信息返回到控制器
        return result;
    }

    @Override
    public EUDataGridResult deleteByIds(String[] ids) {
        //执行删除操作
        boolean b = unqualityApplyMapper.deleteByIds(ids);
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
        List<UnqualifyApplyVo> list = unqualityApplyMapper.selectByOrderId(orderid);
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

    @Override
    public EUDataGridResult selectByProductName(String productname) {

        EUDataGridResult result = new EUDataGridResult();
        List<UnqualifyApplyVo> list = unqualityApplyMapper.selectByProductName(productname);

        if(list.size() > 0)
        {
            result.setTotal(list.size());
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
