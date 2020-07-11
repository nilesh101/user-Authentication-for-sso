package com.sso.demo.controller;

import com.sso.demo.configuration.AuthenticationLogic;
import com.sso.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    AuthenticationLogic authLogic;

    /*For valid use it returns token with expiry of 5 mins.*/
    @PostMapping(value = "/auth", produces = {"application/json"})
    public String authenticateUser(@RequestBody User userRequest) {
        return authLogic.validateUserAndGenerateToken(userRequest);
    }

}
