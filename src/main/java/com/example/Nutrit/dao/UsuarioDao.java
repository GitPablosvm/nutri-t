package com.example.Nutrit.dao;

import com.example.Nutrit.model.UsuariosEntity;
import java.util.List;

public interface UsuarioDao {

    List<UsuariosEntity> getUsuarios();
    void eliminarUsuario(Long id);
    void registrar(UsuariosEntity usuario);

}