package com.sso.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    /*Test API for token*/
    @GetMapping(value = "/test")
    public String demoMessage() {
        return "Welcome to the Java World..!!";
    }

}
