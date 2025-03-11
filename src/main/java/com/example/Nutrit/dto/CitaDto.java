package com.example.Nutrit.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CitaDto {
    private Integer id;
    private Integer pacienteId;
    private Integer medicoId;
    private LocalDateTime fechaHora;
    private String motivo;
}
