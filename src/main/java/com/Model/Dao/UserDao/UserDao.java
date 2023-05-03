package com.Model.Dao.UserDao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

public interface UserDao {
    int  toupdatepassword(@Param("email") String email,@Param("password") String password);
}
