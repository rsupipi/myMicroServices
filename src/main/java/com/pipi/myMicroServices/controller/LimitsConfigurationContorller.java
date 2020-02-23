package com.pipi.myMicroServices.controller;

import com.pipi.bean.LimitConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationContorller {

    @GetMapping("/limits")
    public LimitConfiguration retriveLimitsFromConfigurations(){
        return new LimitConfiguration(100, 1);
    }

}
