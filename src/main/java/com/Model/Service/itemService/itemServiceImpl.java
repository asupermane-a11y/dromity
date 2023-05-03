package com.Model.Service.itemService;


import com.Model.Entities.item;
import com.Model.Entities.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class itemServiceImpl implements itemService {

    @Autowired
    private com.Model.Dao.itemDao.itemDao itemDao;

    @Override
    public int toinsert(item it) {
        return itemDao.insertitem(it);
    }

    @Override
    public List<item> getallitems(String floor, String itemid, String shunxu, Integer status) {
        return itemDao.getallitems(floor,itemid,shunxu,status);
    }

    @Override
    public int toupdate(String uuid,String images) {
        return itemDao.toupdate(uuid,images);
    }


}
