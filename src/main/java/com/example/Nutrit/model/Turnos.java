package com.example.Nutrit.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Turnos")
    public class Turnos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "turnos_id")
    private int turnosId;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Pacientes paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medicos medico;

    @Column(name = "fecha_turno")
    private LocalDateTime fechaTurno;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoTurno estado = EstadoTurno.PENDIENTE;

    // Getters y Setters

    public int getTurnosId() {
        return turnosId;
    }

    public void setTurnosId(int turnosId) {
        this.turnosId = turnosId;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public Medicos getMedico() {
        return medico;
    }

    public void setMedico(Medicos medico) {
        this.medico = medico;
    }

    public LocalDateTime getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(LocalDateTime fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public EstadoTurno getEstado() {
        return estado;
    }

    public void setEstado(EstadoTurno estado) {
        this.estado = estado;
    }

    // Constructores

    public Turnos() {
    }

    public Turnos(Pacientes paciente, int turnosId, Medicos medico, LocalDateTime fechaTurno, EstadoTurno estado) {
        this.paciente = paciente;
        this.turnosId = turnosId;
        this.medico = medico;
        this.fechaTurno = fechaTurno;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Turnos{" +
                "turnosId=" + turnosId +
                ", paciente=" + paciente +
                ", medico=" + medico +
                ", fechaTurno=" + fechaTurno +
                ", estado=" + estado +
                '}';
    }
}