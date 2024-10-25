package com.example.Nutrit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "Medicos")
@Data
@NoArgsConstructor
public class Medicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicoId;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private UsuariosEntity usuario;

    @ManyToMany
    @JoinTable(
            name = "medico_especialidad",
            joinColumns = @JoinColumn(name = "medico_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidad_id")
    )
    private Set<Especialidad> especialidades;
}
