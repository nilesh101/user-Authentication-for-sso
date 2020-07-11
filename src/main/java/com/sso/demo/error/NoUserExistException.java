package com.sso.demo.error;

public class NoUserExistException extends RuntimeException{

    String message ;

    public NoUserExistException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }



}
