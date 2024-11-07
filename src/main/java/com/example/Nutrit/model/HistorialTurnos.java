package com.example.Nutrit.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;



@Entity
@Table(name = "historial_turnos")
    public class HistorialTurnos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historial_id")
    private int historialId;

    @ManyToOne
    @JoinColumn(name = "turnos_id", nullable = false)
    private Turnos turno; // Relación con Turnos

    @Enumerated(EnumType.STRING)
    @Column(name = "cambio_estado", nullable = false)
    private EstadoTurno cambioEstado;

    @Column(name = "fecha_cambio", nullable = false)
    private LocalDateTime fechaCambio = LocalDateTime.now();

    // Getters y Setters

    public int getHistorialId() {
        return historialId;
    }

    public void setHistorialId(int historialId) {
        this.historialId = historialId;
    }

    public Turnos getTurno() {
        return turno;
    }

    public void setTurno(Turnos turno) {
        this.turno = turno;
    }

    public EstadoTurno getCambioEstado() {
        return cambioEstado;
    }

    public void setCambioEstado(EstadoTurno cambioEstado) {
        this.cambioEstado = cambioEstado;
    }

    public LocalDateTime getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(LocalDateTime fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    // Constructores

    public HistorialTurnos() {
    }

    public HistorialTurnos(int historialId, Turnos turno, EstadoTurno cambioEstado, LocalDateTime fechaCambio) {
        this.historialId = historialId;
        this.turno = turno;
        this.cambioEstado = cambioEstado;
        this.fechaCambio = fechaCambio;
    }

    @Override
    public String toString() {
        return "HistorialTurnos{" +
                "historialId=" + historialId +
                ", turno=" + turno +
                ", cambioEstado=" + cambioEstado +
                ", fechaCambio=" + fechaCambio +
                '}';
    }
}
