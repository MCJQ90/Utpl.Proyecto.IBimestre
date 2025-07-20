package com.jaramillolizaldez.contador.controladores;

import com.jaramillolizaldez.contador.dtos.SolicitudDto;
import com.jaramillolizaldez.contador.entidades.Solicitud;
import com.jaramillolizaldez.contador.servicios.SolicitudService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;

    @GetMapping
    public List<SolicitudDto> obtenerSolicitudes() {
        return Arrays.asList(
                new SolicitudDto("SOL-001", "Jorge Armando Jaramillo", "Ingresando información"),
                new SolicitudDto("SOL-002", "Roberth Ordoñez Vivanco", "Pendiente de pago"),
                new SolicitudDto("SOL-003", "Joofre Honores Tapia", "Finalizada con éxito"));
    }

    // Obtener una solicitud por identificacion
    @GetMapping("/busqueda/{identificacion}")
    public List<Solicitud> getListaSolicitudByIdentificacion(@PathVariable String identificacion) {
        var solicitudes = solicitudService.BuscarPorIdentificacion(identificacion);
        if (solicitudes.isEmpty()) {
            return null; // O lanzar una excepción si no se encuentra
        }
        System.out.println("Obteniendo solicitud para la identificación: " + identificacion);
        // Retornar la primera solicitud encontrada
        return solicitudes;
    }
}