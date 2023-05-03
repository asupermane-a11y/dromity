package com.Model.Service.CallinService;

import com.Model.Entities.callin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CallinService {
    int toinsertcallin(callin callin);
    List<callin> callinlist(String callinfromname,String callofname,String callindate,String shunxu);
}
