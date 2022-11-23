package com.example.demo.controller;

import com.example.demo.resource.Alumno;
import com.example.demo.resource.CustomResponse;
import com.example.demo.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @PostMapping
    public ResponseEntity<?> addAlumno(@RequestBody Alumno alumno) {

        if(alumno.getNombres() == null || alumno.getId() == null || alumno.getApellidos() == null
                || alumno.getPromedio() == null || alumno.getMatricula() == null){
            return new ResponseEntity<>(new CustomResponse("Todos los campos son requeridos"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(alumno.getNombres().isBlank() || alumno.getApellidos().isBlank() || alumno.getMatricula().isBlank()){
            return new ResponseEntity<>(new CustomResponse("Nombres, Apellidos y Matricula no pueden ser vacios"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Alumno al = service.saveAlumno(alumno);
        if(al != null){
            return new ResponseEntity<>(al, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(new CustomResponse("Error interno"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity findAllAlumno() {
        List<Alumno> alumns = service.getAlumnos();
        if(alumns.size() != 0){
            return new ResponseEntity<>(alumns, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new CustomResponse("No se encontraron alumnos"), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("{id}")
    public ResponseEntity findAlumnoById(@PathVariable Long id) {
        Alumno al = service.getAlumnoById(id);
        if(al != null){
            return new ResponseEntity<>(al, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new CustomResponse("No se encontro alumno"), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity updateAlumno(@RequestBody Alumno alumno) {
        if(alumno.getNombres() == null || alumno.getId() == null || alumno.getApellidos() == null
                || alumno.getPromedio() == null || alumno.getMatricula() == null){
            return new ResponseEntity<>(new CustomResponse("Todos los campos son requeridos"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(alumno.getNombres().isBlank() || alumno.getApellidos().isBlank() || alumno.getMatricula().isBlank()){
            return new ResponseEntity<>(new CustomResponse("Nombres, Apellidos y Matricula no pueden ser vacios"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Alumno alumno1 = service.updateAlumno(alumno);
        if(alumno1 != null){
            return new ResponseEntity<>(alumno1, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new CustomResponse("No se encontro alumno"), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteAlumno(@PathVariable Long id) {
        boolean ans = service.deleteAlumno(id);
        if(ans){
            return new ResponseEntity<>( HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new CustomResponse("No se encontro alumno"), HttpStatus.NOT_FOUND);
        }
    }

}
