package com.example.Nutrit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "seguimientos")
@Data
@NoArgsConstructor
public class Seguimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seguimiento_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "peso_actual")
    private Double pesoActual;

    @Column(name = "observaciones", length = 255)
    private String observaciones;
}


