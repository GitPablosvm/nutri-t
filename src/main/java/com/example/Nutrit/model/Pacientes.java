package com.example.Nutrit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pacientes")
@Data
@NoArgsConstructor
public class Pacientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pacienteId;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private UsuariosEntity usuario;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "historico_medico", columnDefinition = "TEXT")
    private String historicoMedico;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "peso_inicial")
    private Double pesoInicial;

    @Column(name = "peso_objetivo")
    private Double pesoObjetivo;
}
