package com.example.hoteleswithfragments.mvvm.lista_hoteles.model;

import com.example.hoteleswithfragments.data.Hotel;
import com.example.hoteleswithfragments.data.HotelList;

import java.util.ArrayList;

public class ListaHotelesModel {
    public static ArrayList<Hotel> getListHotels(){
        return HotelList.getHotels();
    }
}
