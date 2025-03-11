package com.example.Nutrit.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
@Data
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Campos de IDs para paciente y médico
    @Column(name = "paciente_id", nullable = false)
    private Integer pacienteId;

    @Column(name = "medico_id", nullable = false)
    private Integer medicoId;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "motivo")
    private String motivo;
}
