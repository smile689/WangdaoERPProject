package com.cskaoyan.mapper;

import com.cskaoyan.bean.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(SysRole record);

    SysRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> selectAll();

    List<SysRole> selectRolesByPage(@Param("sysRole") SysRole sysRole);

    int deleteBatchByKeys(String[] split);
}