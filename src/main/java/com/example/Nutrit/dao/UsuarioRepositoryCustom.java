package com.example.Nutrit.dao;

import com.example.Nutrit.model.Usuario;
import java.util.List;

public interface UsuarioRepositoryCustom {
    List<Usuario> getUsuarios();
    void eliminarUsuario(Long id);
    void registrar(Usuario usuario);
    List<Usuario> getUsuariosPorRol(String rol);
}