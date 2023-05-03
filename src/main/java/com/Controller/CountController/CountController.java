package com.Controller.CountController;


import com.Model.Entities.count;
import com.Model.Service.CountService.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.math.BigDecimal;
@Controller
public class CountController {

    @Autowired
    private CountService countService;
    Integer alluser;
    Integer man_student;
    Integer woman_student;
    Integer suguan;
    Integer fudaoyuan;



    @RequestMapping("/getcountinfo")
    @ResponseBody
    public count getcountinfo(){
        alluser=countService.getcountinfo(null,null);//获取所有用户人数
        //获取男学生人数
        man_student=countService.getcountinfo(1,1);
        //获取女生人数
        woman_student=countService.getcountinfo(1,0);
        //获取宿管人数
        suguan=countService.getcountinfo(2,null);
        //获取辅导员人数
        fudaoyuan=countService.getcountinfo(3,null);



       //计算男学生所占比例
                BigDecimal percentage = new BigDecimal((double)man_student / alluser * 100);
                percentage = percentage.setScale(2,BigDecimal.ROUND_HALF_UP);
        //计算女学生所占比例
        BigDecimal percentage1 = new BigDecimal((double)woman_student/ alluser * 100);
        percentage1 = percentage1.setScale( 2,BigDecimal.ROUND_HALF_UP);
        //计算宿管所占比例
        BigDecimal percentage2 = new BigDecimal((double)suguan / alluser * 100);
        percentage2 = percentage2.setScale( 2,BigDecimal.ROUND_HALF_UP);
        //计算辅导员所占比例
        BigDecimal percentage3 = new BigDecimal((double)fudaoyuan / alluser * 100);
        percentage3 = percentage3.setScale( 2,BigDecimal.ROUND_HALF_UP);


       count count=new count(percentage.toString()+"%",percentage1.toString()+"%",percentage2.toString()+"%",percentage3.toString()+"%");

        return count;

    }
}
