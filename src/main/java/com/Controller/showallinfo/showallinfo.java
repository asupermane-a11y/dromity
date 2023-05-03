package com.Controller.showallinfo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class showallinfo {
    List<Integer>   floorinfolist= new ArrayList<>();
    Integer floorcount;

    @Autowired
    private com.Model.Service.ShowAllInfoService.ShowAllinfoService showAllinfoService;

    @RequestMapping("/showallinfo")
    @ResponseBody
    public List<Integer> showallinfo(){
        for (int i = 1; i < 17; i++) {
            floorcount = showAllinfoService.getfloorinfo(String.valueOf(i));
            floorinfolist.add(floorcount);
        }

        return floorinfolist;
    }
}
