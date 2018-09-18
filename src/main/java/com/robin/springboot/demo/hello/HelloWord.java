package com.robin.springboot.demo.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloWord {

    @GetMapping("/sy")
    public String sayHelloWord(){
        return "Springboot Hello";
    }
}
