package com.example.Nutrit.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pacientes")
    public class Pacientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paciente_id")
    private int pacienteId;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private UsuariosEntity usuario;  // Relación con Usuarios

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "historico_medico")
    private String historicoMedico;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @Column(name = "peso_inicial")
    private Double pesoInicial;

    @Column(name = "peso_objetivo")
    private Double pesoObjetivo;

    //Getter y Setter
    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public UsuariosEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosEntity usuario) {
        this.usuario = usuario;
    }

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

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(Double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public Double getPesoObjetivo() {
        return pesoObjetivo;
    }

    public void setPesoObjetivo(Double pesoObjetivo) {
        this.pesoObjetivo = pesoObjetivo;
    }

    //Constructores
    public Pacientes() {
    }

    public Pacientes(int pacienteId, UsuariosEntity usuario, LocalDate fechaNacimiento, String telefono, String direccion, String historicoMedico, LocalDateTime fechaRegistro, Double pesoInicial, Double pesoObjetivo) {
        this.pacienteId = pacienteId;
        this.usuario = usuario;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.historicoMedico = historicoMedico;
        this.fechaRegistro = fechaRegistro;
        this.pesoInicial = pesoInicial;
        this.pesoObjetivo = pesoObjetivo;
    }
}