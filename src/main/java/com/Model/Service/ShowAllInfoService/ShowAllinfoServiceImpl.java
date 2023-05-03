package com.Model.Service.ShowAllInfoService;


import com.Model.Dao.ShowallinfoDao.ShaowAllInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShowAllinfoServiceImpl implements ShowAllinfoService {

    @Autowired
    private ShaowAllInfo showAllinfoDao;
    @Override
    public Integer getfloorinfo(String floor) {
        return showAllinfoDao.getfloorinfo(floor);
    }
}
