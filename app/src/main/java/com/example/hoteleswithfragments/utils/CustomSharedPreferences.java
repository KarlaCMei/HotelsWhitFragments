package com.example.hoteleswithfragments.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.hoteleswithfragments.R;
import com.example.hoteleswithfragments.utils.App;

public class CustomSharedPreferences {
    public static SharedPreferences customShared;

    public static SharedPreferences getInstance(){
        if (customShared == null) {
            customShared = App.getInstance().getSharedPreferences(
                    App.getInstance().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        }
        return customShared;
    }

    public static void setSharedBoolean(String key, Boolean value){
        SharedPreferences sharedPref = getInstance();
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static Boolean getSharedBoolean(String key){
        SharedPreferences sharedPref = getInstance();
        return sharedPref.getBoolean(key, false);
    }
}
