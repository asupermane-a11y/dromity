package com.Model.Service.HotelService;

import com.Model.Entities.hotel;
import com.Model.Entities.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotelService {
    List<hotel> hotellist(String classid, String room, Integer sex);
    user getalluser(String floor,String room );
    user getoneuser(String studentid);
    int updateinfo(String floor,String room,Integer bed,String studentid);
}
