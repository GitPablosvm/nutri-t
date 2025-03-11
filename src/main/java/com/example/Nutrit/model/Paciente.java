package com.example.Nutrit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pacientes")
@Data
@NoArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paciente_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "obra_social", length = 50)
    private String obraSocial;

    @Column(name = "altura")
    private Double altura;

    @Column(name = "peso_inicial")
    private Double pesoInicial;

    @Column(name = "peso_objetivo")
    private Double pesoObjetivo;

}
