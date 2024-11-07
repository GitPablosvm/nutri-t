package com.example.Nutrit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "HistorialPaciente")
@Data
@NoArgsConstructor
public class HistorialPaciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Pacientes paciente;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "notas", columnDefinition = "TEXT")
    private String notas;
}
