package com.Model.Service.LoginService;

import com.Model.Entities.user;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface LoginService {
    user toselect(String email);
}
