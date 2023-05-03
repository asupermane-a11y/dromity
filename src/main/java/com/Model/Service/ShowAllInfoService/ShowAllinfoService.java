package com.Model.Service.ShowAllInfoService;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface ShowAllinfoService {
    Integer getfloorinfo(String floor);
}
