package com.example.hoteleswithfragments.mvvm.lista_hoteles.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hoteleswithfragments.data.Hotel;
import com.example.hoteleswithfragments.mvvm.lista_hoteles.model.ListaHotelesModel;

import java.util.ArrayList;

public class ListaHotelesViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Hotel>> result;



    public ListaHotelesViewModel() {
        this.result = new MutableLiveData<>();
    }

    public void getBooks(){
        result.setValue(ListaHotelesModel.getListHotels());
    }

    public LiveData<ArrayList<Hotel>> getResult(){
        return result;
    }
}
