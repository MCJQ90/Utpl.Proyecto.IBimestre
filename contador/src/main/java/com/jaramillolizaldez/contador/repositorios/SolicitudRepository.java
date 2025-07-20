package com.jaramillolizaldez.contador.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaramillolizaldez.contador.entidades.Solicitud;



@Repository
public interface SolicitudRepository extends  JpaRepository<Solicitud, Integer>{
    public List<Solicitud> findByIdentificacion(String identificacion);    
}
