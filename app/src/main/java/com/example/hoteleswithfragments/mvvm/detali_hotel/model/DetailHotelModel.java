package com.example.hoteleswithfragments.mvvm.detali_hotel.model;

public class DetailHotelModel {
    private static DetailHotelModel instance;
    public static DetailHotelModel getInstance() {
        if (instance == null) instance = new DetailHotelModel();
        return instance;
    }


    public String booking(){
        //return "La reservase completo con exito";
        return "Fallo la reserva";
    }
}
