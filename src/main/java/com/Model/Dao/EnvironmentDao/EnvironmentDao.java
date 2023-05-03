package com.Model.Dao.EnvironmentDao;

import com.Model.Entities.environment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnvironmentDao {
    int insertenvironment(environment environment);
    List<environment> getallenvironments(@Param("floor") String floor, @Param("room") String room);
}
