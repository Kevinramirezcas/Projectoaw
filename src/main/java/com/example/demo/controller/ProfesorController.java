package com.example.demo.controller;
import com.example.demo.resource.Profesor;
import com.example.demo.resource.CustomResponse;
import com.example.demo.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/profesores")

public class ProfesorController {
    @Autowired
    private ProfesorService service;

    @PostMapping
    public ResponseEntity<?> addProfesor(@RequestBody Profesor profesor) {

        if(profesor.getNombres() == null || profesor.getId() == null || profesor.getApellidos() == null
             || profesor.getNumeroEmpleado() == null){
            return new ResponseEntity<>(new CustomResponse("Todos los campos son requeridos"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(profesor.getNombres().isBlank() || profesor.getApellidos().isBlank() || profesor.getNumeroEmpleado().isBlank()){
            return new ResponseEntity<>(new CustomResponse("Nombres, Apellidos y numero de empleado no pueden ser vacios"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Profesor al = service.saveProfesor(profesor);
        if(al != null){
            return new ResponseEntity<>(al, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(new CustomResponse("Error interno"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity findAllProfesor() {
        List<Profesor> prof = service.getProfesores();
        if(prof.size() != 0){
            return new ResponseEntity<>(prof, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new CustomResponse("No se encontraron profesores"), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("{id}")
    public ResponseEntity findProfesorById(@PathVariable Long id) {
        Profesor al = service.getProfesorById(id);
        if(al != null){
            return new ResponseEntity<>(al, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new CustomResponse("No se encontro profesor"), HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping
    public ResponseEntity updateProfesor(@RequestBody Profesor profesor) {
        if(profesor.getNombres() == null || profesor.getId() == null || profesor.getApellidos() == null
              ||profesor.getHorasClase() < 0  || profesor.getNumeroEmpleado() == null){
            return new ResponseEntity<>(new CustomResponse("Todos los campos son requeridos"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(profesor.getNombres().isBlank() || profesor.getApellidos().isBlank() || profesor.getNumeroEmpleado().isBlank()){
            return new ResponseEntity<>(new CustomResponse("Nombres, Apellidos y Numero de empleado no pueden ser vacios"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Profesor profesor1 = service.updateProfesor(profesor);
        if(profesor1 != null){
            return new ResponseEntity<>(profesor1, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new CustomResponse("No se encontro Profesor"), HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteProfesor(@PathVariable Long id) {
        boolean ans = service.deleteProfesor(id);
        if(ans){
            return new ResponseEntity<>( HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new CustomResponse("No se encontro Profesor"), HttpStatus.NOT_FOUND);
        }
    }



}
