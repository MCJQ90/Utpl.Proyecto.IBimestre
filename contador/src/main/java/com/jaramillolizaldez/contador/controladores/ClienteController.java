package com.jaramillolizaldez.contador.controladores;

import com.jaramillolizaldez.contador.dtos.ClienteDto;
import com.jaramillolizaldez.contador.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteServicio clienteServicio;

    // GET - Obtener todos los clientes
    @GetMapping
    public List<ClienteDto> listarClientes() {
        return clienteServicio.obtenerTodosLosClientes();
    }

    // POST - Crear un nuevo cliente
    @PostMapping
    public ClienteDto crearCliente(@RequestBody ClienteDto clienteDto) {
        return clienteServicio.crearCliente(clienteDto);
    }
}
