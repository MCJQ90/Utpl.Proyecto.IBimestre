package com.jaramillolizaldez.contador.controladores;

import com.jaramillolizaldez.contador.dtos.SolicitudCreation;
import com.jaramillolizaldez.contador.dtos.SolicitudDto;
import com.jaramillolizaldez.contador.dtos.SolicitudDtoV2;
import com.jaramillolizaldez.contador.entidades.Solicitud;
import com.jaramillolizaldez.contador.servicios.EmailService;
import com.jaramillolizaldez.contador.servicios.SolicitudService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

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

    @PostMapping("/v1")
    @Operation(summary = "Crear nueva solicitud con todos los datos")
    @Tag(name = "Solicitud", description = "Encargado de manejar las solicitudes de declaración")
    public ResponseEntity<String> crearSolicitud(@RequestBody SolicitudDto solicitudDto) {
        // Crear y poblar entidad Solicitud desde el DTO
        Solicitud solicitud = new Solicitud();
        solicitud.setIdentificacion(solicitudDto.getIdentificacion());
        solicitud.setRazonSocial(solicitudDto.getRazonSocial());
        solicitud.setTelefono(solicitudDto.getTelefono());
        solicitud.setEmail(solicitudDto.getEmail());
        solicitud.setServicio(solicitudDto.getServicio());
        solicitud.setAñoFiscal(solicitudDto.getAñoFiscal());

        // Guardar la solicitud en la base de datos
        solicitudService.crearSolicitud(solicitudDto);

        // Enviar correo al cliente
        emailService.enviarCorreo(
                solicitudDto.getEmail(),
                "Nueva Solicitud Creada",
                "Se ha creado una nueva solicitud para el cliente: " + solicitud.getRazonSocial());

        // Retornar mensaje con status 201 CREATED
        String mensaje = "Solicitud creada con éxito: " + solicitud.getRazonSocial();
        return ResponseEntity.status(Response.SC_CREATED).body(mensaje);
    }

    @PostMapping("/v2")
    @Operation(summary = "Crear nueva solicitud con pocos datos")
    @Tag(name = "Solicitud", description = "Encargado de manejar las solicitudes de declaración")
    public ResponseEntity<SolicitudDtoV2> crearSolicitudV2(@RequestBody SolicitudCreation solicitudDtoV2) {
        Solicitud solicitud = new Solicitud();
        solicitud.setIdentificacion(solicitudDtoV2.getIdentificacion());
        solicitud.setRazonSocial(solicitudDtoV2.getRazonSocial());
        solicitud.setEmail(solicitudDtoV2.getEmail()); // Solo lo que tiene V2

        // Guardar la solicitud en la base de datos
        solicitudService.crearSolicitudV2(solicitudDtoV2);

        // Enviar correo al cliente
        emailService.enviarCorreo(
                solicitudDtoV2.getEmail(),
                "Nueva Solicitud Creada",
                "Se ha creado una nueva solicitud para el cliente: " + solicitud.getRazonSocial());

        SolicitudDtoV2 respuesta = new SolicitudDtoV2(
                solicitud.getIdentificacion(),
                solicitud.getRazonSocial());
        return ResponseEntity.status(Response.SC_CREATED).body(respuesta);
    }

    @GetMapping("/v1")
    @Operation(summary = "Obtener todas las solicitudes")
    @Tag(name = "Solicitudes")
    public List<SolicitudDto> obtenerSolicitudes() {
        return solicitudService.obtenerTodasLasSolicitudesDto();
        /*
         * new SolicitudDto("SOL-001", "Jorge Armando Jaramillo",
         * "Ingresando información"),
         * new SolicitudDto("SOL-002", "Roberth Ordoñez Vivanco", "Pendiente de pago"),
         * new SolicitudDto("SOL-003", "Joofre Honores Tapia", "Finalizada con éxito"));
         */
    }

    @GetMapping("/v2")
    @Operation(summary = "Obtener todas las solicitudes")
    @Tag(name = "Solicitudes")
    public List<SolicitudDtoV2> obtenerSolicitudesV2() {
        return solicitudService.obtenerTodasLasSolicitudesDtoV2();
        /*
         * new SolicitudDto("SOL-001", "Jorge Armando Jaramillo",
         * "Ingresando información"),
         * new SolicitudDto("SOL-002", "Roberth Ordoñez Vivanco", "Pendiente de pago"),
         * new SolicitudDto("SOL-003", "Joofre Honores Tapia", "Finalizada con éxito"));
         */
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