package com.cskaoyan.mapper;

import com.cskaoyan.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    //@Select("select * from user_inf where username = #{username} and password = #{password}")
    User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
