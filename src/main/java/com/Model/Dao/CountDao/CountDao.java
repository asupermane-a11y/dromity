package com.Model.Dao.CountDao;

import org.apache.ibatis.annotations.Param;

public interface CountDao {
    Integer getcountinfo(@Param("capacity") Integer capacity, @Param("sex") Integer sex);
}
