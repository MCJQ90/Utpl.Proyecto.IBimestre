package com.jaramillolizaldez.contador.dtos;

public class ClienteDto {
    private String identificacion;
    private String nombre;
    private String correo;

    public ClienteDto(String identificacion, String nombre, String correo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }
}