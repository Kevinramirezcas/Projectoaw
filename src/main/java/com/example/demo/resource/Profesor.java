package com.example.demo.resource;

import lombok.Data;

@Data
public class Profesor {
    private Long id;
    private String nombres;
    private String apellidos;
    private String numeroempleado;
    private int horasClase;
}
