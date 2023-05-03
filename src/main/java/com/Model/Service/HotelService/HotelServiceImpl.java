package com.Model.Service.HotelService;

import com.Model.Dao.HotelDao.HotelDao;
import com.Model.Entities.hotel;
import com.Model.Entities.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDao hotelDao;

    @Override
    public List<hotel> hotellist(String classid, String room, Integer sex) {
        return hotelDao.hotellist(classid,room,sex);
    }

    @Override
    public user getalluser(String floor, String room) {
        return hotelDao.getalluser(floor,room);
    }

    @Override
    public user getoneuser(String studentid) {
        return hotelDao.getoneuser(studentid);
    }

    @Override
    public int updateinfo(String floor, String room, Integer bed,String studentid) {
        return hotelDao.updateinfo(floor,room,bed,studentid);
    }


}
