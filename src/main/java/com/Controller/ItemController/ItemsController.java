package com.Controller.ItemController;


import com.Model.Entities.item;
import com.Model.Entities.user;
import com.Model.Util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

@Controller
public class ItemsController {
    List<item> itemList;
    Integer newitemid;
    String  myimages;
    String uuid;


    @Autowired
    private com.Model.Service.itemService.itemService itemService;
    com.Model.Entities.user user1;

    @RequestMapping("/insertitem")
    @ResponseBody
    public String insertitem(item it, HttpSession session) {
        user1 = (user) session.getAttribute("info");
        //生成UUid前10位
         uuid = java.util.UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        it.setItemid(uuid);
        it.setCapacity(user1.getCapacity());
        it.setStatus(1);
        if (itemService.toinsert(it) == 1) {
            return "1";
        }
        return "0";

    }

    @RequestMapping("/selectitems")
    @ResponseBody
    public List<item> selectitems(String floor, String itemid, String shunxu, String status) {
        floor = floor.equals("全部") ? null : floor;
        itemid = itemid.equals("") ? null : itemid;
        shunxu = shunxu.equals("顺序") ? null : shunxu;
        if (status.equals("全部")) {
            newitemid = null;
        } else if (status.equals("待维修")) {
            newitemid = 1;
        } else if (status.equals("已维修")) {
            newitemid = 2;
        } else if (status.equals("已报废")) {
            newitemid = 3;
        }
        System.out.println(floor + itemid + shunxu + newitemid);
        itemList = itemService.getallitems(floor, itemid, shunxu, newitemid);
        for (item it : itemList) {
            System.out.println(it);
        }
        return itemList;
    }

    @RequestMapping(path = "/upload",method = RequestMethod.POST)
    public  String addUser(MultipartFile file,HttpServletRequest request) {
        myimages="";

        try {
            //ImageUtils为之前添加的工具类
            myimages = "http://localhost:8080/"+ImageUtils.upload(request, file);
            System.out.println(uuid);
            System.out.println(myimages);
            itemService.toupdate(uuid,myimages);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("----------------图片上传失败！");
        }

        return "6-2";
    }




}
