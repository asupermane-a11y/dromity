package com.Controller.UserController;


import com.Model.Util.MessageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;

@Controller
public class SendBug {

    @RequestMapping("/sendbug")
    @ResponseBody
    public String getbug(String bug){
        System.out.println(bug);
        try {
            MessageUtil.getMessage("2815721758@qq.com",bug," 用户反馈的问题为:");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "1";
    }
}
