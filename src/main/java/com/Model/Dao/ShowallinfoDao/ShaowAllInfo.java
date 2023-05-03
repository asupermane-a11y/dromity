package com.Model.Dao.ShowallinfoDao;

import org.apache.ibatis.annotations.Param;

public interface ShaowAllInfo {
    Integer getfloorinfo(@Param("floor") String floor);
}
