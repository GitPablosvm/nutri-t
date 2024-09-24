package com.example.Nutrit.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

    @Entity
    @Table (name="Usuarios")
    public class Usuarios {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "usuario_id")
        private int usuario_id;

        @Column(name = "nombre")
        private String nombre;

        @Column(name = "apellido")
        private String apellido;

        @Column(name = "email")
        private String email;

        @Column(name = "contrasena")
        private String contrasena;

        @Enumerated(EnumType.STRING)
        @Column(name = "Rol")
        private Rol rol;

        @Column(name = "fecha_creacion")
        private LocalDateTime fecha_creacion;

        @Column(name = "fecha_ultima_conexion")
        private LocalDateTime fecha_ultima_conexion;


        // Getters y Setters
        public int getUsuario_id() {
            return usuario_id;
        }

        public void setUsuario_id(int usuario_id) {
            this.usuario_id = usuario_id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getContrasena() {
            return contrasena;
        }

        public void setContrasena(String contrasena) {
            this.contrasena = contrasena;
        }

        public Rol getRol() {
            return rol;
        }

        public void setRol(Rol rol) {
            this.rol = rol;
        }

        public LocalDateTime getFecha_creacion() {
            return fecha_creacion;
        }

        public void setFecha_creacion(LocalDateTime fecha_creacion) {
            this.fecha_creacion = fecha_creacion;
        }

        public LocalDateTime getFecha_ultima_conexion() {
            return fecha_ultima_conexion;
        }

        public void setFecha_ultima_conexion(LocalDateTime fecha_ultima_conexion) {
            this.fecha_ultima_conexion = fecha_ultima_conexion;
        }

        //Constructores
        public Usuarios() {
        }

        public Usuarios(int usuario_id, String nombre, String apellido, String email, String contrasena, Rol rol, LocalDateTime fecha_creacion, LocalDateTime fecha_ultima_conexion) {
            this.usuario_id = usuario_id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.email = email;
            this.contrasena = contrasena;
            this.rol = rol;
            this.fecha_creacion = fecha_creacion;
            this.fecha_ultima_conexion = fecha_ultima_conexion;
        }

        @Override
        public String toString() {
            return "Usuarios{" +
                    "usuario_id=" + usuario_id +
                    ", nombre='" + nombre + '\'' +
                    ", apellido='" + apellido + '\'' +
                    ", email='" + email + '\'' +
                    ", contrasena='" + contrasena + '\'' +
                    ", rol=" + rol +
                    ", fecha_creacion=" + fecha_creacion +
                    ", fecha_ultima_conexion=" + fecha_ultima_conexion +
                    '}';
        }
    }