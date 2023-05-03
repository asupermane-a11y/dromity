package com.Controller.HotelController;


import com.Model.Entities.hotel;
import com.Model.Entities.user;
import com.Model.Service.HotelService.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    List<hotel> hotels;
    user u1;
    Integer newsex;
    user u2;
   user  userbed;
    List<Integer> alllist;


    @RequestMapping("/gethotel")
    @ResponseBody
    public List<hotel> gethotel(String classid, String room, String sex, HttpSession session) {
        u1 = (user) session.getAttribute("info");
        Integer capacity = u1.getCapacity();
        if (capacity == 1) {
            return null;
        } else {
            classid = classid.equals("") ? null : classid;
            room = room.equals("") ? null : room;
            if (sex.equals("全部")) {
                newsex = null;
            } else if (sex.equals("男")) {
                newsex = 1;
            } else {
                newsex = 0;
            }
            hotels = hotelService.hotellist(classid, room, newsex);
            return hotels;

        }

    }

    @RequestMapping("/togethotel")
    @ResponseBody
    public List<hotel> gethotelinfo(String classid, String sex, HttpSession session) {
        u1 = (user) session.getAttribute("info");
        Integer capacity = u1.getCapacity();
        if (capacity != 2) {
            return null;
        } else {
            if (sex.equals("男")) {
                newsex = 1;
            } else {
                newsex = 0;
            }

            hotels = hotelService.hotellist(classid, null, newsex);

            return hotels;
        }
    }


    @RequestMapping("/ruzhu")
    @ResponseBody
    public String ruzhu(String studentid, String floor, String room, HttpSession session) {
        Integer bed=0;
        int count = 0;
        u1 = (user) session.getAttribute("info");
        Integer capacity = u1.getCapacity();
        if (capacity != 2) {
            return "0";
        } else {
            //判断是否已经入住过了
            u2 = hotelService.getoneuser(studentid);
            if(u2==null){
                return "1";//没有该学生
            }else{//有该学生
                if (u2.getFloor()!=null|| u2.getRoom() != null || u2.getBed() != null) {
                    return "2";
                } else {
                    userbed= hotelService.getalluser(floor, room);
                    if(userbed==null){
                        bed=1;
                    }else {
                        if(userbed.getBed()==6){
                            return "3";
                        }else {
                            bed=userbed.getBed()+1;
                        }
                    }
                    System.out.println(floor);
                    System.out.println(room);
                    System.out.println(bed);
                    System.out.println(studentid);

                }
                }
            }

        if(hotelService.updateinfo(floor,room,bed,studentid)==1){
            return "4";
        }else {
            return "5";
        }
        }
        
}
