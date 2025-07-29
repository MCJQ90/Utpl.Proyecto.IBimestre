package com.jaramillolizaldez.contador.servicios;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaramillolizaldez.contador.dtos.SolicitudDto;
import com.jaramillolizaldez.contador.dtos.SolicitudDtoV2;
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


    public List<SolicitudDto> obtenerTodasLasSolicitudesDto() {
        return solicitudRepository.findAll().stream()
                .map(this::convertirASolicitudDto)
                .collect(Collectors.toList());
    }

    private SolicitudDto convertirASolicitudDto(Solicitud solicitud) {
    SolicitudDto dto = new SolicitudDto();
    dto.setIdentificacion(solicitud.getIdentificacion());
    dto.setRazonSocial(solicitud.getRazonSocial());
    dto.setEmail(solicitud.getEmail());
    dto.setTelefono(solicitud.getTelefono());
    dto.setServicio(solicitud.getServicio());
    dto.setAñoFiscal(solicitud.getAñoFiscal());
    return dto;
}


    public List<SolicitudDtoV2> obtenerTodasLasSolicitudesDtoV2() {
        List<Solicitud> solicitudes = solicitudRepository.findAll();
    return solicitudes.stream()
            .map(s -> new SolicitudDtoV2(s.getIdentificacion(), s.getRazonSocial()))
            .collect(Collectors.toList());
}

    


      
}
