package com.jaramillolizaldez.contador.controladores;

import com.jaramillolizaldez.contador.dtos.SolicitudDto;
import com.jaramillolizaldez.contador.entidades.Solicitud;
import com.jaramillolizaldez.contador.servicios.EmailService;
import com.jaramillolizaldez.contador.servicios.SolicitudService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.experimental.var;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private EmailService emailService;

    @Operation(summary = "Crear una nueva solicitud")
    @PostMapping("/crear_solicitud")
    public ResponseEntity<String> crearSolicitud(@RequestBody SolicitudDto SolicitudDto) {
        SolicitudDto solicitud = solicitudService.crearSolicitud(SolicitudDto);
        emailService.enviarCorreo(SolicitudDto.getEmail(), "Nueva Solicitud Creada",
                "Se ha creado una nueva solicitud para el cliente: " + solicitud.getRazonSocial());
        return ResponseEntity.status(Response.SC_CREATED)
                .body("Solicitud creada con éxito: " + solicitud.getRazonSocial());
    }

    @GetMapping
    @Operation(summary = "Obtener todas las solicitudes")
    @Tag(name = "Solicitudes")
    public List<SolicitudDto> obtenerSolicitudes() {
        return solicitudService.obtenerTodasLasSolicitudesDto(); 
                /*new SolicitudDto("SOL-001", "Jorge Armando Jaramillo", "Ingresando información"),
                new SolicitudDto("SOL-002", "Roberth Ordoñez Vivanco", "Pendiente de pago"),
                new SolicitudDto("SOL-003", "Joofre Honores Tapia", "Finalizada con éxito"));*/
    }

    

    // Obtener una solicitud por identificacion
    @Operation(summary = "Buscar solicitud por identificación")
    @GetMapping("/busqueda/{identificacion}")
    public List<Solicitud> getListaSolicitudByIdentificacion(@PathVariable String identificacion) {
        List<Solicitud> solicitudes = solicitudService.BuscarPorIdentificacion(identificacion);
        if (solicitudes.isEmpty()) {
            return null; // O lanzar una excepción si no se encuentra
        }
        System.out.println("Obteniendo solicitud para la identificación: " + identificacion);
        // Retornar la primera solicitud encontrada
        return solicitudes;
    }
}