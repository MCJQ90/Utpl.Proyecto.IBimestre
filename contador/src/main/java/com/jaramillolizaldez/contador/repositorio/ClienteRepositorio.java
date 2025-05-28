package com.jaramillolizaldez.contador.repositorio;

import com.jaramillolizaldez.contador.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
}