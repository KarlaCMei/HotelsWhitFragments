package com.example.hoteleswithfragments.mvvm.login.model;

import android.util.Log;

public class LoginModel {
    private static LoginModel instance;
    public static LoginModel getInstance() {
        if (instance == null) instance = new LoginModel();
        return instance;
    }

    public Boolean login(String email, String password){
        return email.equals("karla@gmail.com")  && password.equals("1234567");
    }

}
