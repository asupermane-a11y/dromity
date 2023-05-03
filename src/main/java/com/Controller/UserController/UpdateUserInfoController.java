package com.Controller.UserController;


import com.Model.Entities.user;
import com.Model.Service.UpdateUserinfoService.UpdateUserinfoService;
import com.Model.Util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

@Controller
public class UpdateUserInfoController {

      @Autowired
      private UpdateUserinfoService updateuserinfoservice;
      user user2;

    @RequestMapping("/updateuserinfo")
    @ResponseBody
    public  String  updateuserinfo(String phone, String email, String home_adress, HttpSession session){
        user2= (user) session.getAttribute("info");
        Integer id=user2.getId();


                if(updateuserinfoservice.toupdate(email,phone,home_adress,id)==1){
                    return "1";
                }else {
                    return "0";
                }
        }




    @RequestMapping("/getmessage2")
    @ResponseBody
    public user getmessage2(HttpSession session,String message){
        user2= (user) session.getAttribute("info");
        String myemail=user2.getEmail();
        try {
            MessageUtil.getMessage(myemail,message,"你的验证码为:");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return user2;
    }
}
