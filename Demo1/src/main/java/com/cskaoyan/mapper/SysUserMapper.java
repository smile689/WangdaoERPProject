package com.cskaoyan.mapper;

import com.cskaoyan.bean.SysUser;
import com.cskaoyan.bean.vo.UserRoleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {

    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKey(SysUser record);

    SysUser selectByUsername(String username);

    UserRoleVO selectActiveUserByUsername(String username);

    List<UserRoleVO> selectAllUserWithRole(@Param("userRoleVO") UserRoleVO userRoleVO);

    String queryPermissionsByUsername(String username);

    int deleteBatchByKeys(String[] ids);
}