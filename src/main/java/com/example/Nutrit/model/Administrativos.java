package com.example.Nutrit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "Administrativos")
@Data
@NoArgsConstructor
public class Administrativos {

    @Id
    @Column(name = "administrativo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int administrativoId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "administrativo_id")
    private UsuariosEntity usuario;

    @Column(name = "area_responsable", nullable = false)
    private String areaResponsable;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @Column(name = "perfil")
    private String perfil;
}

