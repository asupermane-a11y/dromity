package com.Model.Service.EnvironmentService;

import com.Model.Dao.EnvironmentDao.EnvironmentDao;
import com.Model.Entities.environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class EnvironmentServiceImpl implements EnvironmentService {


    @Autowired
    private EnvironmentDao environmentDao;
    @Override
    public int toinsertenvironment(environment environment) {
        return environmentDao.insertenvironment(environment);
    }

    @Override
    public List<environment> getallenvironments(String floor, String room) {
        return environmentDao.getallenvironments(floor,room);
    }
}
