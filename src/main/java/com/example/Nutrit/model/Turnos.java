package com.example.Nutrit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "turnos")
@Data
@NoArgsConstructor
public class Turnos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int turnosId;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Pacientes paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medicos medico;

    private LocalDateTime fechaTurno;

    @Enumerated(EnumType.STRING)
    private EstadoTurno estado;
}
