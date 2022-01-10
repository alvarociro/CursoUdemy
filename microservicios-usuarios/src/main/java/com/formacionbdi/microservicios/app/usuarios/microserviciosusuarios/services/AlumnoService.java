package com.formacionbdi.microservicios.app.usuarios.microserviciosusuarios.services;

import java.util.Optional;

import com.formacionbdi.microservicios.app.usuarios.microserviciosusuarios.models.entity.Alumno;

public interface AlumnoService {
    public Iterable<Alumno> finAll();

    public Optional<Alumno> finById(Long id);

    public Alumno save(Alumno alumno);

    public void deleteById(Long id);
    
}
