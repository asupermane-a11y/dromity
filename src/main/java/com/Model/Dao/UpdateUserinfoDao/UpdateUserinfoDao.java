package com.Model.Dao.UpdateUserinfoDao;

import org.apache.ibatis.annotations.Param;

public interface UpdateUserinfoDao {
    int updatepassword(@Param("email") String email, @Param("phone") String phoen,@Param("home_adress") String home_adress, @Param("id")Integer id);
}
