package com.Model.Service.CountService;

import com.Model.Dao.CountDao.CountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CountServiceImpl implements CountService {

    @Autowired
    private CountDao countDao;
    @Override
    public Integer getcountinfo(Integer capacity, Integer sex) {
        return countDao.getcountinfo(capacity,sex);
    }
}
