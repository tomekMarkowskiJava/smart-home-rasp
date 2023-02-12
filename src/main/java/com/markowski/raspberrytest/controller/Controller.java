package com.markowski.raspberrytest.controller;

import com.markowski.raspberrytest.model.dto.StateDto;
import com.markowski.raspberrytest.service.StateService;
import com.markowski.raspberrytest.service.StateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final StateService stateService;

    @Autowired
    public Controller(StateServiceImpl stateServiceImpl) {
        this.stateService = stateServiceImpl;
    }

    @GetMapping("/test")
    public StateDto test(){
        return stateService.getTestState();
    }

    @GetMapping("/state")
    public StateDto getState(){
        return stateService.getState();
    }
}

