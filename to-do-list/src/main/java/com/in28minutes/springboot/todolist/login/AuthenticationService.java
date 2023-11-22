package com.in28minutes.springboot.todolist.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password){

        boolean isValidUserName = username.equalsIgnoreCase("anand");
        boolean isValidPassword = password.equalsIgnoreCase("password");

        return isValidPassword && isValidUserName;
    }

}
