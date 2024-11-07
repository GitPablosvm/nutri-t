package com.example.Nutrit.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name="nuevo_turno")
public class NuevoTurno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_nt")
    private long id_nt;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "dni")
    private String dni;

    @Column(name = "fecha")
    private LocalDateTime fecha;


}

