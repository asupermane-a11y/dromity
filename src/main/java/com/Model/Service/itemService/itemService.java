package com.Model.Service.itemService;

import com.Model.Entities.item;
import com.Model.Entities.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface itemService {
    int  toinsert(item it);
    List<item> getallitems(String floor, String itemid, String shunxu, Integer status);
    int toupdate( String uuid,String images);
}
