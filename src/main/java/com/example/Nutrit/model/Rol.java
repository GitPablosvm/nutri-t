package com.example.Nutrit.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Collection;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "roles")
    private Collection<Usuario> usuarios;
}
