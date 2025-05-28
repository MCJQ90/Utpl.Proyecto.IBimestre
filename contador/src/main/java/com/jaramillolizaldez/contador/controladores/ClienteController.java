package com.jaramillolizaldez.contador.controladores;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @GetMapping("/Hola")
    public String hola() {
        return "Hola, mundo!";
    }
    
}
