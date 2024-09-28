package com.example.Nutrit.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historial_pacientes")
    public class HistorialPaciente {

    @Id
    @Column(name = "historial_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int historialId;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Pacientes paciente; // Relación con Pacientes

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    // Getters y Setters

    public int getHistorialId() {
        return historialId;
    }

    public void setHistorialId(int historialId) {
        this.historialId = historialId;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    // Constructores

    public HistorialPaciente() {
    }

    public HistorialPaciente(int historialId, Pacientes paciente, LocalDateTime fechaRegistro, String observaciones) {
        this.historialId = historialId;
        this.paciente = paciente;
        this.fechaRegistro = fechaRegistro;
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "HistorialPaciente{" +
                "historialId=" + historialId +
                ", paciente=" + paciente +
                ", fechaRegistro=" + fechaRegistro +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}