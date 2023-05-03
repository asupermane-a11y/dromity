package com.Model.Service.ElePowerService;

import com.Model.Dao.ElePowerDao.ElePowerDao;
import com.Model.Entities.elepower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ElePowerServiceImpl implements ElePowerService {

    @Autowired
    private ElePowerDao elePowerDao;

    @Override
    public int insertelepower(elepower elepower) {
        return elePowerDao.insertelepower(elepower);
    }

    @Override
    public elepower getyue(String floor, String room) {

        return elePowerDao.getyue(floor,room);
    }

    @Override
    public List<elepower> getelepower(String floor, String room,String yue, String shunxu) {
        return elePowerDao.getelepower(floor,room,yue,shunxu);
    }
}
