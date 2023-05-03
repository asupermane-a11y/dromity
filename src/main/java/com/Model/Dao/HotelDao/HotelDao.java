package com.Model.Dao.HotelDao;

import com.Model.Entities.hotel;
import com.Model.Entities.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotelDao {
  List<hotel> hotellist(@Param("classid")String classid,@Param("room") String room,@Param("sex") Integer sex);
  user getalluser(@Param("floor")String floor,@Param("room")String room );
  user getoneuser(@Param("studentid")String studnetid);
  int updateinfo(@Param("floor1")String floor,@Param("room1")String room,@Param("bed1")Integer bed,@Param("studentid1")String studentid);
}
