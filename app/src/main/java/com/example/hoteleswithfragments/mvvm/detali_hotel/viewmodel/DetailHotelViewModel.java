package com.example.hoteleswithfragments.mvvm.detali_hotel.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hoteleswithfragments.mvvm.detali_hotel.model.DetailHotelModel;
import com.example.hoteleswithfragments.mvvm.login.model.LoginModel;

public class DetailHotelViewModel extends ViewModel {
    private DetailHotelModel repository;
    private MutableLiveData<String> msg;

    public DetailHotelViewModel(){
        msg = new MutableLiveData<>();
        repository = DetailHotelModel.getInstance();
    }
    public void showMsg(){
        msg.setValue(repository.booking());
    }
    public LiveData<String> getMsg(){
        return msg;
    }
}
