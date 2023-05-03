package com.Model.Dao.StudentDao;

import com.Model.Entities.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    List<user> allStudent(@Param("studentid")String studentid, @Param("name")String name, @Param("floor")Integer floor, @Param("room")Integer room, @Param("professional")String professional);
    int  deletfloor(@Param("studentid")String studentid, @Param("name")String name);
    int deleteall(@Param("studentid1") String studentid,@Param("name1") String name);
    int updatestudnet(@Param("studentid2") String studentid,@Param("college2") String college,@Param("system2") String system,@Param("profession2") String profession,@Param("classid2") String classid,@Param("email2") String email);
}
