package com.example.demo.resource;

import lombok.Data;

@Data
public class Alumno
{
    private Long id;
    private String nombres;
    private String apellidos;
    private String matricula;
    private Double promedio;

}
