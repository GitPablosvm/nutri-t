package com.example.Nutrit.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Medicos")
public class Medicos extends Usuarios {
    @Column(name = "matricula")
    private String matricula;

    @Enumerated(EnumType.STRING)
    @Column(name = "especialidad")
    private Especialidad especialidad;

    @Column(name = "telefono")
    private String telefono;


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Medicos{" +
                "matricula='" + matricula + '\'' +
                ", especialidad=" + especialidad +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public Medicos(String matricula, Especialidad especialidad, String telefono) {
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.telefono = telefono;
    }

    public Medicos(int usuario_id, String nombre, String apellido, String email, String contrasena, Rol rol, LocalDateTime fecha_creacion, LocalDateTime fecha_ultima_conexion, String matricula, Especialidad especialidad, String telefono) {
        super(usuario_id, nombre, apellido, email, contrasena, rol, fecha_creacion, fecha_ultima_conexion);
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.telefono = telefono;
    }
}