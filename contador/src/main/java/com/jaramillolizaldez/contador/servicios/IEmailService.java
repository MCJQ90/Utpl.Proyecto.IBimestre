package com.jaramillolizaldez.contador.servicios;

public interface IEmailService {
    public void enviarCorreo(
        String para, String asunto, String contenido);
}