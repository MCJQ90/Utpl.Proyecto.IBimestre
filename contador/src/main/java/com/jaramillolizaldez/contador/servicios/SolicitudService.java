package com.jaramillolizaldez.contador.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaramillolizaldez.contador.dtos.SolicitudDto;
import com.jaramillolizaldez.contador.entidades.Solicitud;
import com.jaramillolizaldez.contador.repositorios.SolicitudRepository;

@Service
public class SolicitudService implements ISolicitudService {
    @Autowired
    private SolicitudRepository solicitudRepository;

    
    @Override
    public List<Solicitud> BuscarPorIdentificacion(String identificacion) {
        return solicitudRepository.findByIdentificacion(identificacion);    
    }


    public SolicitudDto crearSolicitud(SolicitudDto solicitudDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearSolicitud'");
    }

   
}
