package com.Model.Dao.ElePowerDao;

import com.Model.Entities.elepower;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ElePowerDao {
    int insertelepower(elepower elepower);
     elepower getyue(@Param("floor") String floor, @Param("room") String room);
    int insertreduce(elepower elepower);
    List<elepower> getelepower(@Param("floor1") String floor, @Param("room1") String room,@Param("yue1")String yue,@Param("shunxu1")String shunxu);
}
