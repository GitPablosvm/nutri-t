package com.example.Nutrit.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pacientes")
public class Pacientes extends Usuarios {
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "historico_medico")
    private String historicoMedico;




    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    @Override
    public String toString() {
        return "Pacientes{" +
                "fechaNacimiento=" + fechaNacimiento +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", historicoMedico='" + historicoMedico + '\'' +
                '}';
    }

    public Pacientes(LocalDate fechaNacimiento, String telefono, String direccion, String historicoMedico) {
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.historicoMedico = historicoMedico;
    }

    public Pacientes(int usuario_id, String nombre, String apellido, String email, String contrasena, Rol rol, LocalDateTime fecha_creacion, LocalDateTime fecha_ultima_conexion, LocalDate fechaNacimiento, String telefono, String direccion, String historicoMedico) {
        super(usuario_id, nombre, apellido, email, contrasena, rol, fecha_creacion, fecha_ultima_conexion);
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.historicoMedico = historicoMedico;
    }


}