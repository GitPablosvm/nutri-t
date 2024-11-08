package com.example.Nutrit.model;

import com.example.Nutrit.model.UsuariosEntity;

public class UsuarioDto {
    private String username;
    private String email;

    public UsuarioDto(UsuariosEntity usuario) {
        this.username = usuario.getUsername();
        this.email = usuario.getEmail();
    }

    // Getters y setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
