package com.jaramillolizaldez.contador.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor

public class SolicitudCreation {
    private String identificacion;
    private String razonSocial;
    private String email;
    private String telefono;
    private String servicio;
    private Integer añoFiscal;
    private String observaciones;
    }
    

