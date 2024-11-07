package com.example.Nutrit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
    @Table (name="usuarios")
    @Data
    @NoArgsConstructor
    public class UsuariosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuario_id;

    private String username;

    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name= "user_roles", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name= "roles_id", referencedColumnName = "id"))

    private List<Roles> roles = new ArrayList<>();



        @Column(name = "nombre")
        private String nombre;

        @Column(name = "apellido")
        private String apellido;

        @Column(name = "email")
        private String email;

        @Enumerated(EnumType.STRING)
        @Column(name = "Rol")
        private Rol rol;

        @Column(name = "fecha_creacion")
        private LocalDateTime fecha_creacion;

        @Column(name = "fecha_ultima_conexion")
        private LocalDateTime fecha_ultima_conexion;




        @Override
        public String toString() {
            return "usuarios{" +
                    "usuario_id=" + usuario_id +
                    ", nombre='" + nombre + '\'' +
                    ", apellido='" + apellido + '\'' +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", rol=" + rol +
                    ", fecha_creacion=" + fecha_creacion +
                    ", fecha_ultima_conexion=" + fecha_ultima_conexion +
                    '}';
        }
    }


