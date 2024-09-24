package com.example.Nutrit.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Medicos")
    public class Medicos {

    @Id
    @OneToOne
    @JoinColumn(name = "medico_id")
    private Usuarios usuario;  // Relación con Usuarios

    @Enumerated(EnumType.STRING)
    @Column(name = "especialidad")
    private Especialidad especialidad;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "horario_disponible")
    private String horarioDisponible;

    @Column(name = "descripcion")
    private String descripcion;

    // Getters y Setters

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHorarioDisponible() {
        return horarioDisponible;
    }

    public void setHorarioDisponible(String horarioDisponible) {
        this.horarioDisponible = horarioDisponible;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Constructores

    public Medicos() {
    }

    public Medicos(Usuarios usuario, Especialidad especialidad, String matricula, String telefono, String horarioDisponible, String descripcion) {
        this.usuario = usuario;
        this.especialidad = especialidad;
        this.matricula = matricula;
        this.telefono = telefono;
        this.horarioDisponible = horarioDisponible;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Medicos{" +
                "usuario=" + usuario +
                ", especialidad=" + especialidad +
                ", matricula='" + matricula + '\'' +
                ", telefono='" + telefono + '\'' +
                ", horarioDisponible='" + horarioDisponible + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}