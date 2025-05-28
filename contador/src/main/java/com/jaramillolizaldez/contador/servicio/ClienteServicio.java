package com.jaramillolizaldez.contador.servicio;

import com.jaramillolizaldez.contador.dtos.ClienteDto;
import com.jaramillolizaldez.contador.modelo.Cliente;
import com.jaramillolizaldez.contador.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public Cliente guardar(ClienteDto dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setIdentificacion(dto.getIdentificacion());
        cliente.setCorreo(dto.getCorreo());
        return clienteRepositorio.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepositorio.findAll();
    }
}