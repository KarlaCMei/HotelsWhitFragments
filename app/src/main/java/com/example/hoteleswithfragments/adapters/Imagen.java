package com.example.hoteleswithfragments.adapters;

import java.io.Serializable;

public class Imagen implements Serializable {

    public String titulo;
    public String url;

    public Imagen(String titulo, String url) {
        this.titulo = titulo;
        this.url = url;
    }
}
