package com.formacionbdi.microservicios.app.usuarios.controllers;

import java.util.Optional;

import com.formacionbdi.microservicios.app.usuarios.microserviciosusuarios.models.entity.Alumno;
import com.formacionbdi.microservicios.app.usuarios.microserviciosusuarios.services.AlumnoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AlumnoController {
    
    @Autowired
    private AlumnoService service;

    @GetMapping
    public ResponseEntity<?> Listar(){
        return ResponseEntity.ok().body(service.finAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id){
        Optional<Alumno> o = service.finById(id);
        if(o.isEmpty()){
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(o.get());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno alumno) {
        Alumno alumnodb = service.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnodb);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id){
        Optional<Alumno> o = service.finById(id);
        if(o.isEmpty()){
           return ResponseEntity.notFound().build();
        }

        Alumno alumnodb = o.get();
        alumnodb.setNombre(alumno.getNombre());
        alumnodb.setApellido(alumno.getApellido());
        alumnodb.setEmail(alumno.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnodb));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
