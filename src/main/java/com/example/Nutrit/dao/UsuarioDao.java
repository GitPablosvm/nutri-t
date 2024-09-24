package com.example.Nutrit.dao;

import com.example.Nutrit.model.Usuarios;
import java.util.List;

public interface UsuarioDao {

    List<Usuarios> getUsuarios();
    void eliminarUsuario(Long id);
    void registrar(Usuarios usuario);

}