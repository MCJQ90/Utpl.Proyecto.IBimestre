package com.jaramillolizaldez.contador.entidades;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "solicitudes")
@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor

public class Solicitud implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipoIdentificacion;
    private String identificacion;
    private String razonSocial;
    private String email;
    private String telefono;
    private String servicio;  
    private Integer añoFiscal;
    private String fechaSolicitud;
    private String estado;
    private String observaciones;

    
}
