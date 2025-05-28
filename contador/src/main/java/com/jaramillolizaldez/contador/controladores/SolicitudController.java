package com.jaramillolizaldez.contador.controladores;

import com.jaramillolizaldez.contador.dtos.SolicitudDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    @GetMapping
    public List<SolicitudDto> obtenerSolicitudes() {
        return Arrays.asList(
            new SolicitudDto("SOL-001", "Jorge Armando Jaramillo", "Ingresando información"),
            new SolicitudDto("SOL-002", "Roberth Ordoñez Vivanco", "Pendiente de pago"),
            new SolicitudDto("SOL-003", "Joofre Honores Tapia", "Finalizada con éxito")
        );
    }
}