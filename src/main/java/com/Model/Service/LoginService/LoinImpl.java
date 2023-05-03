package com.Model.Service.LoginService;

import com.Model.Dao.LoginDao.LoginDao;
import com.Model.Dao.UserDao.UserDao;
import com.Model.Entities.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class LoinImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public user toselect(String email) {
        return loginDao.selectuser(email);
    }
}
