package com.Controller.StudentController;


import com.Model.Entities.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SelectStudentController {
    @Autowired
    private com.Model.Service.StudentService.StudentService studentService;
    List<user>  allstudents;
    user student;

    @RequestMapping("/selectstudent")
    @ResponseBody
    public List<user> selectStudent(String studentid, String studentname, String floor, String room, String profession, HttpSession session) {
        student = (user) session.getAttribute("info");
        Integer capacity = student.getCapacity();
        if (capacity == 1) {
            return null;
        }
            studentid = (studentid.equals("")) ? null : "%" + studentid + "%";
            studentname = (studentname.equals("")) ? null : "%" + studentname + "%";
            profession = (profession.equals("")) ? null : "%" + profession + "%";
            Integer newfloor = (floor.equals("")) ? null : Integer.parseInt(floor);
            Integer newroom = (room.equals("")) ? null : Integer.parseInt(room);
            allstudents = studentService.toallStudent(studentid, studentname, newfloor, newroom, profession);

        for (user student : allstudents) {
            System.out.println(student);
        }
        return allstudents;
    }

      @RequestMapping("/deletehotel")
      @ResponseBody
        public String deleteHotel(String studentid,String studentname,HttpSession session) {
          student= (user) session.getAttribute("info");
            Integer capacity=student.getCapacity();
            if(capacity!=2){
                return "0";
            }else {
                if(studentService.deletfloor(studentid,studentname)==1){
                    return "1";
                }
            }
            return "2";
      }

      @RequestMapping("/deletealll")
      @ResponseBody
     public  String  todelete(String studentid,String studentname,HttpSession session){
                student= (user) session.getAttribute("info");
                Integer capacity=student.getCapacity();
                if(capacity!=2) {
                    return "0";
                }else {
                    if(studentService.deleteall(studentid,studentname)==1){
                        return "1";
                    }else {
                        return "2";
                    }
                }
      }



      @RequestMapping("/updatestudent")
      @ResponseBody
    public  String toupdate(String studentid,String college,String system,String profession,String classid,String email,HttpSession session){
            student= (user) session.getAttribute("info");
            Integer capacity=student.getCapacity();
            if(capacity!=2){
                return "0";
            }else {

            college=college.equals("")?null:college;
            system=system.equals("")?null:system;
            profession=profession.equals("")?null:profession;
            classid=classid.equals("")?null:classid;
            email=email.equals("")?null:email;
            if(studentService.updatestudnet(studentid,college,system,profession,classid,email)==1){
                return "1";
                }
                return "2";

      }
      }
}
