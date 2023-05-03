package com.Controller.ElePowerController;


import com.Model.Entities.elepower;
import com.Model.Entities.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ElePowerController {
    @Autowired
    private com.Model.Service.ElePowerService.ElePowerService elePowerService;
    java.sql.Date sqldate = null;
    elepower elepower1;
    user user1;
    List<elepower> elepowerList;
    // 设置日期格式
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @RequestMapping("/insertelepower")
    @ResponseBody
    public String insertelepower(elepower elepower, HttpSession session) {
        elepower.setStatus(1);
        user1 = (user) session.getAttribute("info");
        Integer capacity = user1.getCapacity();
        if (capacity != 2) {
            return "0";
        }
        elepower1 = elePowerService.getyue(elepower.getFloor(), elepower.getRoom());
        if (elepower1 == null) {
            elepower.setYue(elepower.getAddmoney());
        } else {
            elepower.setYue(elepower1.getYue() + elepower.getAddmoney());

        }
        //获取当天的日期并转为java.sql.Date
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        elepower.setThedate(sqlDate);
        System.out.println(elepower);
        if (elePowerService.insertelepower(elepower) == 1) {
            return "1";
        }
        return "2";
    }


    @RequestMapping("/reduceelepower")
    @ResponseBody
    public String reducemoney(elepower elepower, HttpSession session) {

        user1 = (user) session.getAttribute("info");
        Integer capacity = user1.getCapacity();
        System.out.println(capacity);
        if (capacity != 2) {
            return "0";
        } else {
            elepower1 = elePowerService.getyue(elepower.getFloor(), elepower.getRoom());
            if (elepower1.getYue() < elepower.getAddmoney()) {
                return "1";
            }
            elepower.setStatus(0);
            System.out.println(elepower);
            elepower.setYue(elepower1.getYue() - elepower.getAddmoney());
            System.out.println(elepower);
            if (elePowerService.insertelepower(elepower) == 1) {
                return "2";
            }
        }
        return "3";
    }


    @RequestMapping("/selectelepower")
    @ResponseBody
    public List<elepower> selectelepower(String floor, String room, String yue, String shunxu, HttpSession session)  {
        user1 = (user) session.getAttribute("info");
        Integer capacity = user1.getCapacity(); //获取用户权限
        if (capacity == 3) {
            elepowerList = null;
        } else {

            //将"123"转为float类
            floor = (floor.equals("全部") ? null : floor);
            room = (room.equals("") ? null : room);
            yue = (yue.equals("") ? null : yue);
            shunxu = (shunxu.equals("顺序") ? null : shunxu);

            elepowerList = elePowerService.getelepower(floor, room, yue, shunxu);

           for (elepower elepower1 : elepowerList) {

               System.out.println(elepower1);
            }

        }
        return elepowerList;
    }
}
