package com.sso.demo.configuration;


import com.sso.demo.dao.UserRepo;
import com.sso.demo.error.NoUserExistException;
import com.sso.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationLogic {

    @Autowired
    UserRepo userRepo;

    @Autowired
    TokenUtil tokenUtil;

    public String validateUserAndGenerateToken(User userRequest) {
        if(userRepo.isUserExist(userRequest.getUsername(), userRequest.getPassword())) {
            return tokenUtil.generateToken(userRequest);
        }
        throw new NoUserExistException("No user exist with given credentials");
    }

}
