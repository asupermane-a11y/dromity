package com.Model.Service.StudentService;

import com.Model.Entities.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    List<user> toallStudent(String studentid,String name, Integer floor,Integer room, String professional);
    int  deletfloor(String studentid,String name);
    int deleteall(String studentid,String name);
    int updatestudnet(String studentid,String college,String system,String profession,String classid,String email);
}
