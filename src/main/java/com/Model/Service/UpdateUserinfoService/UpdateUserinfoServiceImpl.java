package com.Model.Service.UpdateUserinfoService;


import com.Model.Dao.UpdateUserinfoDao.UpdateUserinfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UpdateUserinfoServiceImpl implements UpdateUserinfoService {

    @Autowired
    private UpdateUserinfoDao updateuserinfodao;


    @Override
    public int toupdate(String email, String phone, String home_adress, Integer id) {
        return updateuserinfodao.updatepassword(email,phone,home_adress,id);
    }
}
