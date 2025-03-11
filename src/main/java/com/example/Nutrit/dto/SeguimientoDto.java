package com.example.Nutrit.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class SeguimientoDto {
    private Integer id;
    private Integer pacienteId;
    private LocalDate fecha;
    private Double pesoActual;
    private String observaciones;
}
