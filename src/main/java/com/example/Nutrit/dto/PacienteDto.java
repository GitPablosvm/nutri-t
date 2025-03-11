package com.example.Nutrit.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private String obraSocial;
    private Double altura;
    private Double pesoInicial;
    private Double pesoObjetivo;
}
