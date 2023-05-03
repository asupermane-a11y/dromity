package com.Controller.ViewController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class view {

    @RequestMapping("/usercontroller.view")//用户综合管理
    public  String usercontroller(){
        return "1-1";
    }

    @RequestMapping("/datacontroller.view")//用户数据管理
    public  String datacontroller(){
        return "1-2";
    }

    @RequestMapping("/stduentinfo.view")//学生信息查询
    public  String stduentinfo(){
        return "2-1";
    }


    @RequestMapping("/signinfo.view") //学生信息登记
    public  String signinfo(){
        return "2-2";
    }
    @RequestMapping("/updatestudentinfo.view")//学生信息修改
    public  String updatestudentinfo(){
        return
                "2-3";
    }
    @RequestMapping("/staycontroller.view") //入住管理
    public  String  staycontroller(){
        return "3-1";
    }
    @RequestMapping("/hotelcontroller.view") //宿舍管理
    public  String hotelcontroller(){
        return "3-2";
    }
    @RequestMapping("/outcontroller.view") //退宿管理
    public  String outcontroller(){
        return "3-3";
    }

    @RequestMapping("/zhuxiao.view")//期末注销
    public String zhuxiao(){
        return "3-4";
    }
    @RequestMapping("/gethotelinfo.view")//寝室信息查询
    public String gethotelinfo(){
        return "4-1";
    }
    @RequestMapping("/getstinfo.view") //学生情况查询
    public String getstinfo(){
        return "4-2";
    }
    @RequestMapping("/laifang.view")//来访情况查询
    public String laifang(){
        return "4-3";
    }
    @RequestMapping("/shebei.view")//设备情况查询
    public String shebei(){
        return "4-4";
    }
    @RequestMapping("/dianfei.view")//电费情况查询
    public String dianfei(){
        return "4-5";
    }
    @RequestMapping("/laifangdengji.view")//来访登记
    public String laifangdengji(){
        return "5-1";
    }
    @RequestMapping("/jishudengji.view")//结束登记
    public String jishudengji(){
        return "5-2";
    }
    @RequestMapping("/chaungwei.view") //床位信息录用
    public String chaungwei(){
        return "6-1";
    }
    @RequestMapping("/shebeicontroller.view") //设备管理
    public String shebeicontroller(){
        return "6-2";
    }
    @RequestMapping("/sushepingbi.view") //宿舍评比
    public String sushepingbi(){
        return "6-3";
    }
    @RequestMapping("/dianfeicontroller.view") //电费管理
    public String dianfeicontroller(){
        return "6-4";
    }
    @RequestMapping("/count.view")//统计
    public String count(){
        //请求转发
        return "7-1";
    }
    @RequestMapping("/baobiao.view")//报表
    public String baobiao(){
        return "8-1";
    }
    @RequestMapping("/home.view")//主页
    public String home(){
        return "home";
    }

    @RequestMapping("/out")
    public String toout(HttpSession session){
        //清空session
        session.invalidate();
        //请求转发
        return "redirect:/hello.html";
    }

    @RequestMapping("/updateview")
    public String toupdatepassword(){
        return "updateview";
    }

}
