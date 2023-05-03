package com.Controller.EnvironmentController;


import com.Model.Entities.environment;
import com.Model.Entities.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EnvironmentController {

    @Autowired
    private com.Model.Service.EnvironmentService.EnvironmentService environmentService;

    user us;
    List<environment> environments;


    @RequestMapping("insertenvironment")
    @ResponseBody
    public String  insertenvironment(environment environment) {
        if (environmentService.toinsertenvironment(environment) == 1) {
            return "1";
        }
        return "0";
    }




    @RequestMapping("/getenvironment")
    @ResponseBody
    public List<environment> getenvironment(String classid, String floor, String room, HttpSession session) {
      us=(user)session.getAttribute("info");
       Integer capacity=us.getCapacity();
       if(capacity!=2){
           return null;
         }else {

           room=room.equals("")?null:room;
           environments=environmentService.getallenvironments(floor,room);

          return environments;

       }

    }
}
