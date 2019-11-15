package com.example.proyectocine;

import java.io.Serializable;

public class Dto implements Serializable {

    String nombre, apellido, correo, contra1, contra2;
    int identificacion;


    public Dto() {
    }

    public Dto(String nombre, String apellido, String correo, String contra1, String contra2, int identificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contra1 = contra1;
        this.contra2 = contra2;
        this.identificacion = identificacion;
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

    public String getContra2() {
        return contra2;
    }

    public void setContra2(String contra2) {
        this.contra2 = contra2;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }


}
