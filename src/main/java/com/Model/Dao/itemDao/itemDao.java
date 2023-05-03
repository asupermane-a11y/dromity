package com.Model.Dao.itemDao;

import com.Model.Entities.item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface itemDao {
     int insertitem(item it);
     List<item>  getallitems(@Param("floor") String floor, @Param("itemid") String itemid, @Param("shunxu") String shunxu, @Param("status") Integer status);
     int toupdate(@Param("uuid") String uuid,@Param("images") String images);
}
