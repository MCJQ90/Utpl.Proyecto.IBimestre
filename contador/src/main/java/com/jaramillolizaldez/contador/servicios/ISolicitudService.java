package com.jaramillolizaldez.contador.servicios;

import java.util.List;

import com.jaramillolizaldez.contador.dtos.SolicitudDto;
import com.jaramillolizaldez.contador.dtos.SolicitudDtoV2;
import com.jaramillolizaldez.contador.entidades.Solicitud;

public interface ISolicitudService {
    public List<Solicitud> BuscarPorIdentificacion(String identificacion);
    public SolicitudDto crearSolicitud(SolicitudDto solicitudDto);
    public SolicitudDtoV2 crearSolicitudV2(SolicitudDtoV2 solicitudDtoV2);
    public List<SolicitudDto> obtenerTodasLasSolicitudesDto();
    public List<SolicitudDtoV2> obtenerTodasLasSolicitudesDtoV2();
    
    
    
}
