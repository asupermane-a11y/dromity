package com.Controller.UserController;


import com.Model.Entities.user;
import com.Model.Service.LoginService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class loginController {
     user user1;


    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public String tologin(String useremail, String password, HttpSession session){
        user1=loginService.toselect(useremail);
        if(user1==null){
            return "0";
        }else {
            if(!user1.getPassword().equals(password)){
                return "1";
            }else {
                session.setAttribute("info",user1);
                return "2";
            }
        }
    }
}
