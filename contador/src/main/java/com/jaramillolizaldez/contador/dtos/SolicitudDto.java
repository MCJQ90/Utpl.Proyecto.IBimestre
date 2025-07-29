package com.jaramillolizaldez.contador.dtos;

public class SolicitudDto {
    private String id;
    private String cliente;
    private String estado;

    public SolicitudDto(String id, String cliente, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getEstado() {
        return estado;
    }

    public String getEmail() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
    }
}