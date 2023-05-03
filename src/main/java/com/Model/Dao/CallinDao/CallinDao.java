package com.Model.Dao.CallinDao;

import com.Model.Entities.callin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CallinDao {
    int insertcallin(callin callin);
    List<callin> callinlist(@Param("callinfromname")String callinfromname,@Param("callofname")String callofname,@Param("callindate")String callindate,@Param("shunxu")String shunxu);
}
