package com.pipi.controller;

import com.pipi.bean.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class HelloWordController {

    @GetMapping("hello")
    public String helloWorld(){
        return "hello pipi";
    }

    @GetMapping("hello-bean")
    public Message helloBean(){
        return new Message("hi pipi");
    }

    @GetMapping("hello/user/{name}")
    public Message helloPathVariable(@PathVariable String name){
        return new Message(String.format("Hello %s", name));
    }

}
