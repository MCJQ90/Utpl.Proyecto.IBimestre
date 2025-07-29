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
        Solicitud solicitud = new Solicitud();
        solicitud.setIdentificacion(solicitudDto.getIdentificacion());
        solicitud.setRazonSocial(solicitudDto.getRazonSocial());
        solicitud.setEmail(solicitudDto.getEmail());
        solicitud.setTelefono(solicitudDto.getTelefono());
        solicitud.setServicio(solicitudDto.getServicio());
        solicitud.setAñoFiscal(solicitudDto.getAñoFiscal());
        solicitudRepository.save(solicitud);
        return solicitudDto;
    }

   
}
