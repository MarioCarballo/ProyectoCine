package com.example.proyectocine;

import java.io.Serializable;

public class Dto implements Serializable {

    String nombre, apellido, correo, contra1;
    int identificacion;


    public Dto(String nombre, String apellido, String correo, String contra1, int identificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contra1 = contra1;
        this.identificacion=identificacion;

    }



    public Dto() {
    }


    public String getNombre() {
        return nombre;
    }




    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra1() {
        return contra1;
    }

    public void setContra1(String contra1) {
        this.contra1 = contra1;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }




}
