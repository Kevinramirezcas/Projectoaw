package com.example.demo.repository;

import com.example.demo.resource.Alumno;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlumnoRepository {
    private List<Alumno> alumnos = new ArrayList<Alumno>();

    public List<Alumno> getAllalumnos(){
        return alumnos;
    }

    public Alumno findById(long id){
        for (int i= 0; i <alumnos.size(); i++){
            if (alumnos.get(i).getId().equals(id)){
                return alumnos.get(i);
            }
        }
        return null;
    }
    public Alumno save(Alumno alumno){
        alumnos.add(alumno);
        return alumno;
    }
    public Alumno update(Alumno alumno){
        for (int i= 0; i <alumnos.size(); i++) {
            if (alumnos.get(i).getId().equals(alumno.getId())) {
                 alumnos.set(i, alumno);
                 return alumno;
            }
        }
        return null;
    }
    public boolean delete(Long id) {
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getId().equals(id)) {
                alumnos.remove(i);
                return true;
            }
        }
        return false;
    }


}
