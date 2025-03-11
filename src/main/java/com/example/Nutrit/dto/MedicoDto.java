package com.example.Nutrit.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String matricula;
}
