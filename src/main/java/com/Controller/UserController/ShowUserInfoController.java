package com.Controller.UserController;


import com.Model.Entities.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class ShowUserInfoController {
    user user2;

    @RequestMapping("/showuserinfo")
    @ResponseBody
    public user showuserinfo(HttpSession session){
        user2 = (user) session.getAttribute("info");
        System.out.println(user2);
        return user2;
    }
}
