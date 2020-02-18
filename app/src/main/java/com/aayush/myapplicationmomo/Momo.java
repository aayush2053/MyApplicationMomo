package com.aayush.myapplicationmomo;

import android.media.Image;

public class Momo {
    private String nombre,descripcion;
    private Image image;

    Momo(String nombre){
        this.nombre=nombre;
        this.descripcion=descripcion;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return  nombre;
    }
}
