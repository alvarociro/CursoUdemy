package com.formacionbdi.microservicios.app.usuarios.microserviciosusuarios.models.repository;

import com.formacionbdi.microservicios.app.usuarios.microserviciosusuarios.models.entity.Alumno;

import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno,Long> {
    
}
