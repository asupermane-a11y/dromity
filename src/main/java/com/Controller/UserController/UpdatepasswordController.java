package com.Controller.UserController;

import com.Model.Service.UserService.UserService;
import com.Model.Util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;

@Controller
public class UpdatepasswordController {
    @Autowired
    private UserService userService;

    //获取验证码
    @RequestMapping("/getmessage")
    @ResponseBody
    public String getmessage(String message, String email) {
        System.out.println(message);
        System.out.println(email);
        try {
            MessageUtil.getMessage(email, message,"您的验证码为:");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "1";
    }


    //修改密码
    @RequestMapping("/updatepassword")
    @ResponseBody
    public String toupdatepassword(String email, String password) {
        if( userService.updatepassword(email,password)==1){
            return "1";
        }

        return "0";
    }
}
