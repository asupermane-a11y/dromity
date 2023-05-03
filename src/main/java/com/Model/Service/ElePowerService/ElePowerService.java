package com.Model.Service.ElePowerService;

import com.Model.Entities.elepower;


import java.util.List;

public interface ElePowerService {
    int insertelepower(elepower elepower);
    elepower getyue(String floor, String room);
    List<elepower> getelepower( String floor, String room,String yue,String shunxu);
}
