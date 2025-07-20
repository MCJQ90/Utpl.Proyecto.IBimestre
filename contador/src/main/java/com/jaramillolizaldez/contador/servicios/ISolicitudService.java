package com.jaramillolizaldez.contador.servicios;

import java.util.List;

import com.jaramillolizaldez.contador.entidades.Solicitud;

public interface ISolicitudService {
    public List<Solicitud> BuscarPorIdentificacion(String identificacion);
    
    
}
