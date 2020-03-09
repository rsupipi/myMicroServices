package com.pipi.controller;

import com.pipi.bean.SomeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringContorller {

    @GetMapping("/filtering")
    public SomeBean retriveSomeBean() {
        return new SomeBean("C001", "Sama", "sama@123");
    }

    @GetMapping("/filteringList")
    public List<SomeBean> retriveSomeBeanList() {
        return Arrays.asList(
                new SomeBean("C001", "Sama", "sama@123"),
                new SomeBean("C002", "Mala", "mala@123"));
    }
}
