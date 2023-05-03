package com.Model.Dao.LoginDao;

import com.Model.Entities.user;
import org.apache.ibatis.annotations.Param;

public interface LoginDao {
    user selectuser(@Param("email") String email);
}
