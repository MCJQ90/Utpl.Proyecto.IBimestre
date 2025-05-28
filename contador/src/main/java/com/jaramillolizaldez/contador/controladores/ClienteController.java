package com.jaramillolizaldez.contador.controladores;

import com.jaramillolizaldez.contador.dtos.ClienteDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @GetMapping
    public List<ClienteDto> obtenerClientes() {
        return Arrays.asList(
            new ClienteDto("1723456789", "Pedro Pérez", "pedro@gmail.com"),
            new ClienteDto("0923456789", "María García", "maria@hotmail.com")
        );
    }
}