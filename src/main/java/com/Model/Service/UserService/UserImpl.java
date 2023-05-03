package  com.Model.Service.UserService;

import  com.Model.Dao.UserDao.UserDao;
import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;
import  org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public  class  UserImpl  implements UserService {
    @Autowired
    private UserDao  userDao;


    @Override
    public int updatepassword(String email, String password) {
        return userDao.toupdatepassword(email,password);
    }
}