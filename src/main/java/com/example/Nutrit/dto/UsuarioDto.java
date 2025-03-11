package com.example.Nutrit.dto;

public class UsuarioDto {
    private Integer id;
    private String nombreUsuario;
    private String email;
    private String rol;

    public UsuarioDto(Integer id, String nombreUsuario, String email, String rol) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getRol() {
        return rol;
    }
}
