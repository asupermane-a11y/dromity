package com.Model.Service.EnvironmentService;

import com.Model.Entities.environment;

import java.util.List;

public interface EnvironmentService {
    int toinsertenvironment(environment environment);
    List<environment> getallenvironments(String floor, String room);
}
