package com.Model.Service.StudentService;

import com.Model.Dao.StudentDao.StudentDao;
import com.Model.Entities.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<user> toallStudent(String studentid, String name, Integer floor, Integer room, String professional) {
        return studentDao.allStudent(studentid,name,floor,room,professional);
    }

    @Override
    public int deletfloor(String studentid, String name) {
        return studentDao.deletfloor(studentid,name);
    }

    @Override
    public int deleteall(String studentid, String name) {
        return studentDao.deleteall(studentid,name);
    }

    @Override
    public int updatestudnet(String studentid, String college, String system, String profession, String classid, String email) {
        return studentDao.updatestudnet(studentid,college,system,profession,classid,email);
    }
}
