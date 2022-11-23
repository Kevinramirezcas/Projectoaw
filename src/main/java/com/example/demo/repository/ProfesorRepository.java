package com.example.demo.repository;

import com.example.demo.resource.Profesor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProfesorRepository {
    private List<Profesor> profesores= new ArrayList<Profesor>();

    public List<Profesor> getAllprofesores(){
        return profesores;
    }

    public Profesor findById(long id){
        for (int i= 0; i <profesores.size(); i++){
            if (profesores.get(i).getId().equals(id)){
                return profesores.get(i);
            }
        }
        return null;
    }
    public Profesor save(Profesor profesor){
        profesores.add(profesor);
        return profesor;
    }
    public Profesor update(Profesor profesor){
        for (int i= 0; i <profesores.size(); i++) {
            if (profesores.get(i).getId().equals(profesor.getId())) {
                profesores.set(i, profesor);
                return profesor;
            }
        }
        return null;
    }
    public boolean delete(Long id) {
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getId().equals(id)) {
                profesores.remove(i);
                return true;
            }
        }
        return false;
    }
}
