package com.example.hoteleswithfragments.data;

import com.example.hoteleswithfragments.adapters.Imagen;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private String descripcion;
    /**Cambiar la calificacion por un numerico*/
    private String calificacion;
    private String ubicacion;
    private String precioConDescuento;
    private String precioSinDescuento;
    private String urlImg;

    private ArrayList<Imagen> images;

    public Hotel() {
    }

   /* public Hotel(String calificacion, String nombre, String descripcion, String ubicacion, String precioConDescuento,String urlImg, String precioSinDescuento,) {
        this.calificacion = calificacion;
        this.name = nombre;
        this.descripcion= descripcion;
        this.ubicacion = ubicacion;
        this.precioConDescuento = precioConDescuento;
        this.precioSinDescuento = precioSinDescuento;
        this.urlImg = urlImg;
        //this.images =images;
    }*/
    public Hotel(String calificacion, String nombre, String descripcion, String ubicacion, String precioConDescuento, String precioSinDescuento, ArrayList<Imagen>imagens, String urlImg) {
        this.calificacion = calificacion;
        this.name = nombre;
        this.descripcion= descripcion;
        this.ubicacion = ubicacion;
        this.precioConDescuento = precioConDescuento;
        this.precioSinDescuento = precioSinDescuento;
        this.images = imagens;
        this.urlImg = urlImg;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPrecioConDescuento() {
        return precioConDescuento;
    }

    public void setPrecioConDescuento(String precioConDescuento) {
        this.precioConDescuento = precioConDescuento;
    }

    public String getPrecioSinDescuento() {
        return precioSinDescuento;
    }

    public void setPrecioSinDescuento(String precioSinDescuento) {
        this.precioSinDescuento = precioSinDescuento;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public ArrayList<Imagen> getImages() {
        return images;
    }

    public void setImages(ArrayList<Imagen> images) {
        this.images = images;
    }
}
