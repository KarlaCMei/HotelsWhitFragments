package com.example.hoteleswithfragments.mvvm.login.viewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hoteleswithfragments.mvvm.login.model.LoginModel;
public class LoginViewModel extends ViewModel{
    private LoginModel repository;
    private MutableLiveData<Boolean> isLogin;
    public LoginViewModel(){
        isLogin = new MutableLiveData<>();
        repository = LoginModel.getInstance();
    }
    public void isLogin(String email, String password){
        isLogin.setValue(repository.login(email,password));
    }

    public LiveData<Boolean> getUser(){
        return isLogin;
    }
}