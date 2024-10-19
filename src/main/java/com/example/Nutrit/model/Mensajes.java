package com.example.Nutrit.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Mensajes")
    public class Mensajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mensajes_id")
    private int mensajesId;

    @ManyToOne
    @JoinColumn(name = "emisor_id")
    private UsuariosEntity emisor; // Relación con Usuarios

    @ManyToOne
    @JoinColumn(name = "receptor_id")
    private UsuariosEntity receptor; // Relación con Usuarios

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "fecha_envio")
    private LocalDateTime fechaEnvio = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoMensaje estado = EstadoMensaje.NO_LEIDO;

    // Getters y Setters

    public int getMensajesId() {
        return mensajesId;
    }

    public void setMensajesId(int mensajesId) {
        this.mensajesId = mensajesId;
    }

    public UsuariosEntity getEmisor() {
        return emisor;
    }

    public void setEmisor(UsuariosEntity emisor) {
        this.emisor = emisor;
    }

    public UsuariosEntity getReceptor() {
        return receptor;
    }

    public void setReceptor(UsuariosEntity receptor) {
        this.receptor = receptor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public EstadoMensaje getEstado() {
        return estado;
    }

    public void setEstado(EstadoMensaje estado) {
        this.estado = estado;
    }

    // Constructores

    public Mensajes() {
    }

    public Mensajes(int mensajesId, UsuariosEntity emisor, UsuariosEntity receptor, String contenido, LocalDateTime fechaEnvio, EstadoMensaje estado) {
        this.mensajesId = mensajesId;
        this.emisor = emisor;
        this.receptor = receptor;
        this.contenido = contenido;
        this.fechaEnvio = fechaEnvio;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Mensajes{" +
                "mensajesId=" + mensajesId +
                ", emisor=" + emisor +
                ", receptor=" + receptor +
                ", contenido='" + contenido + '\'' +
                ", fechaEnvio=" + fechaEnvio +
                ", estado=" + estado +
                '}';
    }
}