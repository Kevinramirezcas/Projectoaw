package com.example.demo.service;

import com.example.demo.repository.AlumnoRepository;
import com.example.demo.resource.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository repository;

    public Alumno saveAlumno(Alumno alumno) {
        return repository.save(alumno);
    }

    public List<Alumno> getAlumnos() {
        return repository.getAllalumnos();
    }

    public Alumno getAlumnoById(Long id) {
        return repository.findById(id);
    }

    public boolean deleteAlumno(Long id) {
        return repository.delete(id);
    }

    public Alumno updateAlumno(Alumno alumno) {
        return repository.update(alumno);
    }
}
