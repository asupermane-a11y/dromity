package com.Model.Service.CallinService;

import com.Model.Entities.callin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class CallinServiceImpl implements CallinService {

    @Autowired
    private com.Model.Dao.CallinDao.CallinDao CallinDao;
    @Override
    public int toinsertcallin(callin callin) {
        return CallinDao.insertcallin(callin);
    }

    @Override
    public List<callin> callinlist(String callinfromname, String callofname, String callindate, String shunxu) {
        return CallinDao.callinlist(callinfromname,callofname,callindate,shunxu);
    }
}
