package com.Controller.CallinController;


import com.Model.Dao.CallinDao.CallinDao;
import com.Model.Entities.callin;
import com.Model.Entities.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CallinController {

    @Autowired
    private com.Model.Service.CallinService.CallinService CallinService;
    user use1;
    String result;
    List<callin>  callins;

    @RequestMapping("/insertcallin")
    @ResponseBody
    public String insertcallin(callin callin, HttpSession session) {
        use1 = (user) session.getAttribute("info");
        Integer capacity = use1.getCapacity();
        if (capacity != 2) {
            result = "0";
        } else {
            //获取当前的时间精确到分钟，并转为字符串
            String thetime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
            callin.setThetime(thetime);
            System.out.println(callin);
            if (CallinService.toinsertcallin(callin) == 1) {
                result = "1";
            } else {
                result = "3";
            }
        }
        return result;
    }




    @RequestMapping("/selectcallin")
    @ResponseBody
    public List<callin> doselectcallin(HttpSession session,String callinfromname,String callofname,String callindate,String shunxu) {
       use1= (user) session.getAttribute("info");
       Integer capacity=use1.getCapacity();
       if(capacity!=2){
           return null;
       }else {
           callinfromname = (callinfromname.equals("") ? null : "%" + callinfromname + "%");
           callofname = (callofname.equals("") ? null : "%" + callofname + "%");
           callindate = (callindate.equals("") ? null : "%" + callindate + "%");
           shunxu = (shunxu.equals("顺序") ? null : shunxu);
           callins = CallinService.callinlist(callinfromname, callofname, callindate, shunxu);
           //遍历callins
           callins.forEach(callin -> {
               System.out.println(callin.toString());
           });
       }

      return callins;
    }

}
