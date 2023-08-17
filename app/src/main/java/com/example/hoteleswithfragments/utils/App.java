package com.example.hoteleswithfragments.utils;

import android.app.Application;

public class App extends Application {

    public static App instance;

    public App (){
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static App getInstance(){
        if(instance == null )instance = new App();
        return instance;
    }
}
