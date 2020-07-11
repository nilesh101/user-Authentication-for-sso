package com.sso.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @JsonProperty(value = "username")
    private String username;
    @JsonProperty(value = "password")
    private String password;

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if(obj instanceof User && this.getUsername().equals(((User) obj).getUsername()))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return (int) this.getUsername().hashCode();
    }
}
