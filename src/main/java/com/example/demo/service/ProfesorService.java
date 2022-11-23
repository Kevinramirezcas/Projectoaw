package com.example.demo.service;
import com.example.demo.repository.ProfesorRepository;
import com.example.demo.resource.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository repository;

    public Profesor saveProfesor(Profesor profesor) {
        return repository.save(profesor);
    }

    public List<Profesor> getProfesores() {
        return repository.getAllprofesores();
    }

    public Profesor getProfesorById(Long id) {
        return repository.findById(id);
    }

    public boolean deleteProfesor(Long id) {
        return repository.delete(id);
    }

    public Profesor updateProfesor(Profesor profesor) {
        return repository.update(profesor);
    }
}

