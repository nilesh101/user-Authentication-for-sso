package com.sso.demo.dao;

import com.sso.demo.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserRepo {

    private List<User> userList = new ArrayList<>();

    public UserRepo() {
        init();
    }

    private void init() {
        User user1 = new User("admin" ,"admin");
        userList.add(user1);
    }

    /*Do check does given user is valid or not by checking in repo*/
    public boolean isUserExist(String username, String password) {
        return userList.stream().filter(user -> user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)).count() > 0;
    }
}
