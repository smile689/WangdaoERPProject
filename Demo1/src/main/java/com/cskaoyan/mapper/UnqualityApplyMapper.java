package com.cskaoyan.mapper;

import com.cskaoyan.bean.Vo.UnqualifyApplyVo;
import com.cskaoyan.bean.ProcessMeasure;
import com.cskaoyan.bean.UnqualityApply;

import java.util.List;

public interface UnqualityApplyMapper {
    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(UnqualityApply record);

    int insertSelective(UnqualityApply record);

    UnqualifyApplyVo selectByPrimaryKey(String unqualifyApplyId);

    int updateByPrimaryKeySelective(UnqualityApply record);

    int updateByPrimaryKey(UnqualityApply record);

    //查询所有的产品计量
    List<UnqualifyApplyVo> selectAll();

    //多选删除
    boolean deleteByIds(String [] ids);

    //根据id搜索
    List<UnqualifyApplyVo>  selectByOrderId(String orderid);

    //根据产品名搜索
    List<UnqualifyApplyVo> selectByProductName(String productname);
}